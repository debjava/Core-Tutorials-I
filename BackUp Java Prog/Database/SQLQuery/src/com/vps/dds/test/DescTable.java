package com.vps.dds.test;

import java.io.PrintWriter;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.ResultSet;
import java.sql.ResultSetMetaData;
import java.sql.SQLException;
import java.sql.Statement;

public class DescTable 
{
	String tableName = null;
	String selectQueryString ="select * from ";
	Connection connection = null;
	ResultSet resultSet = null;
	ResultSet temp_resultSet = null;
	Statement statement = null;
	int totalRows = 0;
	int totalColumn = 0;
	ResultSetMetaData rsmd = null;
	int rowCounter = 0;
	PrintWriter writer = null;
	
	public DescTable(String tabName)
	{
		tableName = tabName;
	}
	
	public Connection getConnection(String url,String username,String pwd)
	{
		try
		{
			DriverManager.registerDriver(new oracle.jdbc.OracleDriver());
			connection=DriverManager.getConnection(url,username,pwd);
			return connection ;
		} 
		catch (SQLException e)
		{          
			e.printStackTrace();
		}
		
		return null ;
		
	}
	
	public ResultSet getResultSet(Connection conn)
	{
		try 
		{
			String queryString = "describe "+tableName;
			statement = conn.createStatement();
			resultSet = statement.executeQuery(queryString);
			
			return resultSet;
		}
		catch (SQLException e) 
		{
			e.printStackTrace();
		}
		
		return null;
	}
	
	public void describeTable(ResultSet rSet)
	{
		try
		{
			
			while(rSet.next())
			{
				System.out.println("-------"+rSet.getString(1));
				System.out.println("-------"+rSet.getString(2));
				System.out.println("-------"+rSet.getString(3));
			}
		}
		
		catch(Exception e)
		{
			e.printStackTrace();
		}
	}
	
	public void close(Connection conn)
	{
		if(conn != null)
		{
			try
			{
				conn.close();
			}
			catch(SQLException se)
			{
				se.printStackTrace();
			}
		}
	}
	
	public static void main(String[] args) 
	{
		DescTable ti = new DescTable("test_table1");
		Connection connection = ti.getConnection("jdbc:oracle:thin:@localhost:1521:orcl","scott","tiger");
		ResultSet rSet = ti.getResultSet(connection);
		ti.describeTable(rSet);
		ti.close(connection);

	}

}
