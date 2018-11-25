package com.dds.test;

import java.io.File;
import java.io.FileInputStream;
import java.io.FileOutputStream;
import java.io.IOException;
import java.io.InputStream;
import java.io.OutputStream;
import java.util.Enumeration;
import java.util.zip.ZipEntry;
import java.util.zip.ZipFile;
import java.util.zip.ZipInputStream;
import java.util.zip.ZipOutputStream;

public class ZIPCreater 
{
	File file;
	ZipOutputStream zipOutput;
	
	String ZIPFileName = null;
	String destnPath = null;
	
	public ZIPCreater(String destnPath,String ZIPFileName)
	{
		this.destnPath = destnPath;
		this.ZIPFileName = ZIPFileName;
		try
		{
			zipOutput = new ZipOutputStream(new FileOutputStream(destnPath+"/"+ZIPFileName));
		}
		catch(Exception e)
		{
			e.printStackTrace();
		}
		
	}
	
	public File[] getFiles(String path)
	{
		try 
		{
			file = new File(path);
		} 
		catch (RuntimeException e) 
		{
			e.printStackTrace();
		}
		return file.listFiles();
	}
	
	public void createZIP(String path)
	{
		try
		{
			byte[] buff = new byte[1024];
			File[] fileList = getFiles(path);
			for(int i=0;i<fileList.length;i++)
			{
				if(fileList[i].isDirectory())
				{
					createZIP(fileList[i].getAbsolutePath());
				}
				else
				{
					FileInputStream fin = new FileInputStream(fileList[i]);
					String temp = fileList[i].getAbsolutePath();
					String subTemp = temp.substring(temp.indexOf("CoronaMapping")+14,temp.length());
					zipOutput.putNextEntry(new ZipEntry(subTemp));
					int len;
					while((len = fin.read(buff))>0)
					{
						zipOutput.write(buff,0,len);
					}
					fin.close();
				}
			}
		}
		catch(Exception e)
		{
			e.printStackTrace();
		}
	}
	
	public void extractZip(String zipFileName)
	{
		try {

            ZipFile zf = new ZipFile(zipFileName);

            System.out.println("Archive:  " + zipFileName);
            
            // Enumerate each entry
            for (Enumeration entries = zf.entries(); entries.hasMoreElements();) {
                
                // Get the entry and its name
                ZipEntry zipEntry = (ZipEntry)entries.nextElement();
                String zipEntryName = zipEntry.getName();
                System.out.println("  inflating: " + zipEntryName);
                
                if(zipEntry.isDirectory())
                {
                	System.out.println("It is a directory ...........");
                	File f1 = new File(zipEntry.getName());
                	
                	File[] files = getFiles(f1.getAbsolutePath());
                	for(int i=0;i<files.length;i++)
                	{
                		System.out.println("File Name ::: "+files[i].getAbsolutePath());
                	}
                }
                 
                else
                {
                OutputStream out = new FileOutputStream("D:/new/"+zipEntryName);
                InputStream in = zf.getInputStream(zipEntry);
                
                byte[] buf = new byte[1024];
                int len;
                while((len = in.read(buf)) > 0) {
                    out.write(buf, 0, len);
                }
                
                

                // Close streams
                out.close();
                in.close();
                }
            }

        } catch (IOException e) {
            e.printStackTrace();
            System.exit(1);
        }

		
	}
	
	public void close()
	{
		try
		{
			zipOutput.close();
		}
		catch(Exception e)
		{
			e.printStackTrace();
		}
	}
	
	public static void main(String[] args) 
	{
		ZIPCreater zipCreater = new ZIPCreater("D:/new/","corona.zip");
		zipCreater.createZIP("D:/CoronaMapping");
		zipCreater.close();
		zipCreater.extractZip("D:/new/corona.zip");
		
	}
	

}
