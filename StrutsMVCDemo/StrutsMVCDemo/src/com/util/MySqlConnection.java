package com.util;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;

public class MySqlConnection 
{
	public static Connection getConnection()
	{
		Connection con=null;
		String driverName="com.mysql.jdbc.Driver";
		String url="jdbc:mysql://localhost:3306/test";
		String user="root";
		String password="sysadmin";
		
		try 
		{
			Class.forName(driverName);
			con=DriverManager.getConnection(url, user, password);
			//System.out.println(con);
		}
		catch (ClassNotFoundException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		
		return con;
	}
	
}
