import org.apache.log4j.Logger;

import com.iit.core.scheduler.DailyScheduler;
import com.iit.core.scheduler.Scheduler;


public class StopScheduler 
{
	protected static Logger logger = Logger.getLogger( StopScheduler.class );
	public static void main(String[] args) 
	{
		
		DailyScheduler scheduler = (DailyScheduler) DailyScheduler.getInstance();
		logger.info(scheduler.toString());
		logger.info("HashCode========="+scheduler.hashCode());
//		scheduler.dailyTimer.cancel();
		scheduler.stopScheduler();
//		System.exit(0);
	}
}
