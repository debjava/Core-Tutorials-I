package com.dds.test;

import java.io.File;

public class FileDelete 
{
	public void deleteDir(String destnDir)
	{
		File file1 = new File(destnDir);
		if(file1.exists())
		{
			boolean deleteFlag = deleteAllDir(file1);
			if(deleteFlag)
			{
				System.out.println("********************************");
				System.out.println("********* Directory deleted *********");
				System.out.println("********************************");
			}
		}
		else
		{
			//do nothing
		}
	}
	private boolean deleteAllDir(final File dir)
	{
		if(dir.isDirectory())
		{
			String[] children = dir.list();
			for(int i=0;i<children.length;i++)
			{
				boolean success = deleteAllDir(new File(dir,children[i]));
				if(!success)
				{
					return false;
				}
			}
		}
		return dir.delete();
	}
	
	public static void main(String[] args) 
	{
		new FileDelete().deleteDir("D:/deleteDir");
		
	}

}
