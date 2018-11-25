import org.apache.log4j.Logger;

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
public class Test1
{
    static Logger log1 = new Log4Utility().LogUtility("Test.class","E:/Works/TestLog4j_V4/piku.log");
    
    public void addNos(int a,int b)
    {
        
        log1.info("********************"+System.currentTimeMillis());
        log1.info("Addition of Two nos ==="+(a/b));
        
        
    }

    public static void main(String[] args)
    {
        Test1 test = new Test1();
        test.addNos(2,3);
    }
}
