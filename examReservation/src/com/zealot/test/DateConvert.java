package com.zealot.test;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;
import java.sql.Statement;
import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.Date;

import org.eclipse.jdt.internal.compiler.ast.SynchronizedStatement;

public class DateConvert {
	public static void main(String[] args) throws ParseException {
		String param = "2016-11-12";
		SimpleDateFormat sdf = new SimpleDateFormat();
		Date d = sdf.parse(param);
		System.out.println(d.getYear()+"年"+d.getMonth()+"月"+d.getDay()+"日");
		
//		String sql = "insert into temp values("+param+")";
//		Connection con=null;
//		Statement stmt = null;
//		try {
//			Class.forName("com.mysql.jdbc.Driver");
//			con = DriverManager.getConnection("jdbc:mysql://localhost:3306/examReservation","root","a");//?useUnicode=true&characterEncoding=utf-8
//			stmt = con.createStatement();
//			
//			stmt.executeUpdate(sql);
//		} catch (Exception e) {
//			e.printStackTrace();
//		} finally{
//			if(stmt!=null){
//				try {
//					stmt.close();
//				} catch (SQLException e) {
//					e.printStackTrace();
//				}
//			}
//			if(con!=null){
//				try {
//					con.close();
//				} catch (SQLException e) {
//					e.printStackTrace();
//				}
//			}
//		}
	}
}
