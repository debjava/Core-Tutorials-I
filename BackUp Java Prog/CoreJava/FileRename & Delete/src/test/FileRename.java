/*
 * Created on Jan 29, 2006
 *
 * TODO To change the template for this generated file go to
 * Window - Preferences - Java - Code Style - Code Templates
 */
package test;

import java.io.File;
import java.io.FileNotFoundException;

/**
 * @author DINA
 *
 * TODO To change the template for this generated type comment go to
 * Window - Preferences - Java - Code Style - Code Templates
 */
public class FileRename
{
    public void RenameFile(String file)
    {
        try
        {
            File f1 = new File(file);
            f1.renameTo(new File("F:/junk.dat"));
        }
        
        catch(Exception ex)
        {
            ex.printStackTrace();
        }
        
        
    }
    
    public void deleteFile(String fileName)
    {
        try
        {
            File target = new File(fileName);
            if(!target.exists())
            {
                System.out.println("File Not Found");;
            }
            
            if(target.delete())
            {
                System.out.println("File Deleted");;
            }
        }
        catch(Exception e)
        {
            e.printStackTrace();
        }
    }
    
    public static void main(String[] args)
    {
        String fileName = "F:/test1.txt" ;
        FileRename fr = new FileRename();
        fr.RenameFile(fileName);
        fr.deleteFile("F:/junk.dat");
        
    }
}
