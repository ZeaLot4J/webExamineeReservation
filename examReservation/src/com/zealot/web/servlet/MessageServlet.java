package com.zealot.web.servlet;

import java.io.IOException;
import java.util.List;
import java.util.Map;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import com.zealot.bean.Message;
import com.zealot.bean.Student;
import com.zealot.util.ZLConstants;
import com.zealot.web.biz.IMessageBiz;
import com.zealot.web.biz.IReservationBiz;
import com.zealot.web.biz.impl.MessageBizImpl;
import com.zealot.web.biz.impl.ReservationBizImpl;
import com.zealot.web.model.JsonModel;

public class MessageServlet extends BasicServlet{
	@Override
	protected void doPost(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
		if(op!=null && !"".equals(op)){
			if("stuReceive".equals(op)){
				receiveStuMessage(req,resp);//学生收信
			}else if("stuSend".equals(op)){
				sendStuMessage(req,resp);//学生发信
			}else if("stuEverSend".equals(op)){
				getStuEverSendMessage(req,resp);//学生的历史发信
			}else if("adminReceive".equals(op)){
				receiveAdminMessage(req,resp);//管理员收信
			}else if("adminEverSend".equals(op)){
				getAdminEverSendMessage(req,resp);//管理员历史发信
			}else if("multiSend".equals(op)){
				sendToAllStu(req,resp);
			}else if("singleSend".equals(op)){
				sendToSingleStu(req,resp);
			}else if("adminHasRead".equals(op)){
				adminHasRead(req,resp);
			}else if("stuHasRead".equals(op)){
				stuHasRead(req,resp);
			}
		}
	}

	private void stuHasRead(HttpServletRequest req, HttpServletResponse resp) {
		JsonModel jm = new JsonModel();
		IMessageBiz imb = new MessageBizImpl();
		HttpSession session = req.getSession();
		Student stu = (Student) session.getAttribute(ZLConstants.USER);
		int res = imb.stuHasRead(stu.getSno());
		try {
			if(res>0){
				jm.setCode(1);
			}else{
				jm.setCode(0);
				jm.setErrorMsg("页面错误");
			}
			super.outJson(jm, resp);
		} catch (IOException e) {
			e.printStackTrace();
		}
	}

	private void adminHasRead(HttpServletRequest req, HttpServletResponse resp) {
		JsonModel jm = new JsonModel();
		IMessageBiz imb = new MessageBizImpl();
		int res = imb.adminHasRead();
		try {
			if(res>0){
				jm.setCode(1);
			}else{
				jm.setCode(0);
				jm.setErrorMsg("页面错误");
			}
			super.outJson(jm, resp);
		} catch (IOException e) {
			e.printStackTrace();
		}
	}

	private void sendToSingleStu(HttpServletRequest req, HttpServletResponse resp) {
		String sno = req.getParameter("sno");
		String content = req.getParameter("content");
		JsonModel jm = new JsonModel();
		IMessageBiz imb = new MessageBizImpl();
		int res = imb.sendToSingleStu(sno,content);
		try {		
			if(res>0){
				jm.setCode(1);
			}else{
				jm.setCode(0);
				jm.setErrorMsg("发送失败");
			}
			super.outJson(jm, resp);
		} catch (IOException e) {
			e.printStackTrace();
		}
	}

	private void sendToAllStu(HttpServletRequest req, HttpServletResponse resp) {
		String content = req.getParameter("content");
		JsonModel jm = new JsonModel();
		IMessageBiz imb = new MessageBizImpl();
		try{
			imb.sendToAllStu(content);
			jm.setCode(1);
			super.outJson(jm, resp);
		} catch (IOException e) {
			e.printStackTrace();
		}
	}

	private void getAdminEverSendMessage(HttpServletRequest req, HttpServletResponse resp) {
		IMessageBiz imb = new MessageBizImpl();
		List<Message> res = imb.getAllAdminMessages();
		this.out(resp, res);
	}

	private void receiveAdminMessage(HttpServletRequest req, HttpServletResponse resp) {
		IMessageBiz imb = new MessageBizImpl();
		List<Message> res = imb.getAllStuMessages();
		this.out(resp, res);
	}

	private void getStuEverSendMessage(HttpServletRequest req, HttpServletResponse resp) {
		HttpSession session = req.getSession();
		Student stu = (Student) session.getAttribute(ZLConstants.USER);
		IMessageBiz imb = new MessageBizImpl();
		List<Message> res = imb.getStuEverSendMessage(stu.getSno());
		this.out(resp, res);
	}

	private void sendStuMessage(HttpServletRequest req, HttpServletResponse resp) {
		String content = (String) req.getParameter("content");
		HttpSession session = req.getSession();
		Student stu = (Student) session.getAttribute(ZLConstants.USER);
		JsonModel jm = new JsonModel();
		IMessageBiz imb = new MessageBizImpl();
		System.out.println("content="+content+" sno="+stu.getSno());
		int res = imb.sendStuMessage(stu.getSno(),content);
		try {		
			if(res>0){
				jm.setCode(1);
			}else{
				jm.setCode(0);
				jm.setErrorMsg("发送失败");
			}
			super.outJson(jm, resp);
		} catch (IOException e) {
			e.printStackTrace();
		}
	}

	private void receiveStuMessage(HttpServletRequest req, HttpServletResponse resp) {
		HttpSession session = req.getSession();
		Student stu = (Student) session.getAttribute(ZLConstants.USER);
		IMessageBiz imb = new MessageBizImpl();
		List<Message> res = imb.receiveMessagesByNo(stu.getSno());
		this.out(resp, res);
	}
}
