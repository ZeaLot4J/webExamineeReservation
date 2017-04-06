package com.zealot.web.biz.impl;

import java.util.List;
import java.util.Map;

import com.zealot.dao.DBHelper;
import com.zealot.web.biz.IAdminBiz;

public class AdminBizImpl implements IAdminBiz{

	@Override
	public List<Map<String, Object>> getAllAdmins() {
		DBHelper adminDao = new DBHelper();
		String sql = "select * from exam_admin";
		return adminDao.findSingle(sql);
	}

}
