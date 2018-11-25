

package com.rrs.corona.solutionsacceleratorstudio.datasource;
/**
 * @author Debadatta Mishra
 * 
 */
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.ResultSet;
import java.sql.ResultSetMetaData;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.ArrayList;

import oracle.jdbc.OracleDriver;
//import org.apache.commons.logging.Log;
//import org.apache.commons.logging.LogFactory;

public class DatabaseManager 
{
	String databaseURL = null ;
	String databaseUserName = null ;
	String databasePassword = null ;
	Connection connection = null ;
	boolean testConnection = false ;
	//protected final  Log logger_ = LogFactory.getLog(getClass());
	
	public Connection getDatabaseConnection(String url,String user,String pwd)
	{
		try 
		{
			//DriverManager.registerDriver( new oracle.jdbc.OracleDriver());
			DriverManager.registerDriver( new OracleDriver());
			connection = DriverManager.getConnection(url,user,pwd);
		}
		catch (SQLException se) 
		{	
			se.printStackTrace();
		}
		
		return connection ;		
	}
	
	// Method for passing object type
	public Connection getDatabaseConnection(DbmsInfo dbmsInfo) throws SQLException
	{
		//DriverManager.registerDriver( new oracle.jdbc.OracleDriver());
		DriverManager.registerDriver( new OracleDriver());
		connection = DriverManager.getConnection(dbmsInfo.getDbUrl(),dbmsInfo.getDbUser(),dbmsInfo.getDbPassword());
		return connection ;		
	}
	
	public boolean checkDatabaseConnection(String url,String user,String pwd)// For testing Connection
	{
		try 
		{
			//DriverManager.registerDriver( new oracle.jdbc.OracleDriver());
			DriverManager.registerDriver( new OracleDriver());
			connection = DriverManager.getConnection(url,user,pwd);
			if(connection != null)
			{
				testConnection = true ;
			}
			else
			{
				testConnection = false;
			}
		}
		catch (SQLException se) 
		{	
			testConnection = false;
			se.printStackTrace();
		}
		
		return testConnection ;		
	}
	
	public boolean checkDatabaseConnection(DbmsInfo dbInfo)
	{
		try 
		{
			//DriverManager.registerDriver( new oracle.jdbc.OracleDriver());
			DriverManager.registerDriver( new OracleDriver());
			connection = DriverManager.getConnection(dbInfo.getDbUrl(),dbInfo.getDbUser(),dbInfo.getDbPassword());
			if(connection != null)
			{
				testConnection = true ;
			}
			else
			{
				testConnection = false;
			}
		}
		catch (SQLException se) 
		{	
			testConnection = false;
			se.printStackTrace();
		}
		
		return testConnection ;		
	}
	
	public ArrayList getAllDatabaseNames(Connection con)// To get all database table names
	{
		String query_all_databasename_str = "select * from all_users " ;
		ArrayList databaseNames = new ArrayList() ;
		try
		{			
			Statement statement = con.createStatement();
			ResultSet resultSet = statement.executeQuery(query_all_databasename_str);
			while(resultSet.next())
			{
				TableInfo tableInfoObj = new TableInfo();
				tableInfoObj.setTableName(resultSet.getString(1));				
				databaseNames.add(tableInfoObj);
			}
			return databaseNames ;
		}
		catch(SQLException se)
		{
			se.printStackTrace() ;
		}
		
		return null ;
	}
	
	public ArrayList getAllTableNames(Connection con)// To get all database table names
	{
		String query_all_tab_str = "select * from tab " ;
		ArrayList databaseTableNames = new ArrayList() ;
		try
		{			
			Statement statement = con.createStatement();
			ResultSet resultSet = statement.executeQuery(query_all_tab_str);
			while(resultSet.next())
			{
				TableInfo tableInfoObj = new TableInfo();
				tableInfoObj.setTableName(resultSet.getString(1));				
				databaseTableNames.add(tableInfoObj);
			}
			return databaseTableNames ;
		}
		catch(SQLException se)
		{
			se.printStackTrace() ;
		}
		
		return null ;
	}
	
	public ArrayList getEachTableInfo(String tableName)
	{
		DbmsInfo dbInfo = new DbmsInfo();
		Connection con = getDatabaseConnection(dbInfo.getDbUrl(),dbInfo.getDbUser(),dbInfo.getDbPassword()) ;
		String queryString = "select * from "+tableName ;
		ArrayList fieldInfoObjsList = new ArrayList();
		try
		{
			Statement statement = con.createStatement();
			ResultSet result = statement.executeQuery(queryString);
			ResultSetMetaData resultsetmetaData = result.getMetaData();
			//logger_.info("In "+tableName+" Total no of Columns "+resultsetmetaData.getColumnCount());			
			for(int i=1;i<resultsetmetaData.getColumnCount()+1;i++)
			{
				FieldInfo fieldIno = new FieldInfo();
				fieldIno.setFieldName(resultsetmetaData.getColumnName(i));
				fieldIno.setFieldType(resultsetmetaData.getColumnTypeName(i));				
				fieldInfoObjsList.add(fieldIno);				
			}
			
			return fieldInfoObjsList ;
		}
		catch(SQLException se)
		{
			se.printStackTrace() ;
		}
		
		return null ;		
	}
	
	public ArrayList getEachTableInfo(Connection con ,String tableName)
	{
		String queryString = "select * from "+tableName ;
		ArrayList fieldInfoObjsList = new ArrayList();
		try
		{
			Statement statement = con.createStatement();
			ResultSet result = statement.executeQuery(queryString);
			ResultSetMetaData resultsetmetaData = result.getMetaData();			
			//logger_.info("In "+tableName+" Total no of Columns "+resultsetmetaData.getColumnCount());			
			for(int i=1;i<resultsetmetaData.getColumnCount()+1;i++)
			{
				FieldInfo fieldInfo = new FieldInfo();
				fieldInfo.setFieldName(resultsetmetaData.getColumnName(i));
				fieldInfo.setFieldType(resultsetmetaData.getColumnTypeName(i));
				fieldInfoObjsList.add(fieldInfo);	
			} 		
			
			return fieldInfoObjsList ;
		}
		catch(SQLException se)
		{
			se.printStackTrace() ;
		}
		
		return null ;
	}
	
	public void getEachTableInfo(Connection con,ArrayList tableNames)
	{	
		for(int i=0;i<tableNames.size();i++)
		{
			String tabName = (String)tableNames.get(i);
			String queryString = "select * from "+tabName ;
			try
			{
				Statement statement = con.createStatement();
				ResultSet result = statement.executeQuery(queryString);
				ResultSetMetaData resultsetmetaData = result.getMetaData();
				//logger_.info("In "+tabName+" Total no of Columns "+resultsetmetaData.getColumnCount());
				for(int j=1;j<resultsetmetaData.getColumnCount()+1;j++)
				{
					//logger_.info("Column Name : "+resultsetmetaData.getColumnName(j)+"===="+"Column Type  : "+resultsetmetaData.getColumnTypeName(j));					
				}
			}
			catch(SQLException se)
			{
				se.printStackTrace() ;
			}	
		}
	}
	
	public void close(Connection con)
	{
		if(con != null)
		{
			try
			{
				con.close() ;
			}
			catch(SQLException se)
			{
				se.printStackTrace();
			}
		}
	}
	
}
