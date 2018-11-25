/*
 * Created on Jan 19, 2006
 *
 * TODO To change the template for this generated file go to
 * Window - Preferences - Java - Code Style - Code Templates
 */
package com.vps.test;

import java.io.File;

/**
 * @author PIKU
 *
 * TODO To change the template for this generated type comment go to
 * Window - Preferences - Java - Code Style - Code Templates
 */
public class TestDir 
{

	public static void main(String[] args) 
	{
		File file = new File("C:/OJB-BLANK");
		String[] fileList = file.list();
		File file1 = null;
		System.out.println("Total files  : "+fileList.length);
		for(int i=0;i<fileList.length;i++)
		{
			file1 = new File(fileList[i]);
			if(file1.isFile())
			{
				System.out.println("\t File Name : "+fileList[i]+"===="+file1.getName());
			}
				//continue;
			else if(file1.isDirectory())
			{
				System.out.println("\t File Name : "+fileList[i]+"****** "+file1.getName());
			}	
		}
		
	}
}
