package com.zealot.util;

import java.io.File;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.Map;
import java.util.Properties;
import java.util.Set;

import jxl.Sheet;
import jxl.Workbook;

public class ImportAndExportExcel {
	public static int importStudent(String filePath){
		System.out.println(filePath);
		Connection con=null;
		Statement stmt = null;
		try {
			Class.forName("com.mysql.jdbc.Driver");
			con = DriverManager.getConnection("jdbc:mysql://localhost:3306/examReservation","root","a");//?useUnicode=true&characterEncoding=utf-8
			stmt = con.createStatement();
			Workbook wb = Workbook.getWorkbook(new File(filePath));
			Sheet sht = wb.getSheet(0);
			
			con.setAutoCommit(false);
			for(int r=1,rows=sht.getRows(); r<rows; r++){
				if(stmt.executeUpdate("insert into exam_stu(sno,sname,ssex,stel,semail,sidentity) values('"+sht.getCell(0, r).getContents()+"','"+sht.getCell(1, r).getContents()+"','"+sht.getCell(2, r).getContents()+"','"+sht.getCell(3, r).getContents()+"','"+sht.getCell(4, r).getContents()+"','"+sht.getCell(5, r).getContents()+"')")<=0){
					throw new RuntimeException("导入失败，请检查格式和数据，重新导入");
				}
			}
			con.setAutoCommit(true);
			return 1;
		} catch (Exception e) {
			e.printStackTrace();
			try {
				con.rollback();
			} catch (SQLException e1) {
				e1.printStackTrace();
			}
			return 0;
		} finally{
			if(stmt!=null){
				try {
					stmt.close();
				} catch (SQLException e) {
					e.printStackTrace();
				}
			}
			if(con!=null){
				try {
					con.close();
				} catch (SQLException e) {
					e.printStackTrace();
				}
			}
		}
	}
	public static int importExamination(String filePath){
		System.out.println(filePath);
		Connection con=null;
		Statement stmt = null;
		try {
			Class.forName("com.mysql.jdbc.Driver");
			con = DriverManager.getConnection("jdbc:mysql://localhost:3306/examReservation","root","a");//?useUnicode=true&characterEncoding=utf-8
			stmt = con.createStatement();
			Workbook wb = Workbook.getWorkbook(new File(filePath));
			Sheet sht = wb.getSheet(0);
			
			con.setAutoCommit(false);
			for(int r=1,rows=sht.getRows(); r<rows; r++){
				System.out.println(sht.getCell(0, r).getContents()+"','"+sht.getCell(1, r).getContents()+"','"+sht.getCell(2, r).getContents()+"','"+sht.getCell(3, r).getContents());
				if(stmt.executeUpdate("insert into examination(ename,estart,eend,edscp) values('"+sht.getCell(0, r).getContents()+"','"+sht.getCell(1, r).getContents()+"','"+sht.getCell(2, r).getContents()+"','"+sht.getCell(3, r).getContents()+"')")<=0){
					throw new RuntimeException("导入失败，请检查格式和数据，重新导入");
				}
			}
			con.setAutoCommit(true);
			return 1;
		} catch (Exception e) {
			e.printStackTrace();
			try {
				con.rollback();
			} catch (SQLException e1) {
				e1.printStackTrace();
			}
			return 0;
		} finally{
			if(stmt!=null){
				try {
					stmt.close();
				} catch (SQLException e) {
					e.printStackTrace();
				}
			}
			if(con!=null){
				try {
					con.close();
				} catch (SQLException e) {
					e.printStackTrace();
				}
			}
		}
	}
}
