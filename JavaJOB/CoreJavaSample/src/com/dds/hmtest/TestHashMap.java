package com.dds.hmtest;

import java.util.HashMap;
import java.util.Iterator;
import java.util.Map;
import java.util.Set;

public class TestHashMap 
{
	private transient HashMap<String, String> testMap = new HashMap<String, String>();
	
	public void setData()
	{
		testMap.put("1234","piku");
		testMap.put("2345","lilu");
		testMap.put("3456","arzoo");
		testMap.put("4567","zillu");
		testMap.put("1234","dillip");
	}
	
	public void getData()
	{
		final String value = testMap.get("zillu");
		System.out.println("Value ::: "+value);
//		Set set = testMap.entrySet();
//		Iterator itr = set.iterator();
//		while(itr.hasNext())
//		{
//			Map.Entry me = (Map.Entry)itr.next();
//			System.out.println("key ::: "+me.getKey());
//			System.out.println("Value ::: "+me.getValue());
//		}
	}
	
	public static void main(String[] args)
	{
		TestHashMap map = new TestHashMap();
		map.setData();
		map.getData();
	}

}
