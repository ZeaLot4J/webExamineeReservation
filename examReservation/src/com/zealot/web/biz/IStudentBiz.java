package com.zealot.web.biz;

import java.util.List;
import java.util.Map;

public interface IStudentBiz {

	public List<Map<String,Object>> getAllStudents();

	public int saveInfo(String sbirth, String semail, String sunivsersity, String stel, String savator, String sno);
	
}
