package test;

import java.io.FileInputStream;
import java.io.FileOutputStream;
import java.nio.channels.FileChannel;

public class FileWrite 
{
	FileInputStream fin;
	FileOutputStream fout;
	FileChannel fichan;
	FileChannel fochan;
	byte[] buffer ;
	
	
	public FileWrite()
	{
		
	}
	
	private byte[] readFile(String filePath)
	{
		try
		{
			fin = new FileInputStream(filePath);
			System.out.println("FilePath :::"+filePath);
			fichan = fin.getChannel();
			int size = (int)fichan.size();
			System.out.println("file size ::: "+size);
			
			buffer = new byte[size];
			fin.read(buffer);
			//fout = new FileOutputStream("D:/RAMAXMLTest/SampleXML.xml");
			
			for(int i=0;i<buffer.length;i++)
			{
				System.out.println("Value ::: "+buffer[i]);
				//fout.write(buffer[i]);
			}
		}
		catch(Exception e)
		{
			e.printStackTrace();
		}
		
		return buffer;
	}
	
	public void writeToFile(byte[] file)
	{
		try
		{
			fout = new FileOutputStream("D:/RAMAXMLTest/SampleXML.xml");
			for(int i=0;i<file.length;i++)
			{
				fout.write(file[i]);
			}
		}
		catch(Exception e)
		{
			e.printStackTrace();
		}
	}
	
	public void writeFile(String path)
	{
		 byte[] returnBuffer = readFile(path);
		 writeToFile(returnBuffer);
	}
	
	
	public static void main(String[] args) 
	{
		
		new FileWrite().writeFile("D:/RamaXML/Test.xml");
	}
	

}
