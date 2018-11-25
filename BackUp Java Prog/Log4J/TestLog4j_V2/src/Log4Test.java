import org.apache.log4j.FileAppender;
import org.apache.log4j.Level;
import org.apache.log4j.Logger;
import org.apache.log4j.SimpleLayout;

public class Log4Test
{
    static Logger logger = Logger.getLogger(Log4Test.class);

    public static void main(String[] args)
    {
        FileAppender appender = null;
        SimpleLayout layout = new SimpleLayout();
        
        try
        {
            appender = new FileAppender(layout,"E:/Works/TestLog4j_V2/PIKULOG.log",false);
            
        }
        catch(Exception e)
        {
            e.printStackTrace();
        }
        
        logger.addAppender(appender);
        logger.setLevel((Level) Level.DEBUG);

        logger.info("*********************"+System.currentTimeMillis());
        logger.debug("Here is some DEBUG");
        logger.info("Here is some INFO");
        logger.warn("Here is some WARN");
        logger.error("Here is some ERROR");
        logger.fatal("Here is some FATAL");
    }
}
