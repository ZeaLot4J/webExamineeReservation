package com.zealot.web.servlet;

import java.io.IOException;
import java.util.List;
import java.util.Map;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import com.zealot.web.biz.IAdminBiz;
import com.zealot.web.biz.impl.AdminBizImpl;

public class AdminServlet extends BasicServlet{
	@Override
	protected void doPost(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
		if(op!=null && !"".equals(op)){
			if("all".equals(op)){
				getAllAdmins(req,resp);
			}
		}
	}

	private void getAllAdmins(HttpServletRequest req, HttpServletResponse resp) {
		IAdminBiz iab = new AdminBizImpl();
		List<Map<String,Object>> admins = iab.getAllAdmins();
		super.out(resp, admins);
	}
}
