import java.io.IOException;

public class BatTest 
{
	public void runBat(String path)
	{
		String[] command = { "cmd.exe", "/C", "Start", path+"/"+"test.bat" };

		//Runtime r = Runtime.getRuntime();
		try
		{
			Process child = Runtime.getRuntime().exec(command);
		}
		catch(IOException ie)
		{
			ie.printStackTrace();
		}
		

	}
	public static void main( String[] args )
	{
		new BatTest().runBat("E:/TestBAT_Files");

	}


}
