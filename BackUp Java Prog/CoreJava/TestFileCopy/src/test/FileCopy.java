/*
 * Created on Jan 29, 2006
 *
 * TODO To change the template for this generated file go to
 * Window - Preferences - Java - Code Style - Code Templates
 */
package test;

import java.io.File;
import java.io.FileInputStream;
import java.nio.MappedByteBuffer;
import java.nio.channels.FileChannel;

/**
 * @author PIKU
 *
 * TODO To change the template for this generated type comment go to
 * Window - Preferences - Java - Code Style - Code Templates
 */
public class FileCopy
{
    FileChannel fin = null ;
    FileChannel fout = null ;
    MappedByteBuffer mbuf = null ;
    
    public void CopyFile(File source,File destn)
    {
        try
        {
            fin = new FileInputStream(source).getChannel();
            fout = new FileInputStream(destn).getChannel();
            long size = fin.size();
            mbuf = fin.map(FileChannel.MapMode.READ_WRITE,size,size);
            fout.write(mbuf);
            
        }
        catch(Exception e)
        {
            e.printStackTrace();
        }
        
    }

    public static void main(String[] args)
    {
        FileCopy fp = new FileCopy();
        File f1= new File("F:/test1.txt");
        File f2 = new File("E:/test.txt");
        fp.CopyFile(f1,f2);
    }
}
