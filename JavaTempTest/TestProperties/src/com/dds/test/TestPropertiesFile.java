package com.dds.test;

import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.FileOutputStream;
import java.io.IOException;
import java.util.HashMap;
import java.util.Iterator;
import java.util.Map;
import java.util.Properties;
import java.util.Set;
import java.util.TreeMap;

public class TestPropertiesFile 
{
	FileInputStream fin = null;
	FileOutputStream fout = null;
	Properties properties = null;
	HashMap hs = new HashMap();
	
	public TestPropertiesFile(String sourceFileName)
	{
		try 
		{
			fin = new FileInputStream(sourceFileName);
			fout = new FileOutputStream("D:/JavaTempTest/TestProperties/piku.properties");
			properties = new Properties();
			properties.load(fin);
		}
		catch (FileNotFoundException e) 
		{
			e.printStackTrace();
		}
		catch(Exception e)
		{
			e.printStackTrace();
		}
	}
	
	public void readFile()
	{
//		System.out.println(" Value :: "+properties.getProperty("GMTOPIC"));
		int len = properties.size();
//		System.out.println("Properties size ::: "+len);
		Set set = properties.keySet();
		Iterator itr = set.iterator();
		while(itr.hasNext())
		{
			String val = (String) itr.next();
//			System.out.println("Property Name ::: "+val+"========"+properties.getProperty(val));
			hs.put(val,properties.getProperty(val));
		}

	}
	
	public void writeFile()
	{
		try 
		{
			properties = new Properties();
			properties.setProperty("MANA","mana");
			properties.setProperty("PIKU","PPP");
			
			properties.store(fout,"");
		}
		catch (Exception e) 
		{
			e.printStackTrace();
		}
	}
	
	public void showData()
	{
		Set set = hs.entrySet();
		Iterator itr = set.iterator();
		while(itr.hasNext())
		{
			Map.Entry me = (Map.Entry)itr.next();
			System.out.println("Key=== "+me.getKey()+"  Value===  "+me.getValue());
		}
	}
	
	public static void main(String[] args) 
	{
		TestPropertiesFile testProp = new TestPropertiesFile("D:/JavaTempTest/TestProperties/testharness.properties");
		testProp.readFile();
		testProp.showData();
//		testProp.writeFile();
		
	}

}
