package com.dds.db.util;

import java.sql.Connection;
import java.util.ArrayList;

public class TestDatabase 
{
	
	public static void main(String[] args) 
	{
		DbManager manager = new DatabaseManager();
		boolean newCheck = manager.checkOracleDbConnection("jdbc:oracle:thin:@localhost:1521:orcl","scott","tiger");
		final Connection connection = manager.getOracleDbConnection("jdbc:oracle:thin:@localhost:1521:orcl","scott","tiger");
		final ArrayList<String> tableList = manager.getDatabaseTables(connection);
		for(int i=0 ; i < tableList.size();i++)
		{
			final String tableName = tableList.get(i);
			System.out.println("Table Name :: "+tableName);
			
		}
		
	}

}
