package com.vps.dds.test;

import java.io.File;
import java.io.FileOutputStream;
import java.io.PrintWriter;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.ResultSet;
import java.sql.ResultSetMetaData;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.ArrayList;

public class NewTest 
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
	
	public NewTest(String tabName)
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
			String queryString = "select * from "+tableName;
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
	
	public int getTotalColumn(ResultSet rSet)
	{
		try {
			rsmd = rSet.getMetaData();
			totalColumn = rsmd.getColumnCount();
		}
		catch (SQLException e) 
		{
			e.printStackTrace();
		}
		
		return totalColumn;
	}
	
	public int getTotalRows(Connection conn)
	{
		
		try 
		{
			String queryString = "select count(*) from "+tableName;
			statement = conn.createStatement();
			resultSet = statement.executeQuery(queryString);
			
			totalRows = resultSet.getInt(1);
			
			
			
		}
		catch (SQLException e) 
		{
			e.printStackTrace();
		}
		
		return totalRows;
	}
	
	public void generateInsertQuery(ResultSet rSet)
	{
		int tColumns = getTotalColumn(rSet);
		try
		{
			writer = new PrintWriter(new FileOutputStream("D:/main/insert.sql"));
		}
		
		catch(Exception e)
		{
			e.printStackTrace();
		}
		try 
		{
			
			
			while(rSet.next())
			{
				ArrayList al = new ArrayList();
				
				for(int i=1;i<=tColumns;i++)
				{
					String values = "";
					if(rsmd.getColumnTypeName(i).equalsIgnoreCase("varchar2"))
					{
						
						values = values+"'"+rSet.getString(i)+"'";
						al.add(values);
						
					}	
					
					else if(rsmd.getColumnTypeName(i).equalsIgnoreCase("number"))
					{
						
						values = values+rSet.getDouble(i);
						al.add(values);
						
					}
					
					
				}
				display(al);
				writeToFile(al);
				
				
			}
			
			writeLast();
		} 
		catch (SQLException e) 
		{
			
			e.printStackTrace();
		}
		
	}	
	
	public void display(ArrayList al1)
	{
		String values = "";
		int alsize = al1.size();
		
		
		
		for(int i =0;i<al1.size();i++)
		{
			if(al1.size()<alsize)
			{
				values = values+(String)al1.get(i)+" >>>>>>>>>>>>>>>>> ";
				values = ","+values;
				System.out.println(" New values ..............  "+values);
			}
			
			else
			{
				values = values+al1.get(i);
				System.out.println(" New values ..............  "+values);
			}
			
		}
	}
	
	public void writeToFile(ArrayList al1)
	{
		String values = "";
		char comma =',';
		int alsize = al1.size();
		
		for(int i =0;i<al1.size();i++)
		{
			if(i<alsize-1)
			{
				values = values+al1.get(i)+",";
				
				System.out.println(" If block ........");
			}
			
			else
			{
				values = values+al1.get(i);
				
				System.out.println(" else block ........");
			}
			
		}
		
		writer.write("insert into "+tableName+" values("+values+");");
		writer.write("\n");
		
	}
	
	public void writeLast()
	{
		writer.write("commit ;");
		writer.flush();
		writer.close();
		
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
		NewTest ti = new NewTest("test_table1");
		Connection connection = ti.getConnection("jdbc:oracle:thin:@localhost:1521:orcl","scott","tiger");
		ResultSet rSet = ti.getResultSet(connection);
		
		ti.generateInsertQuery(rSet);
		ti.close(connection);
		
		
	}
	
	
}
