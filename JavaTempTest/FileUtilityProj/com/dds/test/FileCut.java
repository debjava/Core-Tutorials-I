package com.dds.test;

import java.io.File;

public class FileCut 
{
	public void cutFile(final String srcFilePath,final String destnFilePath)
	{
		File srcFile = new File(srcFilePath);
		File destnFile = new File(destnFilePath);
		boolean success = srcFile.renameTo(new File(destnFile, srcFile.getName()));
	    if (!success) 
	    {
	    	System.out.println("File cna not moved...............");
	    }
	    else
	    {
	    	System.out.println("File was moved successfully........");
	    }
	}
	
	public static void main(String[] args) 
	{
		new FileCut().cutFile("C:/Test","D:/");
		
	}

}
