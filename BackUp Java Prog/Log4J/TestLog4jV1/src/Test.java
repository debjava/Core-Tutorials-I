import org.apache.log4j.Level;
import org.apache.log4j.Logger;
import org.apache.log4j.SimpleLayout;
import org.apache.log4j.FileAppender;
/*
 * Created on Jan 15, 2006
 *
 * TODO To change the template for this generated file go to
 * Window - Preferences - Java - Code Style - Code Templates
 */

/**
 * @author PIKU
 *
 * TODO To change the template for this generated type comment go to
 * Window - Preferences - Java - Code Style - Code Templates
 */
public class Test 
{
	static Logger logger = Logger.getLogger(Test.class);
	//SimpleLayout layout = new SimpleLayout();
	//static FileAppender appender = null;   
	
	try
	{
	static FileAppender appender = new FileAppender(new SimpleLayout(),"pp.log",false);
	}
    catch(Exception e)
	{
    	e.printStackTrace() ;
	}
    
     
    
    String ss= " Hello World " ;

     logger.addAppender(appender);
     logger.setLevel((Level) Level.DEBUG);
   

public static void main(String[] args)
{
	
	
}
}


