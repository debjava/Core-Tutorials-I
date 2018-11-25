import java.io.*;
public class TestSerial implements Serializable
{

	public static void main(String[] args) 
	{
		ObjectOutputStream objectOut = null;
		ObjectInputStream objectIn = null;
		Obj1 obj = new Obj1();
		obj.setAge(23);
		obj.setName("piku");
		try
		{
			objectOut = new ObjectOutputStream(new FileOutputStream("D:/Serial.txt"));
			objectOut.writeObject(obj);
		}
		catch(Exception e)
		{
			e.printStackTrace();
		}
		finally
		{
			try
			{
				objectOut.close();
			}
			catch(Exception e)
			{
				e.printStackTrace();
			}
		}
		
		try
		{
			objectIn = new ObjectInputStream(new FileInputStream("D:/Serial.txt"));
			Object obj11 = objectIn.readObject();
			Obj1 obj22 = (Obj1)obj11;
			System.out.println(" Name :: "+obj22.getName());
			System.out.println("Age :: "+obj22.getAge());
		}
		catch(Exception e)
		{
			e.printStackTrace();
		}
		
	}

}
