package com.dds.util.scripts;

import java.io.FileOutputStream;
import java.io.PrintWriter;

public class DBScriptsgenerator 
{
	private transient PrintWriter printWriter = null;
	
	private PrintWriter getPrintWriter(final String filePath)
	{
		try
		{
			printWriter = new PrintWriter(new FileOutputStream(filePath));
		}
		catch(Exception e)
		{
			System.out.println("Exception thrown in Method :::getPrintWriter():::");
		}
		return printWriter;
	}
	
	private void doFlush()
	{
		printWriter.flush();
		printWriter.close();
	}
	public void generateScripts(final String filePath)
	{
		getPrintWriter(filePath);
		for(int i=0;i<3600;i++)
		{
			final String tableName = "DBCreate"+i;
			generateDBCreateScripts(tableName);
		}
		doFlush();
	}
	private void generateDBCreateScripts(final String tableName)
	{
		try
		{
			printWriter.write("create table "+tableName+"(id number(8),name varchar2(30) );");
			printWriter.write("\n");
		}
		catch(Exception e)
		{
			System.out.println("Exception thrown in Method :::generateCreateScripts():::");
			e.printStackTrace();
		}
	}
	
	public void generateDBDropScripts()
	{
		for(int i=0;i<3600;i++)
		{
			final String tableName = "DBCreate"+i;
			generateDBCreateScripts(tableName);
		}
	}
	
	private void generateDropScripts(final String tableName)
	{
		
	}
	
	public static void main(String[] args) 
	{
		new DBScriptsgenerator().generateScripts("d:/hi.txt");
		
	}

}
