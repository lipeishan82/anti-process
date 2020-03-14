package com.anti.utils;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;

public class JDBCUtils {
	//�������������������ݿ�����
	public static Connection getConnection() throws ClassNotFoundException, SQLException{
		Connection conn=null;
		try {
			Class.forName("com.mysql.jdbc.Driver");
		} catch (ClassNotFoundException e1) {
			System.out.println("������������");
			//e1.printStackTrace();
		}
		String url = "jdbc:mysql://localhost:3306/dis_demo?useUnicode=true&characterEncoding=utf8&serverTimezone=GMT%2B8&useSSL=false";
		String user = "root";
		String pwd = "123456";
		try{
		       conn = DriverManager.getConnection(url, user, pwd);
		       //statement = conn.createStatement();
		}
		catch(Exception e) {
			System.out.println("�������ݿ�ʧ��");
            System.out.println(e.getMessage());
		}
		return conn;
		 
	}
	//�ر����ݿ����ӣ��ͷ���Դ
	public static void release(ResultSet rs,Statement stmt,Connection conn){
		if(rs!=null){
			try {
				rs.close();
			} catch (SQLException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}
		}
		if(stmt!=null){
			try {
				stmt.close();
			} catch (SQLException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}
		}
		if(conn!=null){
			try {
				conn.close();
			} catch (SQLException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}
		}
	}
}
