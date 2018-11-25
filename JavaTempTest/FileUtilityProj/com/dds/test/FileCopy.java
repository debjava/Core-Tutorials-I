package com.dds.test;

import java.io.File;
import java.io.FileInputStream;
import java.io.FileOutputStream;
import java.io.IOException;
import java.io.InputStream;
import java.io.OutputStream;
 
public class FileCopy 
{
	private void copyAllDirs(final File srcFile,final File destnFile)throws IOException
	{
		if (srcFile.isDirectory()) {
            if (!destnFile.exists()) {
            	destnFile.mkdir();
            }
    
            String[] children = srcFile.list();
            for (int i=0; i<children.length; i++) {
            	copyAllDirs(new File(srcFile, children[i]),
                                     new File(destnFile, children[i]));
            }
        } else {
            // This method is implemented in e1071 Copying a File
            copyFile(srcFile, destnFile);
        }
	}
	
	private void copyFile(final File srcFile,final File destnFile) throws IOException
	{
		 InputStream in = new FileInputStream(srcFile);
	        OutputStream out = new FileOutputStream(destnFile);
	    
	        byte[] buf = new byte[1024];
	        int len;
	        while ((len = in.read(buf)) > 0) {
	            out.write(buf, 0, len);
	        }
	        in.close();
	        out.close();

	}
	public void copyDir(final String srcFilePath,final String destnFilePath)
	{
		File srcFile = new File(srcFilePath);
		File dstnFile = new File(destnFilePath);
		try
		{
			copyAllDirs(srcFile,dstnFile);
		}
		catch(Exception e)
		{
			e.printStackTrace();
		}
		
	}
	
	public static void main(String[] args) 
	{
		new FileCopy().copyDir("D:/ZilluDir","D:/PikuDir");
		
	}
	

}
