/*
 * Created on Feb 7, 2006
 *
 * TODO To change the template for this generated file go to
 * Window - Preferences - Java - Code Style - Code Templates
 */

/**
 * @author PIKU
 *
 * TODO To change the template for this generated type comment go to
 * Window - Preferences - Java - Code Style - Code Templates
 */
import java.io.File;
public class Test
{

    public static void main(String[] args)
    {
        String filePath = "E:/Works/TestFile_V1/sample.xml";
        System.out.println(" File Path  : "+filePath);
        String fileName = filePath.substring(filePath.lastIndexOf("/")+1,filePath.length());        
        System.out.println("File Name : "+fileName );
    }
}
