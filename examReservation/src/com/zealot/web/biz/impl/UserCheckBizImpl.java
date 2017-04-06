package com.zealot.web.biz.impl;

import java.util.List;
import java.util.Map;

import com.zealot.bean.Student;
import com.zealot.dao.DBHelper;
import com.zealot.util.Encrypt;
import com.zealot.web.biz.IUserCheckBiz;

public class UserCheckBizImpl implements IUserCheckBiz{
	public static void main(String[] args) {
//		System.out.println(Encrypt.md5("admin"));
	}
	@Override
	public int checkAdmin(String userName, String password) {
		DBHelper dao = new DBHelper();
		password = Encrypt.md5(password);
		String sql = "select * from exam_admin where aname=? and apwd=?";
		List<Map<String,Object>> res = dao.findSingle(sql,userName,password);
		System.out.println(res.size());
		return res.size();
	}

	@Override
	public List<Student> checkStudent(String userName, String password) {
		DBHelper dao = new DBHelper();
		password = Encrypt.md5(password);
		System.out.println(userName+" "+password);
		String sql = "select * from exam_stu where sno=? and spwd=?";
		List<Student> res = dao.find(sql, Student.class, userName,password);
		return res;
	}
	@Override
	public int modifyStuPwd(String sno, String password) {
		DBHelper dao = new DBHelper();
		password = Encrypt.md5(password);
		String sql = "update exam_stu set spwd=? where sno=?";
		int res = dao.update(sql, password,sno);
		return res;
	}

}
