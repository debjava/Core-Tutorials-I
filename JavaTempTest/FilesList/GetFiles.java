import java.io.File;
import java.io.FileInputStream;
import java.io.FileOutputStream;
import java.io.IOException;
import java.nio.channels.FileChannel;

public class GetFiles 
{
	FileInputStream fin;
	FileOutputStream fout;
	FileChannel fchan;
	public void showFiles(String path)
	{
		File file = new File(path);
		File[] listFiles = file.listFiles();
		for(int i=0;i<listFiles.length;i++)
		{
			if(listFiles[i].isDirectory())
			{
				showFiles(listFiles[i].getAbsolutePath());
			}
			else
			{
				String tempName = listFiles[i].getName();
				String newName = tempName.substring(0,tempName.indexOf("."));
				//String title = tempName.substring(tempName.indexOf(".")+1,tempName.length());
				String title = "mpg" ;
				newName = newName+1;
				//System.out.println("File Name ::: "+newName+"."+title);
				String convertedFileName = newName+"."+title;
				System.out.println("Converted File Name ::: "+convertedFileName);
				convertFile(listFiles[i].getAbsolutePath(),convertedFileName);
			}
		}
	}
	
	public void convertFile(String srcFileName,String destnfileName)
	{
		try
		{
			fin = new FileInputStream(srcFileName);
			fout = new FileOutputStream("D:/JavaTempTest/GopalConverted/"+destnfileName);
			fchan = fin.getChannel();
			int fileSize = (int)fchan.size();
			byte[] buff = new byte[fileSize];
			fin.read();
			for(int i = 0;i<buff.length;i++)
			{
				fout.write(buff[i]);
			}
			
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
	
	public static void main(String[] args) 
	{
		new GetFiles().showFiles("F:/VSongs");
		//new GetFiles().showFiles("D:/JavaTempTest/Gopal");
		
		
	}

}
