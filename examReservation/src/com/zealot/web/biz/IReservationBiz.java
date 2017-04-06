package com.zealot.web.biz;

import java.util.List;
import java.util.Map;

public interface IReservationBiz {

	List<Map<String, Object>> getReservationPerStuInDate(String sno);
	public List<Map<String, Object>> getReservationPerStuOutOfDate(String sno);
	int reserveExam(int eid, String sno);
	int cancelReservation(String eid, String sno);
	int removeReservation(String eid, String sno);
	List<Map<String, Object>> getAllReservationInDate();
	List<Map<String, Object>> getAllReservationOutOfDate();
}
