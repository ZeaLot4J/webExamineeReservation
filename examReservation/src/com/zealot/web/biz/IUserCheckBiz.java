package com.zealot.web.biz;

import java.util.List;
import java.util.Map;

import com.zealot.bean.Student;

public interface IUserCheckBiz {

	public int checkAdmin(String userName, String password);

	public List<Student> checkStudent(String userName, String password);

	public int modifyStuPwd(String sno, String password);
	
}
