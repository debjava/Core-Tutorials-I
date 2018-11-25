import java.io.File;
import java.io.FileInputStream;
import java.io.FileOutputStream;
import java.lang.reflect.Method;
import java.util.Properties;
import java.util.ResourceBundle;

import sun.misc.BASE64Decoder;
import sun.misc.BASE64Encoder;

import com.iit.core.scheduler.Scheduler;


public class RoughTesting 
{
	public static void main(String[] args) 
	{
			try
			{
////				File configFile = new File("/applnConfig.properties");
////				System.out.println(configFile.getCanonicalPath());
//				Properties prop = new Properties();
////				prop.load( new FileInputStream("applnConfig.properties"));
////				System.out.println(prop);
//				System.out.println(System.getProperty("java.class.path"));
//				System.out.println(new RoughTesting().getClass().getResource(
//					"applnConfig.properties").getPath());
//			System.out.println("File======"
//					+ new RoughTesting().getClass().getResource(
//							"applnConfig.properties").getPath());
//			
//			String path =RoughTesting.class.getResource(
//			"applnConfig.properties").getPath();
//			String applnConfPath = path.substring(path.indexOf("/")+1,path.length() );
//			System.out.println("applnConfig_File _ Path ======="+applnConfPath);
//			prop.load( new FileInputStream(applnConfPath));
////			System.out.println(prop);
//			
////			BASE64Encoder en = new BASE64Encoder();
////			en.encode(new FileInputStream( applnConfPath ) , new FileOutputStream( "D:/tsk.lvr"));
////			BASE64Decoder de = new BASE64Decoder();
////			de.decodeBuffer(new FileInputStream("D:/tsk.lvr"), new FileOutputStream("D:/tsr.properties"));
////			prop.load(new FileInputStream("D:/tsr.properties") );
////			System.out.println("-------"+prop);
				
				System.out.println( System.getProperty("program.name", "shutdown") );
//				
			
			}
			catch( Exception e )
			{
				e.printStackTrace();
			}
	}
}
