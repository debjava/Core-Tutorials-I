package com.dds.test;

import java.io.FileInputStream;
import java.io.FileOutputStream;
import java.util.HashMap;
import java.util.Iterator;
import java.util.Map;
import java.util.Properties;
import java.util.Set;

public class PropCreater 
{
	private transient FileOutputStream fout = null;
	private transient Properties properties = null;
	private transient FileInputStream fin = null;
	
	/**
	 * @param filePath specifying filePath of the properties file
	 * @param hashMap containing the properties information
	 */
	private void createProperties(final String filePath,final HashMap hashMap)
	{
		try
		{
			fout = new FileOutputStream(filePath);
			properties = new Properties();
			final Set set =hashMap.entrySet();
			final Iterator itr = set.iterator();
			while(itr.hasNext())
			{
				Map.Entry me = (Map.Entry)itr.next();
				final String mapKey = (String)me.getKey();
				final String mapValue = (String)me.getValue();
				properties.setProperty(mapKey,mapValue);
			}
			properties.store(fout,"");//storing in plain properties file
			//properties.storeToXML(fout,"");
		}
		catch(Exception e)
		{
			e.printStackTrace();
		}
		finally
		{
			try
			{
				
			}
			catch(Exception e)
			{
				e.printStackTrace();
			}
		}
	}
	
	/**Method to read an xml file and to show the information
	 * @param filePath
	 */
	public void loadXMLToProperties(final String filePath)
	{
		try
		{
			fin = new FileInputStream(filePath);
			properties = new Properties();
			properties.loadFromXML(fin);
			showDetails(properties);
		}
		catch(Exception e)
		{
			e.printStackTrace();
		}
	}
	
	private void showDetails(final Properties prop)
	{
		Set set = prop.keySet();
		Iterator itr = set.iterator();
		while(itr.hasNext())
		{
			final String key = (String)itr.next();
			final String value = prop.getProperty(key);
			System.out.println("Key Name ::: "+key+"  "+"Value ::: "+value);
		}
	}
	
	public void storeProperties(final String filePath,HashMap hashMap)
	{
		createProperties(filePath,hashMap);
	}
	
	public static void main(final String[] args) 
	{
		//new PropCreater().createProperties("E:/JAVA_FINAL/TestProperties/workingFiles/test.properties");
		HashMap<String,String> map = new HashMap<String,String>();
		map.put("NAME","RAMA");
		map.put("AGE","24");
		map.put("DESGN","ENGINEER");
		new PropCreater().storeProperties("E:/JAVA_FINAL/TestProperties/workingFiles/test.properties",map);
		//new PropCreater().loadXMLToProperties("E:/JAVA_FINAL/TestProperties/workingFiles/new.xml");
		
	}

}
