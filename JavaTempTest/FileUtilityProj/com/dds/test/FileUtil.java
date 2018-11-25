package com.dds.test;

import java.io.File;
import java.io.FileInputStream;
import java.io.FileOutputStream;
import java.nio.MappedByteBuffer;
import java.nio.channels.FileChannel;

public class FileUtil 
{
	private FileInputStream fin = null;
	private FileOutputStream fout = null;
	private FileChannel fichan = null;
	private FileChannel fochan = null;
	private long fsize;
	private MappedByteBuffer mbuffer = null;
	
	private void fileWrite(String srcFilePath,String destnFilePath)
	{
		String dirName = destnFilePath.substring(0,destnFilePath.lastIndexOf("/"));
		File destFile = new File(destnFilePath);
		if(!destFile.exists())
		{
			new File(dirName).mkdirs();
		}
		else
		{
			// do nothing
		}
		try
		{
			fin = new FileInputStream(srcFilePath);
			fout = new FileOutputStream(destnFilePath);
			fichan = fin.getChannel();
			fochan = fout.getChannel();
			fsize = fichan.size();
			mbuffer = fichan.map(FileChannel.MapMode.READ_ONLY,0,fsize);
			fochan.write(mbuffer);
			fichan.close();
			fochan.close();
		}
		catch(Exception e)
		{
			e.printStackTrace();
		}
	}
	
	private void copyDir(String srcFilePath,String destnFilePath)
	{
		String directoryName = null;
		String metaDirName = srcFilePath.substring(srcFilePath.lastIndexOf("/")+1,srcFilePath.length());
		File dirName = new File(destnFilePath+"/"+metaDirName);
		if(!dirName.exists())
		{
			File file11 = new File(destnFilePath+"/"+metaDirName);
			file11.mkdirs();
			directoryName = file11.getName();
		}
		else
		{
			// do nothing
		}
		File srcMetaFile = new File(srcFilePath);
		File[] fileInMetaInf = srcMetaFile.listFiles();
		for(int i=0;i<fileInMetaInf.length;i++)
		{
			if(fileInMetaInf[i].isDirectory())
			{
				//continue;
				copyFile(fileInMetaInf[i].getAbsolutePath(),destnFilePath+"/"+directoryName);
			}
			else
			{
				copyFile(fileInMetaInf[i].getAbsolutePath(),destnFilePath+"/"+metaDirName+"/"+fileInMetaInf[i].getName());
			}
		}
	}
	
	public void copyFile(String fileName,String srcPath,String destnPath)
	{
		fileWrite(srcPath+"/"+fileName,destnPath+"/"+fileName);
	}
	public void copyFile(String srcFilePath,String destnFilePath)
	{
		fileWrite(srcFilePath,destnFilePath);
	}
	public void copyDirectory(String srcFilePath,String destnFilePath)
	{
		copyDir(srcFilePath,destnFilePath);
	}

	public static void main(String[] args) 
	{
		new FileUtil().copyDir("D:/new","D:/DestnDir");
		
	}
}
