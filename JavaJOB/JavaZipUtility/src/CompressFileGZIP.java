import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.FileOutputStream;
import java.io.IOException;
import java.util.zip.GZIPOutputStream;

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
public class CompressFileGZIP {

    /**
     * Perform file compression.
     * @param inFileName Name of the file to be compressed
     */
    private static void doCompressFile(String inFileName) {

        try {
        
            System.out.println("Creating the GZIP output stream.");
            int fileLength = inFileName.length();
            System.out.println(" File Length : "+fileLength);
            //String tempFile = 
            String outFileName = inFileName + ".gz";
            GZIPOutputStream out = null;
            try {
                out = new GZIPOutputStream(new FileOutputStream(outFileName));
            } catch(FileNotFoundException e) {
                System.err.println("Could not create file: " + outFileName);
                System.exit(1);
            }
                    

            System.out.println("Opening the input file.");
            FileInputStream in = null;
            try {
                in = new FileInputStream(inFileName);
            } catch (FileNotFoundException e) {
                System.err.println("File not found. " + inFileName);
                System.exit(1);
            }

            System.out.println("Transfering bytes from input file to GZIP Format.");
            byte[] buf = new byte[2048];
            int len;
            while((len = in.read(buf)) > 0) {
                out.write(buf, 0, len);
            }
            in.close();

            System.out.println("Completing the GZIP file");
            out.finish();
            out.close();
        
        } catch (IOException e) {
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
        doCompressFile(dirName);
    
        /*if (args.length != 1) 
        {
            System.err.println("Usage: java CompressFileGZIP filename");
        } else {
            doCompressFile(args[0]);
        }*/

            
    }

}

