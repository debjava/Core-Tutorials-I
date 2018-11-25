import org.apache.log4j.Logger;

import com.iit.core.scheduler.DailyScheduler;
import com.iit.core.scheduler.Scheduler;


public class TestScheduler 
{
	protected static Logger logger = Logger.getLogger(TestScheduler.class);
	
	public static void main(String[] args) 
	{
		System.out.println("****************** Starting the scheduler **************");
		logger.info("****************** Starting the scheduler **************");
		Scheduler scheduler = DailyScheduler.getInstance();
		scheduler.startScheduler( null );
	}
}
