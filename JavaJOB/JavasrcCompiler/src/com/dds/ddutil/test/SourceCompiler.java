package com.dds.ddutil.test;

import java.io.File;
import java.util.ArrayList;
import com.sun.tools.javac.Main;

public class SourceCompiler 
{
	private transient int compileResult = -1;
	
	public SourceCompiler()
	{
		
	}
	
	public void compile(final String srcFilePath , final String destnFilePath , 
			final String libFilePath)
	{
		//ArrayList containing the list of related jar files
		ArrayList libList = getAllFiles(libFilePath);
		StringBuilder strBuilder = new StringBuilder();
		//ArrayList containing the sourceFiles to compile
		ArrayList srcList = getAllFiles(srcFilePath);
		final String classPath = getClassPath(libList);
		System.out.println("Classpath ::: "+classPath);
		for(int i = 0 ; i<srcList.size() ; i++)
		{
			final String srcFileName = (String)srcList.get(i);
			System.out.println("Java File Name ::: "+srcFileName);
			int compileVal = compileSrcFiles(srcFileName , destnFilePath , classPath);
			System.out.println("Compiled Value ::: "+compileVal);
		}
	}
	
	private String getClassPath(final ArrayList filesList )
	{
		String classPath = null;
		StringBuilder strBuilder = new StringBuilder();
		
		try
		{
			for(int i = 0 ; i<filesList.size() ; i++)
			{
				String fileName = (String)filesList.get(i);
				if(i == filesList.size() - 1)
				{
					strBuilder.append(fileName);
				}
				else
				{
					strBuilder.append(fileName+";");
				}
			}
			classPath = strBuilder.toString();
		}
		catch(Exception e)
		{
			e.printStackTrace();
		}
		return classPath;
	}
	
	private ArrayList getAllFiles(final String libFilePath)
	{
		ArrayList<String> filesList = new ArrayList<String>();
		try
		{
			File file = new File(libFilePath);
			File[] allFiles = file.listFiles();
			for(int i = 0 ; i<allFiles.length ; i++)
			{
				final String fileName = allFiles[i].getAbsolutePath();
				String tempFileName = fileName.substring(fileName.lastIndexOf("/")+1,fileName.length());
				filesList.add(tempFileName);
			}
		}
		catch(Exception e)
		{
			e.printStackTrace();
		}
		return filesList;
	}
	
	private int compileSrcFiles(final String fileToCompile , final String destnDir , final String classPath)
	{
		int compileValue = -1;
		try
		{
			String[] args = new String[] { "-classpath", classPath, "-d", destnDir, fileToCompile};
			compileValue = Main.compile(args);
		}
		catch(Exception e)
		{
			e.printStackTrace();
		}
		return compileValue;
	}
	
	public static void main(String[] args) 
	{
		SourceCompiler srcCompiler = new SourceCompiler();
		srcCompiler.compile("F:/TestData/TestOJB_V12/src/com/vps/dds/test",
				"F:/TestData/TestOJB_V12/bin","D:/JavaSoft/db-ojb-1.0.4/lib");
		
		srcCompiler.compile("F:/TestData/TestOJB_V12/src/com/vps/dds/test",
				"F:/TestData/TestOJB_V12/bin","D:/JavaSoft/db-ojb-1.0.4/lib");
	}
}
