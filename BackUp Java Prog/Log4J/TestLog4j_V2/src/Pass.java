import org.apache.log4j.FileAppender;
import org.apache.log4j.Level;
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
public class Pass
{
    FileAppender appender = null;
    
    public Logger logUse(String className , String filePath)
    {
        Logger logger =Logger.getLogger(className);
        SimpleLayout layout = new SimpleLayout();
        
        try
        {
            appender = new FileAppender(layout,filePath,false);
        }
        catch(Exception e)
        {
            e.printStackTrace();
        }
        
        logger.addAppender(appender);
        logger.setLevel((Level) Level.DEBUG);
        
        
        return logger ;
    }

}
