import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.FileOutputStream;
import java.io.IOException;
import java.nio.channels.FileChannel;

/**
 * @author PIKU
 *
 */
public class TestByteFile 
{
	FileInputStream fin = null;
	FileOutputStream fout = null;
	FileChannel fchan = null;
	FileChannel fochan = null;
	
	byte[] buff;
	
	public void readFile(String path) 
	{
		try 
		{
			fin = new FileInputStream(path);
			fchan = fin.getChannel();
			int size1 = (int) fchan.size();
			buff = new byte[size1];
			for(int i=0;i<buff.length;i++)
			{
				System.out.println(buff[i]);;
			}
			
		} 
		catch (FileNotFoundException e) 
		{
			e.printStackTrace();
		}
		catch(Exception e)
		{
			e.printStackTrace();
		}
		finally
		{
			try 
			{
				fchan.close();
				fin.close();
				fout.close();
			} catch (IOException e) 
			{
				e.printStackTrace();
			}
		}
	}
	
	public void writeFile(String srcPath,String destnPath)
	{
		try 
		{
			fin = new FileInputStream(srcPath);
			fout = new FileOutputStream(destnPath);
			fchan = fin.getChannel();
			int size1 = (int) fchan.size();
			buff = new byte[size1];
			fin.read(buff);
			for(int i=0;i<buff.length;i++)
			{
				fout.write(buff[i]);
			}
			
		} 
		catch (FileNotFoundException e) 
		{
			e.printStackTrace();
		}
		catch(Exception e)
		{
			e.printStackTrace();
		}
		finally
		{
			try 
			{
				fchan.close();
				fin.close();
			} catch (IOException e) 
			{
				e.printStackTrace();
			}
		}
	}
	
	public static void main(String[] args) 
	{
		TestByteFile test = new TestByteFile();
		//test.readFile("D:/JavaTempTest/TestFileByte/Resume2.doc");
		//test.writeFile("D:/JavaTempTest/TestFileByte/SIMADRI1.mpg","D:/JavaTempTest/TestFileByte/gopa.mpg");
		test.writeFile("D:/new/references.pdf","D:/new/index11.rtf");
		test.writeFile("D:/RamaXML/Test.xml","D:/Rama.xml");
		
	}

}

