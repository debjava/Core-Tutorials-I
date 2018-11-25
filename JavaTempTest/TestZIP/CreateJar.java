 import java.io.File;
import java.io.FileInputStream;
import java.io.FileOutputStream;
import java.util.jar.JarEntry;
import java.util.jar.JarOutputStream;
import java.util.jar.Manifest;
//import sun.tools.jar.Manifest;


public class CreateJar 
{
	File file;
	JarOutputStream jarOut;
	String jarFileName = "New.jar";
	Manifest manifest = null;
	public CreateJar(String destnPath)
	{
		try
		{
			manifest = new Manifest();
			jarOut = new JarOutputStream(new FileOutputStream(destnPath+jarFileName),manifest);
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
					jarOut.putNextEntry(new JarEntry(subTemp));
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
		CreateJar create = new CreateJar("D:/");
		create.createJar1("D:/CoronaMapping");
		create.close();
		
	}

}
