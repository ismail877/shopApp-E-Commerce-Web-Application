package com.shopApp.dbHandler;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;



public class DataInjector {
	public static String addCustomer(String uname,String mail,String pass,String gender,String address) {
		String driver="com.mysql.jdbc.Driver";
		String url="jdbc:mysql://localhost:3306/shop?useUnicode=true&characterEncoding=UTF-8&useOldUTF8Behavior=true";
		String username="root";
		String password="password";
		String sql="INSERT INTO customers VALUES(?,?,?,?,?)";
		String regStatus="";
		try {
			Class.forName(driver);
			Connection conn= DriverManager.getConnection(url,username,password);
			PreparedStatement pstmt = conn.prepareStatement(sql);
			
			pstmt.setString(1, uname);
			pstmt.setString(2, mail);
			pstmt.setString(3, pass);
			pstmt.setString(4, gender);
			pstmt.setString(5, address);
			
			pstmt.execute();
			
			regStatus="Successfully Registered";
			
		}
		catch (Exception e) 
		{
			System.out.println("Problem Occurred in Adding Customer");
			e.printStackTrace();
			regStatus="Fail to Register";
			
		}
		finally {
			return regStatus; 
			}
	}
	public static boolean addProduct(int pid,String pname,String pdesc,int pprice,String pimg){
		
		String url="jdbc:mysql://localhost:3306/shop?useUnicode=true&characterEncoding=UTF-8&useOldUTF8Behavior=true";
		String user="root";
		String password="password";
		String sql="INSERT INTO products VALUES(?,?,?,?,?)";
		try{
			Class.forName("com.mysql.jdbc.Driver");
			Connection con=DriverManager.getConnection(url, user, password);
			PreparedStatement ps=con.prepareStatement(sql);
			ps.setInt(1, pid);
			ps.setString(2, pname);
			ps.setString(3, pdesc);
			ps.setInt(4, pprice);
			ps.setString(5, pimg);
			ps.executeUpdate();
		}catch(Exception e){
			System.out.println("Problem in adding product");
			e.printStackTrace();
			return false;
		}			
		return true;
	}
}
