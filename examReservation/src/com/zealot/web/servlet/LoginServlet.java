package com.zealot.web.servlet;

import java.io.IOException;
import java.util.List;
import java.util.Map;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import com.zealot.bean.Administrator;
import com.zealot.bean.Student;
import com.zealot.util.ZLConstants;
import com.zealot.web.biz.IUserCheckBiz;
import com.zealot.web.biz.impl.UserCheckBizImpl;
import com.zealot.web.model.JsonModel;

public class LoginServlet extends BasicServlet {
	private static final long serialVersionUID = 1L;

	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		if(op!=null & !"".equals(op)){
			if("admin".equals(op)){
				doAdminLogin(request,response);
			}else if("stu".equals(op)){
				doStuLogin(request,response);
			}else if("logout".equals(op)){
				doLogout(request,response);
			}else if("stuCheck".equals(op)){
				doCheck(request,response);
			}else if("stuModify".equals(op)){
				doModify(request,response);
			}
		}
	}

	private void doModify(HttpServletRequest request, HttpServletResponse response) {
		JsonModel jm = new JsonModel();
		HttpSession session = request.getSession();
		Student stu = (Student) session.getAttribute(ZLConstants.USER);
		try {
			String pwd = request.getParameter("pwd");
			IUserCheckBiz iucb = new UserCheckBizImpl();
			int res = iucb.modifyStuPwd(stu.getSno(),pwd);
			if(res>0){
				jm.setCode(1);
			}else{
				jm.setCode(0);
			}
			super.outJson(jm, response);
		}catch(IOException e){
			e.printStackTrace();
		}
	}

	private void doCheck(HttpServletRequest request, HttpServletResponse response) {
		JsonModel jm = new JsonModel();
		HttpSession session = request.getSession();
		Student stu = (Student) session.getAttribute(ZLConstants.USER);
		try {
			String pwd = request.getParameter("pwd");
			IUserCheckBiz iucb = new UserCheckBizImpl();
			List<Student> res = iucb.checkStudent(stu.getSno(),pwd);
			if(res.size()>0){
				jm.setCode(1);
			}else{
				jm.setCode(0);
			}
			super.outJson(jm, response);
		}catch(IOException e){
			e.printStackTrace();
		}
	}

	private void doLogout(HttpServletRequest request, HttpServletResponse response) {
		HttpSession session = request.getSession();
		try {
			session.setMaxInactiveInterval(0);
			session.removeAttribute(ZLConstants.USER);
			JsonModel jm = new JsonModel();
			jm.setCode(1);
			super.outJson(jm, response);
		} catch (IOException e) {
			e.printStackTrace();
		}
	}

	private void doStuLogin(HttpServletRequest request, HttpServletResponse response) {
		JsonModel jm = new JsonModel();
		HttpSession session = request.getSession();
		try {
	 		if(!request.getParameter("verifycode").equalsIgnoreCase(session.getAttribute(ZLConstants.VERIFYCODE).toString())){
				jm.setCode(0);
				jm.setErrorMsg("验证码错误!");
				super.outJson(jm, response);
				return;
			}
			Student stu = super.parseRequest(request, Student.class);
			IUserCheckBiz iucb = new UserCheckBizImpl();
			List<Student> res = iucb.checkStudent(stu.getSno(),stu.getSpwd());
			if(res.size()>0){
				stu = res.get(0);
				stu.setSpwd("");
				if(!"".equals(stu.getSavator())){
					System.out.println("头像:"+stu.getSavator());
					stu.setSavator("../"+stu.getSavator());
					System.out.println("头像:"+stu.getSavator());
				}
				if(stu.getAutologin()!=null){//如果点了自动登录
					session.setMaxInactiveInterval(14*24*60*60*1000);//自动登录14天
				}
				session.setAttribute(ZLConstants.USER, stu);
				jm.setCode(1);
			}else{//如果不存在
				jm.setCode(0);
				jm.setErrorMsg("用户名或密码错误!");
			}
			super.outJson(jm, response);
		} catch (IOException e) {
			e.printStackTrace();
		}
	}

	private void doAdminLogin(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		JsonModel jm = new JsonModel();
		HttpSession session = request.getSession();
		try {
			if(!request.getParameter("verifycode").equalsIgnoreCase(session.getAttribute(ZLConstants.VERIFYCODE).toString())){
				jm.setCode(0);
				jm.setErrorMsg("验证码错误!");
				super.outJson(jm, response);
				return;
			}
			Administrator admin = super.parseRequest(request, Administrator.class);
			IUserCheckBiz iucb = new UserCheckBizImpl();
		
			if(iucb.checkAdmin(admin.getAname(),admin.getApwd())>0){
				admin.setApwd("");
				session.setAttribute(ZLConstants.USER, admin);
				if(admin.getAutologin()!=null){//如果点了自动登录
					session.setMaxInactiveInterval(14*24*60*60*1000);//自动登录14天
				}
				jm.setCode(1);
			}else{//如果不存在
				jm.setCode(0);
				jm.setErrorMsg("用户名或密码错误!");
			}
			super.outJson(jm, response);
		} catch (IOException e) {
			e.printStackTrace();
		}
	}
}
