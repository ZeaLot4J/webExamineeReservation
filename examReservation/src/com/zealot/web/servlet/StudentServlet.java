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

import com.zealot.bean.Student;
import com.zealot.util.FileUploadUtil;
import com.zealot.util.ZLConstants;
import com.zealot.web.biz.IExaminationBiz;
import com.zealot.web.biz.IStudentBiz;
import com.zealot.web.biz.impl.ExaminationBizImpl;
import com.zealot.web.biz.impl.StudentBizImpl;

public class StudentServlet extends BasicServlet{

	@Override
	protected void doPost(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
		if(op!=null && !"".equals(op)){
			if("all".equals(op)){
				getAllStudents(req,resp);
			}else if("saveInfo".equals(op)){
				saveStuInfo(req,resp);
			}
		}
	}

	private void saveStuInfo(HttpServletRequest req, HttpServletResponse resp) {
		FileUploadUtil upload=new FileUploadUtil();
		IStudentBiz isb = new StudentBizImpl();
		PageContext pageContext=JspFactory.getDefaultFactory().getPageContext(this, req, resp, null, true, 1024, true);
		
		Map<String, String> map=upload.fileUpload(pageContext);
		
		HttpSession session = req.getSession();
		Student stu = (Student) session.getAttribute(ZLConstants.USER);
		
		int result;
		try {
			result = isb.saveInfo(map.get("sbirth"), map.get("semail"), map.get("sunivsersity"), map.get("stel"),map.get("savator"),stu.getSno());
			if(result>0){//修改成功了
				stu.setSbirth(map.get("sbirth"));
				stu.setSemail(map.get("semail"));
				stu.setSidentity(map.get("sunivsersity"));
				stu.setStel(map.get("stel"));
				stu.setStel(map.get("savator"));
				session.setAttribute(ZLConstants.USER, stu);
				this.out(resp, String.valueOf(result));
			}
		} catch (Exception e) {
			e.printStackTrace();
		}
	}

	private void getAllStudents(HttpServletRequest req, HttpServletResponse resp) {
		IStudentBiz isb = new StudentBizImpl();
		List<Map<String,Object>> stus = isb.getAllStudents();
		super.out(resp, stus);
	}
}
