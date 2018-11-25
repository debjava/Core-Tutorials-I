import java.io.FileInputStream;
import java.io.FileOutputStream;
import java.io.PrintWriter;
import java.io.Writer;

/*
 * Created on Feb 14, 2006
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
public class TestPrintwriter
{
    public void write()
    {
        //FileInputStream fin = new FileInputStream("E:/pp.txt");
        try
        {
        PrintWriter pw = new PrintWriter(new FileOutputStream("E:/Workarea/pp.txt"));
        pw.write("\n Hello world\n");
        pw.write("\n I am here \n");
        pw.flush();
        pw.close();
        }
        catch(Exception e)
        {
            e.printStackTrace();
        }
 
    }

    public static void main( String[] args)
    {
        TestPrintwriter testPrintWriter = new TestPrintwriter();
        testPrintWriter.write();
    }
}
