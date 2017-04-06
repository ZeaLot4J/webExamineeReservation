package com.zealot.web.biz.impl;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;
import java.util.List;

import com.mysql.jdbc.CallableStatement;
import com.zealot.bean.Message;
import com.zealot.dao.DBHelper;
import com.zealot.dao.MyProperties;
import com.zealot.util.LogUtil;
import com.zealot.web.biz.IMessageBiz;

public class MessageBizImpl implements IMessageBiz{

	@Override
	public List<Message> getAllStuMessages() {
		String sql = "select * from message where mtype=0";
		DBHelper messageDao = new DBHelper();
		return messageDao.find(sql, Message.class);
	}

	@Override
	public List<Message> getAllAdminMessages() {
		String sql = "select * from message where mtype=1";
		DBHelper messageDao = new DBHelper();
		return messageDao.find(sql, Message.class);
	}

	@Override
	public List<Message> receiveMessagesByNo(String sno) {
		String sql = "select * from message where mtype=1 and sno = ?";
		DBHelper messageDao = new DBHelper();
		return messageDao.find(sql, Message.class,sno);
	}

	@Override
	public int sendStuMessage(String sno, String content) {
		String sql = "insert into message(sno,content,sendtime,mtype) values(?,?,now(),0)";
		DBHelper messageDao = new DBHelper();
		return messageDao.update(sql, sno,content);
	}//insert into message(sno,content,sendtime,mtype) values(?,?,now(),0)

	@Override
	public List<Message> getStuEverSendMessage(String sno) {
		String sql = "select * from message where mtype=0 and sno = ?";
		DBHelper messageDao = new DBHelper();
		return messageDao.find(sql, Message.class,sno);
	}

	@Override
	public int sendToSingleStu(String sno, String content) {
		String sql = "insert into message(sno,content,sendtime,mtype) values(?,?,now(),1)";
		DBHelper messageDao = new DBHelper();
		return messageDao.update(sql, sno,content);
	}

	@Override
	public void sendToAllStu(String content) {
		Connection con = null;
		CallableStatement cstmt = null;
		try {
			Class.forName(MyProperties.getInstance().getProperty("driverClassName"));
			con = DriverManager.getConnection(MyProperties.getInstance().getProperty("url"),MyProperties.getInstance().getProperty("username"),MyProperties.getInstance().getProperty("password"));
			String sql = "{call notifyall(?)}";
			cstmt = (CallableStatement) con.prepareCall(sql);
			cstmt.setString(1, content);
			cstmt.execute();
		} catch (ClassNotFoundException e) {
			e.printStackTrace();
		} catch (SQLException e) {
			e.printStackTrace();
		} finally{
			if(cstmt!=null){
				try {
					cstmt.close();
				} catch (SQLException e) {
					LogUtil.log.error(e.toString());
				}
			}
			if(con!=null){
				try {
					con.close();
				} catch (SQLException e) {
					LogUtil.log.error(e.toString());
				}
			}
		}
	}

	@Override
	public int adminHasRead() {
		String sql = "update message set isnew = 0 where mtype=0 and isnew=1";
		DBHelper messageDao = new DBHelper();
		return messageDao.update(sql);
	}

	@Override
	public int stuHasRead(String sno) {
		String sql = "update message set isnew = 0 where sno=? and mtype=1 and isnew=1";
		DBHelper messageDao = new DBHelper();
		return messageDao.update(sql, sno);
	}

}
