package com.zealot.web.servlet;

import java.io.IOException;
import java.util.List;
import java.util.Map;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import com.zealot.bean.Student;
import com.zealot.util.ZLConstants;
import com.zealot.web.biz.IExaminationBiz;
import com.zealot.web.biz.IReservationBiz;
import com.zealot.web.biz.impl.ExaminationBizImpl;
import com.zealot.web.biz.impl.ReservationBizImpl;
import com.zealot.web.model.JsonModel;

public class ReserveServlet extends BasicServlet{
	@Override
	protected void doPost(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
		if(op!=null && !"".equals(op)){
			if("currStuInDate".equals(op)){
				getReservationPerStuInDate(req,resp);
			}else if("currStuOutOfDate".equals(op)){
				getReservationPerStuOutOfDate(req,resp);
			}else if("reserve".equals(op)){
				doReserve(req,resp);
			}else if("remove".equals(op)){
				removeReservation(req,resp);
			}else if("cancel".equals(op)){
				cancelReservation(req,resp);
			}else if("allOutOfDate".equals(op)){
				getAllReservationOutOfDate(req,resp);
			}else if("allInDate".equals(op)){
				getAllReservationInDate(req,resp);
			}
		}
	}

	private void getAllReservationInDate(HttpServletRequest req, HttpServletResponse resp) {
		IReservationBiz irb = new ReservationBizImpl();
		List<Map<String,Object>> res = irb.getAllReservationInDate();
		this.out(resp, res);
	}

	private void getAllReservationOutOfDate(HttpServletRequest req, HttpServletResponse resp) {
		IReservationBiz irb = new ReservationBizImpl();
		List<Map<String,Object>> res = irb.getAllReservationOutOfDate();
		this.out(resp, res);
	}

	private void cancelReservation(HttpServletRequest req, HttpServletResponse resp) {
		String eid=req.getParameter("eids");
		HttpSession session = req.getSession();
		Student stu = (Student) session.getAttribute(ZLConstants.USER);
		IReservationBiz irb = new ReservationBizImpl();
		int result=irb.cancelReservation(eid,stu.getSno());
		this.out(resp, result);
	}

	private void removeReservation(HttpServletRequest req, HttpServletResponse resp) {
		String eid=req.getParameter("eids");
		HttpSession session = req.getSession();
		Student stu = (Student) session.getAttribute(ZLConstants.USER);
		IReservationBiz irb = new ReservationBizImpl();
		int result=irb.removeReservation(eid,stu.getSno());
		this.out(resp, result);
	}

	private void doReserve(HttpServletRequest req, HttpServletResponse resp) {
		String eid = req.getParameter("eid");
		HttpSession session = req.getSession();
		Student stu = (Student) session.getAttribute(ZLConstants.USER);
		IReservationBiz irb = new ReservationBizImpl();
		JsonModel jm = new JsonModel();
		int res = irb.reserveExam(Integer.parseInt(eid),stu.getSno());
		try {
			if(res>0){
				jm.setCode(1);
			}else{
				jm.setCode(0);
				jm.setErrorMsg("预约失败");
			}
			super.outJson(jm, resp);
		} catch (IOException e) {
			e.printStackTrace();
		}
	}

	private void getReservationPerStuOutOfDate(HttpServletRequest req, HttpServletResponse resp) {
		HttpSession session = req.getSession();
		Student stu = (Student) session.getAttribute(ZLConstants.USER);
		IReservationBiz irb = new ReservationBizImpl();
		List<Map<String,Object>> res = irb.getReservationPerStuOutOfDate(stu.getSno());
		this.out(resp, res);
	}

	private void getReservationPerStuInDate(HttpServletRequest req, HttpServletResponse resp) {
		HttpSession session = req.getSession();
		Student stu = (Student) session.getAttribute(ZLConstants.USER);
		IReservationBiz irb = new ReservationBizImpl();
		List<Map<String,Object>> res = irb.getReservationPerStuInDate(stu.getSno());
		this.out(resp, res);
	}
}
