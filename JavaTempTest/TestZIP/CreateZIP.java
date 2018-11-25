import java.io.File;
import java.io.FileInputStream;
import java.io.FileOutputStream;
import java.util.jar.JarEntry;
import java.util.jar.JarOutputStream;
import java.util.zip.ZipEntry;
import java.util.zip.ZipOutputStream;

public class CreateZIP 
{
	File file;
	ZipOutputStream jarOut;
	String jarFileName = "New11.z";
	public CreateZIP(String destnPath)
	{
		try
		{
			jarOut = new ZipOutputStream(new FileOutputStream(destnPath+jarFileName));
		}
		catch(Exception e)
		{
			e.printStackTrace();
		}
	}
	
	public File[] getFiles(String path)
	{
		try 
		{
			file = new File(path);
		} 
		catch (RuntimeException e) 
		{
			e.printStackTrace();
		}
		
		return file.listFiles();
	}
	
	public void createJar1(String path)
	{
		try
		{
			byte[] buff = new byte[1024];
			File[] fileList = getFiles(path);
			for(int i=0;i<fileList.length;i++)
			{
				if(fileList[i].isDirectory())
				{
					createJar1(fileList[i].getAbsolutePath());
				}
				else
				{
					FileInputStream fin = new FileInputStream(fileList[i]);
					String temp = fileList[i].getAbsolutePath();
					String subTemp = temp.substring(temp.indexOf("CoronaMapping")+14,temp.length());
					jarOut.putNextEntry(new ZipEntry(subTemp));
					int len;
					while((len = fin.read(buff))>0)
					{
						jarOut.write(buff,0,len);
					}
					fin.close();
				}
			}
		}
		catch(Exception e)
		{
			e.printStackTrace();
		}
	}
	
	public void close()
	{
		try
		{
			jarOut.close();
		}
		catch(Exception e)
		{
			e.printStackTrace();
		}
	}

	
	public static void main(String[] args) 
	{
		CreateZIP create = new CreateZIP("D:/");
		create.createJar1("D:/CoronaMapping");
		create.close();
	}

}
