package com.zealot.web.biz.impl;

import java.util.List;
import java.util.Map;

import com.zealot.dao.DBHelper;
import com.zealot.web.biz.IExaminationBiz;

public class ExaminationBizImpl implements IExaminationBiz{

	@Override
	public List<Map<String, Object>> getAllExaminations() {
		DBHelper examDao = new DBHelper();
		String sql = "select * from examination";
		return examDao.findSingle(sql);
	}

	@Override
	public int addExamination(String ename, String estart,String eend, int emaxnum, String edscp, String epic) {
		DBHelper examDao = new DBHelper();
		String sql = "insert into examination(ename,estart,eend,emaxnum,edscp,epic) values(?,?,?,?,?,?)";
		return examDao.update(sql, ename, estart, eend, emaxnum, edscp, epic);
	}//insert into examination(ename,estart,eend,emaxnum,edscp,epic) values('WSN','2016-9-13 8:30','2016-9-13 9:30',200,'WSNWSN','../ERimage/14812734349211953.png');

	@Override
	public int delExamination(String eid) {
		DBHelper examDao = new DBHelper();
		String sql=null;
		int result=0;
		System.out.println(eid);
		if(eid.contains(",") && !eid.contains(" or ")){ //删除多个
			sql="delete from examination where eid in("+eid+")";
			result=examDao.update(sql);
		}else{
			sql="delete from examination where eid=?";
			result=examDao.update(sql, eid);
		}
		return result;
	}

	@Override
	public int editExamination(String ename, String estart, String eend, int emaxnum, String edscp, String epic,String eid) {
		System.out.println("================================");
		System.out.println(ename+" "+estart+" "+eend+" "+emaxnum+" "+edscp+" "+epic+" "+eid);
		DBHelper examDao = new DBHelper();
		String sql="";
		int result=0;
		if( epic==null || epic.equals("")){
			sql="update examination set ename=?,estart=?,eend=?, emaxnum=?, edscp=? where eid=?";
			result=examDao.update(sql, ename,estart,eend,emaxnum,edscp,eid);
		}else{
			sql="update examination set ename=?,estart=?,eend=?,emaxnum=?,edscp=?,epic=? where eid=?";
			result=examDao.update(sql, ename,estart,eend,emaxnum,edscp,epic,eid);
		}
		return result;
	}

	@Override
	public List<Map<String, Object>> getExaminationsByPage(String sno,String pageNum,String pageSize) {
		DBHelper examDao = new DBHelper();
		String sql = "select * from examination e where e.eid not in (select rl.eid from reserve_list rl where rl.sno=? and rl.outofdate=0) limit "+pageNum+","+pageSize;
		return examDao.findSingle(sql,sno);
	}

	@Override
	public List<Map<String, Object>> getExaminationByName(String sno,String ename) {
		DBHelper examDao = new DBHelper();
		String sql = "select * from examination e where ename like '"+ename+"%'"+" and e.eid not in (select rl.eid from reserve_list rl where rl.sno=? and rl.outofdate=0)";
		return examDao.findSingle(sql,sno);
	}
	
}
