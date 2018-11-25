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
public class TestDirs 
{
    public void getDirName(String dirname)
    {
        File f1 = new File(dirname) ;
        String[] fileList = f1.list();
        for(int i=0 ; i<fileList.length ; i++)
        {
            //File f = new File(dirname+"/"+fileList[i]);
            System.out.println("FileName is ** "+fileList[i]);
        }
    }
    public static void main(String[] args) 
    {
        TestDirs td = new TestDirs() ;
        String dirName = "C:/OJB-BLANK" ;
        File file = new File(dirName) ;
        String[] s = file.list() ;
        
        for(int i=0;i<s.length;i++)
        {
            File f1 = new File(dirName+"/"+s[i]);
            //File f1 = new File(fileName);
            if(f1.isDirectory())
            {
                System.out.println(" Directory Name : "+s[i]);
                td.getDirName(dirName);
            }
            else
            {
                //System.out.println("*********** "+s[i]);
            }
        }
        
    }
}
