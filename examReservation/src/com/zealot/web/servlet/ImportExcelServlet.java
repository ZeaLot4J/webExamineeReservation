package com.zealot.web.servlet;

import java.io.IOException;
import java.util.Map;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.jsp.JspFactory;
import javax.servlet.jsp.PageContext;

import com.zealot.util.FileUploadUtil;
import com.zealot.util.ImportAndExportExcel;
import com.zealot.web.model.JsonModel;

public class ImportExcelServlet extends BasicServlet{
	private static final long serialVersionUID = 1L;

	@Override
	protected void doPost(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
		if(op!=null && !"".equals(op)){
			if("importStuInfo".equals(op)){
				doImportStu(req,resp);
			}else if("importExamInfo".equals(op)){
				doImportExam(req,resp);
			}
		}
	}

	private void doImportExam(HttpServletRequest req, HttpServletResponse resp) {
		FileUploadUtil upload=new FileUploadUtil();

		PageContext pageContext=JspFactory.getDefaultFactory().getPageContext(this, req, resp, null, true, 1024, true);
		
		Map<String, String> map=upload.fileUpload(pageContext);
		
		int res = ImportAndExportExcel.importExamination(pageContext.getServletContext().getRealPath("/")+map.get("excel"));
		this.out(resp, String.valueOf(res));
	}

	private void doImportStu(HttpServletRequest req, HttpServletResponse resp) {
		FileUploadUtil upload=new FileUploadUtil();

		PageContext pageContext=JspFactory.getDefaultFactory().getPageContext(this, req, resp, null, true, 1024, true);
		
		Map<String, String> map=upload.fileUpload(pageContext);
	
		int res = ImportAndExportExcel.importStudent(pageContext.getServletContext().getRealPath("/")+map.get("excel"));
		this.out(resp, String.valueOf(res));
	}
}
