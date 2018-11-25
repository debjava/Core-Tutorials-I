/*
 * Created on Mar 6, 2006
 *
 * TODO To change the template for this generated file go to
 * Window - Preferences - Java - Code Style - Code Templates
 */
package com.vps.dds.test;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.ResultSet;
import java.sql.ResultSetMetaData;
import java.sql.SQLException;
import java.sql.Statement;

/**
 * @author PIKU
 *
 * TODO To change the template for this generated type comment go to
 * Window - Preferences - Java - Code Style - Code Templates
 */
public class GenerateQuery 
{
	Connection connection = null;
	ResultSet resultSet = null;
	Statement statement = null;
	
	
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
			 //String queryString = "select * from test_table1";
			 String queryString = "select * from emp";
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

	public static void main(String[] args) 
	{
		try
		{
			GenerateQuery generate = new GenerateQuery();
			Connection connection = generate.getConnection("jdbc:oracle:thin:@localhost:1521:orcl","scott","tiger");
			ResultSet rSet = generate.getResultSet(connection);
			
			ResultSetMetaData rsmd = rSet.getMetaData();
			System.out.println("====  "+rsmd.getColumnCount());
			System.out.println("******************  "+rsmd.getColumnClassName(2));// returns the Java type of field 
			System.out.println("@@@@@@@@@@@   "+rsmd.getColumnDisplaySize(3));//returns the size of the column
			
			System.out.println(" Total Rows : "+rSet.getRow());
			
			
			while(rSet.next())
			{
				for(int i=1;i<rsmd.getColumnCount()+1;i++)
				{
					System.out.println("Column Name  : "+rsmd.getColumnName(i)+"  <::> " + "Column Type  : "+rsmd.getColumnTypeName(i));;
					if(rsmd.getColumnTypeName(i).equalsIgnoreCase("varchar2"))
					{
						System.out.println(" Column Data ==  "+rSet.getString(rsmd.getColumnName(i)));
					}
					
					else if(rsmd.getColumnTypeName(i).equalsIgnoreCase("number"))
					{
						System.out.println(" Column Data ==  "+rSet.getDouble(rsmd.getColumnName(i)));
					}
					
					System.out.println("^^^^^^^^^^^^  "+rSet.getRow());
				}
				boolean checkLast = rSet.isAfterLast();
				System.out.println(" It is last");
				
				
			}
			
			
		}
		
		catch(SQLException se)
		{
			se.printStackTrace();
		}
		
	}
}
