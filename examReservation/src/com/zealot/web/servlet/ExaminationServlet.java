package com.zealot.web.servlet;

import java.io.IOException; 
import java.util.List;
import java.util.Map;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;
import javax.servlet.jsp.JspFactory;
import javax.servlet.jsp.PageContext;

import com.zealot.web.biz.IExaminationBiz;
import com.zealot.web.biz.impl.ExaminationBizImpl;
import com.zealot.web.model.JsonModel;
import com.zealot.bean.Student;
import com.zealot.util.FileUploadUtil;
import com.zealot.util.ZLConstants;

public class ExaminationServlet extends BasicServlet{
	@Override
	protected void doPost(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
		if(op!=null && !"".equals(op)){
			if("all".equals(op)){
				getAllExaminations(req,resp);
			}else if("add".equals(op)){
				addExamination(req,resp);
			}else if("del".equals(op)){
				delExamination(req,resp);
			}else if("edit".equals(op)){
				editExamination(req,resp);
			}else if("getByPage".equals(op)){
				getExaminationsByPage(req,resp);
			}else if("searchExam".equals(op)){
				getExaminationByName(req,resp);
			}
		}
	}
	
	private void getExaminationByName(HttpServletRequest req, HttpServletResponse resp) {
		String ename = req.getParameter("ename");
		IExaminationBiz ieb = new ExaminationBizImpl();
		JsonModel jm = new JsonModel();
		HttpSession session = req.getSession();
		Student stu = (Student) session.getAttribute(ZLConstants.USER);
		List<Map<String,Object>> exams = ieb.getExaminationByName(stu.getSno(),ename);
		try {
			if(exams.size()>0){
				jm.setCode(1);
				jm.setObj(exams);
			}else{
				jm.setCode(0);
				jm.setErrorMsg("加载失败");
			}
			super.outJson(jm, resp);
		} catch (IOException e) {
			e.printStackTrace();
		}
	}

	private void getExaminationsByPage(HttpServletRequest req, HttpServletResponse resp) {
		String pageNum = req.getParameter("pageNum");
		String pageSize = req.getParameter("pageSize");
		IExaminationBiz ieb = new ExaminationBizImpl();
		HttpSession session = req.getSession();
		Student stu = (Student) session.getAttribute(ZLConstants.USER);
		JsonModel jm = new JsonModel();
		List<Map<String,Object>> exams = ieb.getExaminationsByPage(stu.getSno(),pageNum,pageSize);
		try {
			if(exams.size()>0){
				jm.setCode(1);
				jm.setObj(exams);
			}else{
				jm.setCode(0);
				jm.setErrorMsg("加载失败");
			}
			super.outJson(jm, resp);
		} catch (IOException e) {
			e.printStackTrace();
		}
	}

	private void editExamination(HttpServletRequest req, HttpServletResponse resp) {
		FileUploadUtil upload=new FileUploadUtil();
		IExaminationBiz ieb = new ExaminationBizImpl();
		PageContext pageContext=JspFactory.getDefaultFactory().getPageContext(this, req, resp, null, true, 1024, true);
		
		Map<String, String> map=upload.fileUpload(pageContext);
		System.out.println(map.get("ename")+map.get("estart")+map.get("eend")+Integer.parseInt(map.get("emaxnum"))+map.get("edscp")+map.get("epic2")+map.get("eid"));
		int result=ieb.editExamination(map.get("ename"), map.get("estart"), map.get("eend"), Integer.parseInt(map.get("emaxnum")), map.get("edscp"),map.get("epic2"),map.get("eid") );
		
		this.out(resp, String.valueOf(result));
		
	}

	private void delExamination(HttpServletRequest req, HttpServletResponse resp) {
		String eid=req.getParameter("eids");
//		System.out.println("eid="+ eid);
		IExaminationBiz ieb = new ExaminationBizImpl();
		int result=ieb.delExamination(eid);
		this.out(resp, result);
	}

	private void addExamination(HttpServletRequest req, HttpServletResponse resp) {
		FileUploadUtil upload=new FileUploadUtil();
		IExaminationBiz ieb = new ExaminationBizImpl();
		PageContext pageContext=JspFactory.getDefaultFactory().getPageContext(this, req, resp, null, true, 1024, true);
		
		Map<String, String> map=upload.fileUpload(pageContext);
		
	
		
		int result;
		try {
			result = ieb.addExamination(map.get("ename"), map.get("estart"), map.get("eend"), Integer.parseInt(map.get("emaxnum")), map.get("edscp"),map.get("epic") );
			this.out(resp, String.valueOf(result));

		} catch (Exception e) {
			e.printStackTrace();
		}
		
	}

	private void getAllExaminations(HttpServletRequest req, HttpServletResponse resp) {
		IExaminationBiz ieb = new ExaminationBizImpl();
		List<Map<String,Object>> exams = ieb.getAllExaminations();
		super.out(resp, exams);
	}
}
