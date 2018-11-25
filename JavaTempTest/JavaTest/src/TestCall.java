
public class TestCall 
{
	public void mCall()
	{
		String[] str = new String[1];
		str[0] = "rama";
		Test1 test1 = new Test1();
		test1.main(str);
	}
	
	public static void main(String[] args) 
	{
		new TestCall().mCall();
		
	}

}
