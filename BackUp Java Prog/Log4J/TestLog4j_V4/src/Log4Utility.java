import org.apache.log4j.FileAppender;
import org.apache.log4j.Logger;
import org.apache.log4j.SimpleLayout;

/*
 * Created on Jan 29, 2006
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
public class Log4Utility
{
    FileAppender appender = null ;
    SimpleLayout layout = null ;
    
    public Logger LogUtility(String className , String logFilePath)
    {
        layout = new SimpleLayout();
        Logger logger = Logger.getLogger(className);
        
        try
        {
            appender =new FileAppender(layout,logFilePath,false);
        }
        catch(Exception e)
        {
            e.printStackTrace();
        }
        
        logger.addAppender(appender);
        
        return logger ;
    }
    
    

}
