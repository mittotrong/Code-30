package com.dao;

import java.sql.Connection;
import java.sql.Date;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.text.DateFormat;
import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.ArrayList;

import com.bean.PersonBean;
import com.util.MySqlConnection;

public class PersonRegistrationDao 
{
	Connection con=null;
	
	public boolean registerPerson(PersonBean bean) {
		boolean isRegister=false;
		
		PreparedStatement ps=null;
		ResultSet rs=null;
		DateFormat sdf=new SimpleDateFormat("yyyy/MM/dd");
		java.sql.Date dob = null;
		try 
		{
			java.util.Date date=sdf.parse(bean.getDateOfBirth());
			dob=new Date(date.getTime());
		}
		catch (ParseException e2) {
			// TODO Auto-generated catch block
			e2.printStackTrace();
		}
		
		System.out.println("date "+dob);
		
		con=MySqlConnection.getConnection();
		try {
			ps=con.prepareStatement("insert into person_register(firstname,lastname,gender,dateofbirth,address,mobileno,hid) values(?,?,?,?,?,?,?)");
			ps.setString(1,bean.getFirstName());
			ps.setString(2,bean.getLastName());
			ps.setString(3,bean.getGender());
			ps.setDate(4,dob);
			ps.setString(5,bean.getAddress());
			ps.setString(6,bean.getMobileNo());
			ps.setString(7,bean.getHigestQulification());
			
			int row=ps.executeUpdate();
			if(row==1)
			{
				isRegister=true;
			}
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		finally
		{

			try {
				if (con!=null)
				{
					con.close();
				}
				if (rs!=null)
				{
					rs.close();
				}
				if (ps!=null)
				{
					ps.close();
				}
			} catch (SQLException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}
		
		}
		
		
		return isRegister;
	}
	
	
	public ArrayList allPerson() 
	{
		ArrayList list=new ArrayList();
		PreparedStatement ps=null;
		ResultSet rs=null;
		
		con=MySqlConnection.getConnection();
		try 
		{
			ps=con.prepareStatement("SELECT * FROM person_register");
			rs=ps.executeQuery();
			
			while(rs.next())
			{
				PersonBean bean=new PersonBean();
				bean.setPid(rs.getString("pid"));
				bean.setFirstName(rs.getString("firstname"));
				bean.setLastName(rs.getString("lastname"));
				bean.setGender(rs.getString("gender"));
				bean.setDateOfBirth(rs.getString("dateofbirth"));
				bean.setAddress(rs.getString("address"));
				bean.setMobileNo(rs.getString("mobileno"));
				bean.setHigestQulification(rs.getString("hid"));
				
				list.add(bean);
				
			}
		}
		catch (SQLException e) 
		{
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		finally
		{

			try {
				if (con!=null)
				{
					con.close();
				}
				if (rs!=null)
				{
					rs.close();
				}
				if (ps!=null)
				{
					ps.close();
				}
			} catch (SQLException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}
		
		}
		
		return list;
	}
	
	public PersonBean selectPerson(String pId)
	{
		PersonBean bean=null;
		PreparedStatement ps=null;
		ResultSet rs=null;
		SimpleDateFormat sdf=new SimpleDateFormat("yyyy/MM/dd");
		java.util.Date date=new java.util.Date();
		
		con=MySqlConnection.getConnection();
		try 
		{
			ps=con.prepareStatement("SELECT * FROM person_register  where pid="+pId);
			//ps.setString(1,pId);
			rs=ps.executeQuery();
			while(rs.next())
			{
				bean=new PersonBean();
				bean.setPid(rs.getString("pid"));
				bean.setFirstName(rs.getString("firstname"));
				bean.setLastName(rs.getString("lastname"));
				bean.setGender(rs.getString("gender"));
				
				date=rs.getDate("dateofbirth");
				System.out.println("Data is "+sdf.format(date));
				bean.setDateOfBirth(sdf.format(date));
				bean.setAddress(rs.getString("address"));
				bean.setMobileNo(rs.getString("mobileno"));
				bean.setHigestQulification(rs.getString("hid"));
			}
		}
		catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		finally
		{

			try {
				if (con!=null)
				{
					con.close();
				}
				if (rs!=null)
				{
					rs.close();
				}
				if (ps!=null)
				{
					ps.close();
				}
			} catch (SQLException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}
		
		}
		
		
		return bean;
	}
	
	public boolean updatePerson(PersonBean bean)
	{
		boolean isUpdate=false;
		ResultSet rs=null;
		PreparedStatement ps=null;
		
		DateFormat sdf=new SimpleDateFormat("yyyy/MM/dd");
		java.sql.Date dob = null;
		try 
		{
			java.util.Date date=sdf.parse(bean.getDateOfBirth());
			dob=new Date(date.getTime());
		}
		catch (ParseException e2) {
			// TODO Auto-generated catch block
			e2.printStackTrace();
		}
		
		con=MySqlConnection.getConnection();
		try 
		{
			ps=con.prepareStatement("update person_register set firstname=?, lastname=?, gender=? ,dateofbirth=?,address=?, mobileno=?,hid= ? where pid="+bean.getPid());
			ps.setString(1,bean.getFirstName());
			ps.setString(2,bean.getLastName());
			ps.setString(3,bean.getGender());
			ps.setDate(4,dob);
			ps.setString(5,bean.getAddress());
			ps.setString(6,bean.getMobileNo());
			ps.setString(7,bean.getHigestQulification());
			
			int row=ps.executeUpdate();
			if (row==1) {
				isUpdate=true;
			}
			
		}
		catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		finally
		{

			try {
				if (con!=null)
				{
					con.close();
				}
				if (rs!=null)
				{
					rs.close();
				}
				if (ps!=null)
				{
					ps.close();
				}
			} catch (SQLException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}
		
		}
		
		return isUpdate;
	}
	
	public boolean deletePerson(String pId)
	{
		boolean isDelete=false;
		PreparedStatement ps=null;
		Connection con=null;
		
		con=MySqlConnection.getConnection();
		try 
		{
			ps=con.prepareStatement("delete from person_register where pid=?");
			ps.setString(1,pId);
			int row=ps.executeUpdate();
			if(row==1)
			{
				isDelete=true;
			}
			
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		finally
		{

			try {
				if (con!=null)
				{
					con.close();
				}
				
				if (ps!=null)
				{
					ps.close();
				}
			} catch (SQLException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}
		
		}
		
		
		return isDelete;
	}
	
	public ArrayList generatePdfReport(String pId)
	{
		ArrayList list=new ArrayList();
		PersonBean bean=null;
		ResultSet rs=null;
		PreparedStatement ps=null;
		Connection con=null;
		SimpleDateFormat sdf=new SimpleDateFormat("yyyy/MM/dd");
		java.util.Date date=new java.util.Date();
		
		con=MySqlConnection.getConnection();
		try 
		{
			ps=con.prepareStatement("select p.pid,p.firstname,p.lastname,p.gender,p.dateofbirth,p.address,p.mobileno,h.qname from person_register p,higest_qulification h where p.hid=h.qid and p.pid="+pId);
			rs=ps.executeQuery();
			while (rs.next())
			{
				bean=new PersonBean();
				bean.setPid(rs.getString("pid"));
				bean.setFirstName(rs.getString("firstname"));
				bean.setLastName(rs.getString("lastname"));
				bean.setGender(rs.getString("gender"));
				date=rs.getDate("dateofbirth");
				System.out.println("Data is "+sdf.format(date));
				bean.setDateOfBirth(sdf.format(date));
				bean.setAddress(rs.getString("address"));
				bean.setMobileNo(rs.getString("mobileno"));
				bean.setHigestQulification(rs.getString("qname"));
				list.add(bean);
			}
			
		}
		catch (SQLException e) 
		{
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		return list;
	}
}
