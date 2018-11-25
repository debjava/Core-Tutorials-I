package com.dds.test;

import java.util.ArrayList;

public class SetAllObjs 
{
	Obj1 obj11 = new Obj1();
	Obj2 obj22 = new Obj2();
	CombinedObj comObj = new CombinedObj();
	public CombinedObj getValue()
	{
		ArrayList al1 = new ArrayList();
		obj11.setUserName("piku");
		obj11.setPassword("pikupiku");
		
		obj22.setAddress("Bolangir");
		obj22.setDesignation("engineer");
		al1.add(obj22);
		
		obj22.setAddress("Sambalpur");
		obj22.setDesignation("Doctor");
		al1.add(obj22);
		
		comObj.setObj1(obj11);
		comObj.setObj2(al1);
//		comObj.setObj2(obj22);
		
		return comObj;
	}
	
	public static void main(String[] args) 
	{
		CombinedObj obj = new SetAllObjs().getValue();
		
		System.out.println("From First Obj1 userName  :: "+obj.getObj1().getUserName());
//		System.out.println("From SecondOnj2  designation::: "+obj.getObj2().getDesignation());
		ArrayList al = obj.getObj2();
		
		for(int i=0 ;i< al.size();i++)
		{
			Object object =(Object)al.get(i);
			Obj2 obj33 = (Obj2)object;
			System.out.println("Address ::: "+obj33.getAddress());
			System.out.println("Designation :::  "+obj33.getDesignation());
		}
		
	}

}
