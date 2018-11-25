import java.util.Timer;
import java.util.TimerTask;
public class TestTimer //extends TimerTask
{
	
	@Override
//	public void run() 
//	{
//		System.out.println(" ********** Hello World ***************");		
//	}
//	
//	public void show()
//	{
//		Timer timer = new Timer("xx",true);
//		TimerTask task = new TestTimer();
//		timer.schedule(task,10,1000);
//	}
	
	public static void main(String[] args) 
	{
		//new TestTimer().show();
		
		Timer time = new Timer();
		time.schedule(new TimerTask{ public void run()
		{
			System.out.println("Hi.........");
		}
		}
		),1000);
		
		
		//timer.schedule(TimerTask task,2340);
		
	}

	

	

}
