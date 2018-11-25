package com.dds.test;

import java.io.File;
import java.io.FileInputStream;
import java.io.FileOutputStream;
import java.util.jar.JarEntry;
import java.util.jar.JarOutputStream;
import java.util.jar.Manifest;
import java.util.zip.ZipEntry;
import java.util.zip.ZipOutputStream;

public class CreateZIP 
{
	 public static int BUFFER_SIZE = 10240222;
	  protected void createZipArchive(File archiveFile, File[] tobeZipped) 
	  {
	    try 
	    {
	      byte buffer[] = new byte[BUFFER_SIZE];
	      // Open archive file
	      FileOutputStream stream = new FileOutputStream(archiveFile);
	      //JarOutputStream out = new JarOutputStream(stream, new Manifest());
	      ZipOutputStream out = new ZipOutputStream(stream);

	      for (int i = 0; i < tobeZipped.length; i++) 
	      {
	        if (tobeZipped[i] == null || !tobeZipped[i].exists()
	            || tobeZipped[i].isDirectory())
	        
	        	continue; // Just in case...
	        System.out.println("Adding " + tobeZipped[i].getName());
	        ZipEntry jarAdd = new JarEntry(tobeZipped[i].getName());
	        jarAdd.setTime(tobeZipped[i].lastModified());
	        out.putNextEntry(jarAdd);

	        // Write file to archive
	        FileInputStream in = new FileInputStream(tobeZipped[i]);
	        while (true) 
	        {
	          int nRead = in.read(buffer, 0, buffer.length);
	          if (nRead <= 0)
	            break;
	          out.write(buffer, 0, nRead);
	        }
	        in.close();
	      }

	      out.close();
	      stream.close();
	      System.out.println("Adding completed OK");
	    } 
	    catch (Exception ex) 
	    {
	      ex.printStackTrace();
	      System.out.println("Error: " + ex.getMessage());
	    }
	  }
	  
	  public void createZIPFile(final String zipFileName,final String inputFile)
	  {
		File zipFile = new File(zipFileName);
		File[] allFiles = new File(inputFile).listFiles();
		createZipArchive(zipFile, allFiles);
	  }
	  
	  public static void main(String[] args) 
	  {
		new CreateZIP().createZIPFile("F:/hati.zip","F:/TestData/CreateJar");
	  }

}
