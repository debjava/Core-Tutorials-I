package com.dds.test;

import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.FileOutputStream;
import java.io.PrintWriter;

public class TestObj {

	/**
	 * @param args
	 */
	public TranObj getData()
	{
		TranObj obj1 = new TranObj();
		obj1.setStringName("PIKU");
		return obj1;
	}
	public static void main(String[] args) 
	{
		try 
		{
			PrintWriter printWriter = new PrintWriter(new FileOutputStream("D:/main.txt"));
			TranObj obj1 = new TestObj().getData();
			System.out.println("Value from TranObj ::: "+obj1.stringName);
			printWriter.write(obj1.getStringName());
			printWriter.flush();
			printWriter.close();
		} 
		catch (FileNotFoundException e)
		{
			e.printStackTrace();
		}
	}

}
