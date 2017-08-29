package com.dao;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;

import com.bean.HigestQulificationBean;
import com.util.MySqlConnection;

public class HigestQulifictionDao 
{
	public ArrayList getHigetstQulification()
	{
		ArrayList list=new ArrayList();
		HigestQulificationBean bean=null;
		Connection con=null;
		PreparedStatement ps=null;
		ResultSet rs=null;
		
		con=MySqlConnection.getConnection();
		try 
		{
			ps=con.prepareStatement("select * from higest_qulification");
			rs=ps.executeQuery();
			while(rs.next())
			{
				bean=new HigestQulificationBean();
				bean.setQulificationId(rs.getString("qid"));
				bean.setQulificationName(rs.getString("qname"));
				list.add(bean);
			}
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		
		
		return list;
	}
	
	/*public static void main(String[] args) {
		
		ArrayList list=new HigestQulifictionDao().getHigetstQulification();
		HigestQulificationBean bean=null;
		
		for (int i = 0; i < list.size(); i++) 
		{
			bean=(HigestQulificationBean)list.get(i);
			
			System.out.println("Qulification Id :"+bean.getQulificationId());
			System.out.println("Qulification Name :"+bean.getQulificationName());
		}
	}*/
}
