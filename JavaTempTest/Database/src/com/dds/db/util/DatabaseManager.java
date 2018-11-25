package com.dds.db.util;

import java.sql.Connection;
import java.sql.DatabaseMetaData;
import java.sql.DriverManager;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;

import com.dds.db.beans.DbConBeans;

public class DatabaseManager implements DbManager 
{

	private transient Connection connection = null;
	
	public DatabaseManager()
	{
		
	}
	
	public boolean checkOracleDbConnection(String dbUrl, String dbUser, String dbPwd) 
	{
		boolean checkConnection = false;
		try
		{
			Class.forName("oracle.jdbc.OracleDriver");
			connection = DriverManager.getConnection(dbUrl,dbUser,dbPwd);
			if(connection != null)
			{
				checkConnection = true;
			}
			else
			{
				checkConnection = false;
			}
		}
		catch(ClassNotFoundException cnfe)
		{
			cnfe.printStackTrace();
		}
		catch(Exception e)
		{
			e.printStackTrace();
		}
		finally
		{
			try
			{
				closeConnection(connection);
			}
			catch(Exception e)
			{
				e.printStackTrace();
			}
		}
		return checkConnection;
	}
	
	private void closeConnection(final Connection connection) throws SQLException
	{
		connection.close();
	}

	public boolean checkOracleDbConnection(final DbConBeans dbBeans) 
	{
		boolean checkConnection = false;
		try
		{
			Class.forName("oracle.jdbc.OracleDriver");
			connection = DriverManager.getConnection(dbBeans.getDatabseURL(),dbBeans.getDatabaseUSER(),dbBeans.getDatabasePWD());
			if(connection != null)
			{
				checkConnection = true;
			}
			else
			{
				checkConnection = false;
			}
		}
		catch(Exception e)
		{
			e.printStackTrace();
		}
		return checkConnection;
	}

	public ArrayList<String> getDatabaseTables(Connection connection) 
	{
		ArrayList<String> tableNames = new ArrayList<String>();
		try
		{
			DatabaseMetaData dbMetaData = connection.getMetaData();
			final ResultSet rSet = dbMetaData.getTables(null,null,null,new String[]{"TABLE"});
			while(rSet.next())
			{
				final String tableName = rSet.getString(3);
				tableNames.add(tableName);
			}
		}
		catch(Exception e)
		{
			e.printStackTrace();
		}
		return tableNames;
	}

	public ArrayList getDatabaseTables(String dbUrl, String dbUser, String dbPwd) {
		// TODO Auto-generated method stub
		return null;
	}

	public ArrayList getDatabaseTables(DbConBeans dbBeans) {
		// TODO Auto-generated method stub
		return null;
	}

	public ArrayList getDbTableFieldInfo(Connection connection) 
	{
		// TODO Auto-generated method stub
		return null;
	}

	public Connection getOracleDbConnection(String dbUrl, String dbUser, String dbPwd) 
	{
		Connection conn = null;
		try
		{
			Class.forName("oracle.jdbc.OracleDriver");
			conn = DriverManager.getConnection(dbUrl,dbUser,dbPwd);
		}
		catch(Exception e)
		{
			e.printStackTrace();
		}
//		finally
//		{
//			try
//			{
//				closeConnection(conn);
//			}
//			catch(Exception e)
//			{
//				e.printStackTrace();
//			}
//		}
		return conn;
	}

	public Connection getOracleDbConnection(DbConBeans dbBeans) 
	{
		Connection conn = null;
		try
		{
			Class.forName("oracle.jdbc.OracleDriver");
			conn = DriverManager.getConnection(dbBeans.getDatabseURL(),dbBeans.getDatabaseUSER(),dbBeans.getDatabasePWD());
		}
		catch(Exception e)
		{
			e.printStackTrace();
		}
		finally
		{
			
		}
		return conn;
	}

}
