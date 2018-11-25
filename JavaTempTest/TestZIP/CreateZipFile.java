import java.io.File;
import java.io.FileInputStream;
import java.io.FileOutputStream;
import java.io.IOException;
import java.util.zip.ZipEntry;
import java.util.zip.ZipOutputStream;

public class CreateZipFile {

    private static void doCreateZipFile(String[] files) {

        String zipFileName = files[0];
        byte[] buf = new byte[1024];

        try {

            ZipOutputStream out = new ZipOutputStream(new FileOutputStream(zipFileName));

            System.out.println("Archive:  " + zipFileName);

            // Compress the files
            for (int i=1; i<files.length; i++) {

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

    	File file1 = new File("D:/CoronaMapping");
    	//String[] file2 = file1.list();
    	File[] file2 = file1.listFiles();
    	
//    	doCreateZipFile(file2);
    	byte[] buf = new byte[1024];

        try {

            ZipOutputStream out = new ZipOutputStream(new FileOutputStream("D:/hati.jar"));

            //System.out.println("Archive:  " + zipFileName);

            // Compress the files
            for (int i=0; i<file2.length; i++) 
            {
            	if(file2[i].isDirectory())
            	{
            		System.out.println("Yes it is adir........");
            	}

                FileInputStream in = new FileInputStream(file2[i]);
                System.out.println("  adding: " + file2[i]);

                out.putNextEntry(new ZipEntry(file2[i].getAbsolutePath()));

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


        } catch (IOException e) {
            e.printStackTrace();
            System.exit(1);
        }


    }

}

