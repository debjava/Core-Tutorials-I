import java.io.File;
import java.io.FileInputStream;
import java.io.FileOutputStream;
import java.io.IOException;
import java.util.zip.ZipEntry;
import java.util.zip.ZipOutputStream;

/*
 * Created on Feb 25, 2006
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
public class CreateZipFile 
{

    private static void doCreateZipFile(String[] files) 
    {
        String zipFileName = files[0];
        byte[] buf = new byte[1024];

        try 
        {

            ZipOutputStream out = new ZipOutputStream(new FileOutputStream(zipFileName));
            System.out.println("Archive:  " + zipFileName);

            // Compress the files
            for (int i=1; i<files.length; i++) 
            {

                FileInputStream in = new FileInputStream(files[i]);
                System.out.println("  adding: " + files[i]);

                out.putNextEntry(new ZipEntry(files[i]));

                // Transfer bytes from the file to the ZIP file
                int len;
                while((len = in.read(buf)) > 0) {
                    out.write(buf, 0, len);
                }

                // Complete the entry
                out.closeEntry();
                in.close();
            }

            // Complete the ZIP file
            out.close();


        } catch (IOException e) 
        {
            e.printStackTrace();
            System.exit(1);
        }

    }


    /**
     * Sole entry point to the class and application.
     * @param args Array of String arguments.
     */
    public static void main(String[] args) 
    {
        String dirName = "F:/JavaJOB/JavaZipUtility/Test/test/Image";
        File file1 = new File(dirName);
        File[] files = file1.listFiles();
        String[] strFiles = null;
        for(int i = 0 ; i<files.length ; i++)
        {
        	System.out.println("file name ::: "+files[i].getName());
        	if(files[i].isDirectory())
        	{
        		continue;
        	}
        	else
        	{
        		strFiles[i] = files[i].getAbsolutePath();
        	}	
        }
        CreateZipFile.doCreateZipFile(strFiles);

        /*if (args.length < 2) 
        {
            System.err.println("Usage: java CreateZipFile outputzipfilename filename1, filename2, ...");
        } else 
        {
            doCreateZipFile(args);
        }
*/
    }

}

