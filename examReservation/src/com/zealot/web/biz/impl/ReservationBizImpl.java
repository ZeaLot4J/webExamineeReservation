package com.zealot.web.biz.impl;

import java.util.List;
import java.util.Map;

import com.zealot.dao.DBHelper;
import com.zealot.web.biz.IReservationBiz;

public class ReservationBizImpl implements IReservationBiz{

	@Override
	public List<Map<String, Object>> getReservationPerStuInDate(String sno) {//未过期的
		DBHelper reserveDao = new DBHelper();
		String sql = "select * from v_reservation where outofdate=0 and sno = ?";
		return reserveDao.findSingle(sql, sno);
	}
	@Override
	public List<Map<String, Object>> getReservationPerStuOutOfDate(String sno) {//过期的
		DBHelper reserveDao = new DBHelper();
		String sql = "select * from v_reservation where outofdate=1 and sno = ?";
		return reserveDao.findSingle(sql, sno);
	}
	@Override
	public int reserveExam(int eid, String sno) {//预约
		DBHelper reserveDao = new DBHelper();
		String sql = "insert into reserve_list(eid,sno,reservetime) values(?,?,now())";
		int res = reserveDao.update(sql,eid,sno);
		sql = "update examination set ecurrnum = ecurrnum+1 where eid=?";
		reserveDao.update(sql, eid);
		return res;
	}
	@Override
	public int cancelReservation(String eid, String sno) {//取消预约
		DBHelper reserveDao = new DBHelper();
		String sql=null;
		int result=0;
		if(eid.contains(",") && !eid.contains(" or ")){ //删除多个
			sql="delete from reserve_list where outofdate=0 and eid in("+eid+") and sno = ?";
			result=reserveDao.update(sql,sno);
			sql = "update examination set ecurrnum = ecurrnum-1 where eid in("+eid+")";
			reserveDao.update(sql);
		}else{
			sql="delete from reserve_list where outofdate=0 and eid=? and sno = ?";
			result=reserveDao.update(sql, eid,sno);
			sql = "update examination set ecurrnum = ecurrnum-1 where eid=?";
			reserveDao.update(sql, eid);
		}
		return result;
	}
	@Override
	public int removeReservation(String eid, String sno) {//删除历史预约
		DBHelper reserveDao = new DBHelper();
		String sql=null;
		int result=0;
		if(eid.contains(",") && !eid.contains(" or ")){ //删除多个
			sql="delete from reserve_list where outofdate=1 and eid in("+eid+") and sno = ?";
			result=reserveDao.update(sql,sno);
		}else{
			sql="delete from reserve_list where outofdate=1 and eid=? and sno = ?";
			result=reserveDao.update(sql, eid,sno);
		}
		return result;
	}
	@Override
	public List<Map<String, Object>> getAllReservationInDate() {
		DBHelper reserveDao = new DBHelper();
		String sql = "select * from v_reservation where outofdate=0";
		return reserveDao.findSingle(sql);
	}
	@Override
	public List<Map<String, Object>> getAllReservationOutOfDate() {
		DBHelper reserveDao = new DBHelper();
		String sql = "select * from v_reservation where outofdate=1";
		return reserveDao.findSingle(sql);
	}
}
