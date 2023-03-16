package com.shopApp.dbHandler;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.Statement;
import java.util.ArrayList;
import java.util.List;

import com.shopApp.product.Product;

public class DataFetcher {
	public static String fetchPassword(String uname) {
		String driver="com.mysql.jdbc.Driver";
		String url = "jdbc:mysql://localhost:3306/shop?useUnicode=true&characterEncoding=UTF-8&useOldUTF8Behavior=true";
		String username="root";
		String password="password";
		String sql="SELECT pass FROM customers WHERE uname=?";
		String dbPass="";
		
		try {
			Class.forName(driver);
			Connection con=DriverManager.getConnection(url,username,password);
			PreparedStatement ps=con.prepareStatement(sql);
			ps.setString(1, uname);
			ResultSet rs=ps.executeQuery();
			rs.next();
			dbPass=rs.getString(1);
			
			
		}catch (Exception e) {
			System.out.println("Login issues");
			e.printStackTrace();
		}
		return dbPass;
		
	}
	public static List fetchUsersInfo() {
		String url="jdbc:mysql://localhost:3306/shop?useUnicode=true&characterEncoding=UTF-8&useOldUTF8Behavior=true";
		String user="root";
		String password="password";
		String sql="SELECT uname,mail,gender,address FROM customers";
		List ulist=new ArrayList();
		try{
			Class.forName("com.mysql.jdbc.Driver");
			Connection con=DriverManager.getConnection(url, user, password);
			Statement st=con.createStatement();
			
			ResultSet rs=st.executeQuery(sql);
			while(rs.next()) {
				String temp=rs.getString(1)+":"+rs.getString(2)+":"+rs.getString(3)+":"+rs.getString(4);
				ulist.add(temp);
			}
			
		}catch(Exception e){
			System.out.println("Problem in Login");
		}			
		return ulist;
}
	public static List fetchProductsInfo() {
		String url="jdbc:mysql://localhost:3306/shop?useUnicode=true&characterEncoding=UTF-8&useOldUTF8Behavior=true";
		String user="root";
		String password="password";
		String sql="SELECT pid,pname,pdesc,pprice,pimg FROM products";
		List ilist=new ArrayList();
		try{
			Class.forName("com.mysql.jdbc.Driver");
			Connection con=DriverManager.getConnection(url, user, password);
			Statement st=con.createStatement();
			
			ResultSet rs=st.executeQuery(sql);
			while(rs.next()) {
				String temp=""+rs.getInt(1)+":"+rs.getString(2)+":"+rs.getString(3)+":"+rs.getInt(4)+":"+rs.getString(5);
				ilist.add(temp);
			}
			
		}catch(Exception e){
			System.out.println("Problem in fetching product");
			e.printStackTrace();
		}			
		return ilist;
	}
	
	public static Product getProductById(int pid) {
		String url="jdbc:mysql://localhost:3306/shop?useUnicode=true&characterEncoding=UTF-8&useOldUTF8Behavior=true";
		String user="root";
		String password="password";
		String sql="SELECT pname,pprice FROM products WHERE pid=?";
		Product p=null;
		
		try{
			Class.forName("com.mysql.jdbc.Driver");
			Connection con=DriverManager.getConnection(url, user, password);
			PreparedStatement ps=con.prepareStatement(sql);
			ps.setInt(1, pid);
			ResultSet rs=ps.executeQuery();
			rs.next();
			String pname=rs.getString(1);
			int pprice=rs.getInt(2);
			
			p=new Product(pid,pname,pprice);
		}catch(Exception e){
			System.out.println("Problem in fetching product by id");
			e.printStackTrace();
		}			
		finally {
			return p;
		}
	}
}
