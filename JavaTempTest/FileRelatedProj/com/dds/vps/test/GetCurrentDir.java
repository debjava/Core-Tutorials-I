package com.dds.vps.test;

import java.io.File;
import java.util.Date;

public class GetCurrentDir 
{
	public void doGetDir() 
	{
        String curDir = System.getProperty("user.dir");
        System.out.println("Cureent Directory ::: "+curDir);
    }
	
	public static void main(String[] args) 
	{
		new GetCurrentDir().doGetDir();
		
		System.out.println(new Date() + "\007");
		
		File file = new File("D:/SRCTest");

        // Destination directory
        File dir = new File("D:/new/");

        // Move file to a new directory
        boolean success = file.renameTo(new File(dir, file.getName()));

        if (success) {
            System.out.println("File was successfully moved.\n");
        } else {
            System.out.println("File was not successfully moved.\n");
        }


	}



}
