package com.zealot.web.biz;

import java.util.List;
import java.util.Map;

public interface IExaminationBiz {

	List<Map<String, Object>> getAllExaminations();

	int addExamination(String ename, String estart, String eend, int emaxnum, String edscp, String epic);

	int delExamination(String eid);

	int editExamination(String ename, String estart, String eend, int emaxnum, String edscp, String epic, String eid);

	List<Map<String, Object>> getExaminationsByPage(String sno,String pagNum,String pageSize);

	List<Map<String, Object>> getExaminationByName(String sno,String ename);
	
}	
