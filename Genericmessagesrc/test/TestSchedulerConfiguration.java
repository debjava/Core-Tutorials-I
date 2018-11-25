import java.util.Iterator;
import java.util.Map;
import java.util.Properties;

import com.iit.core.config.SchedulerConfiguration;


public class TestSchedulerConfiguration 
{
	public static void main(String[] args) 
	{
		Properties prop = new Properties();
		prop.put("delay", "5");
		prop.put("period", "10");
		SchedulerConfiguration.storeConfigDetails( prop );
	}
}
