
package logtest;

import org.apache.log4j.FileAppender;
import org.apache.log4j.HTMLLayout;
import org.apache.log4j.Level;
import org.apache.log4j.Logger;
import org.apache.log4j.SimpleLayout;

/**
 * @author PIKU
 *
 * TODO To change the template for this generated type comment go to
 * Window - Preferences - Java - Code Style - Code Templates
 */
public class logUtility
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
    
    public Logger logUseHtml(String className , String filePath)
    {
        Logger logger =Logger.getLogger(className);
        HTMLLayout layout = new HTMLLayout();
        
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
