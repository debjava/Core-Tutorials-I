package com.dds.test;

import java.util.ArrayList;



/**
 * @author PIKU
 *
 */
public class CombinedObj 
{
	Obj1 obj1;
	ArrayList obj2 = new ArrayList();
	
	public Obj1 getObj1() {
		return obj1;
	}
	/**
	 * @param obj1 The obj1 to set.
	 */
	public void setObj1(Obj1 obj1) {
		this.obj1 = obj1;
	}
	/**
	 * @return Returns the obj2.
	 */
	public ArrayList getObj2() {
		return obj2;
	}
	/**
	 * @param obj2 The obj2 to set.
	 */
	public void setObj2(ArrayList obj2) {
		this.obj2 = obj2;
	}
	

}
