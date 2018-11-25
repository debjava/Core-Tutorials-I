import java.io.File;
import java.io.FileInputStream;
import java.io.FileOutputStream;
import java.nio.channels.FileChannel;

public class CopyDir 
{
	FileInputStream fin;
	FileOutputStream fout;
	FileChannel fichan,fochan;
	
//	public void readDir(String dirPath)
//	{
//		try
//		{
//			fin = new FileInputStream(dirPath);
//			fichan = fin.getChannel();
//			int size = (int)fichan.size();
//			byte[] buffer = new byte[size];
//			for(int i=0;i<buffer.length;i++)
//			{
//				System.out.println(i);
//			}
//		}
//		catch(Exception e)
//		{
//			e.printStackTrace();
//		}
//	}
	public File[] getFiles(String path)
	{
		try 
		{
			File[] file22 = new File(path).listFiles();
			return file22;
		} 
		catch (RuntimeException e) 
		{
			e.printStackTrace();
		}
		return null;
	}
	
	public void readDir(String dirPath)
	{
		try
		{
			File file1 = new File(dirPath);
			File[] filesList = getFiles(dirPath);
			for(int i=0;i<filesList.length;i++)
			{
				//System.out.println("File Name ::: "+filesList[i].getName());
				if(filesList[i].isDirectory())
				{
					System.out.println("**********Directory Name*********** ::: "+file1.getName());
					readDir(filesList[i].getAbsolutePath());
					String newName = filesList[i].getName()+"_";
					new File(dirPath+"/"+newName).mkdirs();
				}
				else if(filesList[i].isFile())
				{
					System.out.println("It is file....");
					System.out.println("File Name :::: "+filesList[i].getName());
				}
			}
		
//			if(file1.isDirectory())
//			{
//				System.out.println("************************************");
//				System.out.println("Directory Name ::: "+file1.getName());
//				System.out.println("************************************");
//				File[] filesList = getFiles(dirPath);
//				for(int i=0;i<filesList.length;i++)
//				{
//					System.out.println("File Name ::: "+filesList[i].getName());
//					if(filesList[i].isDirectory())
//					{
//						readDir(filesList[i].getAbsolutePath());
//					}
//				}
//
//			}
		}
		catch(Exception e)
		{
			e.printStackTrace();
		}
	}
	public static void main(String[] args) 
	{
		new CopyDir().readDir("D:/new");

	}

}
