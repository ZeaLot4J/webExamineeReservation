package com.zealot.web.biz.impl;

import java.util.List;
import java.util.Map;

import com.zealot.dao.DBHelper;
import com.zealot.web.biz.IStudentBiz;

public class StudentBizImpl implements IStudentBiz{

	@Override
	public List<Map<String, Object>> getAllStudents() {
		DBHelper stuDao = new DBHelper();
		String sql = "select * from exam_stu";
		return stuDao.findSingle(sql);
	}

	@Override
	public int saveInfo(String sbirth, String semail, String sunivsersity, String stel, String savator, String sno) {
		System.out.println("sbirth="+sbirth);
		System.out.println("semail="+semail);
		System.out.println("sunivsersity="+sunivsersity);
		System.out.println("stel="+stel);
		System.out.println("savator="+savator);
		DBHelper stuDao = new DBHelper();
		String sql = "update exam_stu set sbirth=?,semail=?,sunivsersity=?,stel=?,savator=? where sno = ?";
		return stuDao.update(sql, sbirth,semail,sunivsersity,stel,savator,sno);
	}
	
}
