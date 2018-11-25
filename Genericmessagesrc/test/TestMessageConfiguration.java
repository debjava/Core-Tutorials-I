import java.util.Properties;

import com.iit.core.config.MessageConfiguration;


public class TestMessageConfiguration 
{
	public static void main(String[] args) 
	{
		Properties prop = new Properties();
		prop.put("mail.smtp.host", "idealexch01.idealinvent.com");//Mandatory
		prop.put("SMS_GATEWAY", "airtelkk.com");//Optional
//		DatabaseConfiguration.storeConfigDetails(prop, "D:/tempConfigXXX");
		MessageConfiguration.storeConfigDetails( prop );
	}
}
