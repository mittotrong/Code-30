package com.dao;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;

import com.bean.LoginBean;
import com.util.MySqlConnection;

public class LoginDao 
{
	
	public boolean loginAuth(LoginBean bean) {
		boolean isLogin=false;
		PreparedStatement ps=null;
		ResultSet rs=null;
		Connection con=null;
		
		con=MySqlConnection.getConnection();
		if (con!=null)
		{
			try 
			{
				ps=con.prepareStatement("select count(*) from emplogin where username=? and password=?");
				ps.setString(1,bean.getUserName());
				ps.setString(2,bean.getPassword());
				rs=ps.executeQuery();
				
				while (rs.next()) {
					int row=rs.getInt("count(*)");
					if(row==1)
					{
						isLogin=true;
					}
				}
			} catch (SQLException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}
		}
		return isLogin;
	}
}
