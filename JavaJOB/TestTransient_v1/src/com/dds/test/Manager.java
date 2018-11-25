package com.dds.test;

import java.io.FileInputStream;
import java.io.FileOutputStream;
import java.io.ObjectInputStream;
import java.io.ObjectOutputStream;


public class Manager 
{
	private transient ObjectOutputStream oOut = null;
	private transient FileOutputStream fout = null;
	private transient FileInputStream fin = null;
	private ObjectInputStream oIn = null;
	
	public void storeObj(final Object object , final String filePath)
	{
		try
		{
			fout = new FileOutputStream(filePath);
			oOut = new ObjectOutputStream(fout);
			oOut.writeObject(object);
		}
		catch(Exception e)
		{
			e.printStackTrace();
		}
		finally
		{
			try
			{
				oOut.close();
			}
			catch(Exception e)
			{
				e.printStackTrace();
			}
		}
	}
	
	public void showData( final String filePath )
	{
		try
		{
			fin = new FileInputStream(filePath);
			oIn = new ObjectInputStream(fin);
			ObjIS tempObj = (ObjIS) oIn.readObject();
			System.out.println("Address ::: "+tempObj.getAdrs());
			System.out.println("Designation ::: "+tempObj.getDesgn());
			System.out.println("Name ::: "+tempObj.getName());
			System.out.println("Organisation ::: "+tempObj.getOrg());
		}
		catch(Exception e)
		{
			e.printStackTrace();
		}
		finally
		{
			try
			{
				oIn.close();
			}
			catch(Exception e)
			{
				e.printStackTrace();
			}
		}
	}
	
	public static void main(String[] args) 
	{
		Manager manager = new Manager();
		ObjIS obj = new ObjIS();
		obj.setAdrs("Banaglore");
		obj.setDesgn("Engineer");
		obj.setName("Deba");
		obj.setOrg("Xtreme");
		manager.storeObj(obj,"F:/TestData/TestTransient/objTran.txt");
	}
	

}
