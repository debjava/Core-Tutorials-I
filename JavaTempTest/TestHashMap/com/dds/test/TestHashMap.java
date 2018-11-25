package com.dds.test;

import java.util.HashMap;
import java.util.Iterator;
import java.util.Map;
import java.util.Set;

public class TestHashMap 
{
	public HashMap getData()
	{
		HashMap hm = new HashMap();
		Obj1 ob1 = new Obj1();
		
		ob1.setUserName("piku");
		ob1.setPassword("pikupiku");
		
		hm.put("firstOBj",ob1);
		
		Obj1 ob2 = new Obj1();
		ob2.setPassword("lilu");
		ob2.setUserName("lilu");
		
		hm.put("secondObj",ob2);
		
		Obj1 ob3 = new Obj1();
		ob3.setPassword("arzoo");
		ob3.setUserName("Arzoo");
		
		hm.put("thirdObj",ob3);
		
		return hm;
	}
	
	public static void main(String[] args) 
	{
		HashMap hm1 = new TestHashMap().getData();
		
		Set set = hm1.entrySet();
		Iterator itr = set.iterator();
		
		while(itr.hasNext())
		{
			Map.Entry me = (Map.Entry)itr.next();
			Obj1 obj1 = (Obj1)me.getValue();
			System.out.println(" Key Name ::: "+me.getKey());
			System.out.println(" Value from Obj1 userName ::: "+obj1.getUserName());
			
		}
		
	}

}
