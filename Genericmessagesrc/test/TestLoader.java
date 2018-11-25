//
//import java.lang.reflect.Method;
//import java.util.Properties;
//
//import com.iit.core.loader.AbstractClassLoader;
//import com.iit.core.loader.AbstractLoadderFactory;
//import com.iit.core.loader.JarClassLoader;
//import com.iit.core.loader.Loaddable;
//
//public class TestLoader extends AbstractClassLoader
//{
//	public static void main(String[] args) 
//	{
//		try 
//		{
//			Properties pro = new Properties();
////			JarClassLoader jarClassLoader = new JarClassLoader("C:/BASEPM_TEMP_TEST/TestProj/tt.jar");
////			
//////			Class.forName("com.dds.core.iit.test");
////			Object ti= (Object)jarClassLoader.loadClass("com.dds.core.iit.test.Addition").newInstance();
////			System.out.println(ti);
////			
////			
//////			Method[] method = jarClassLoader.loadClass("com.dds.core.iit.test.Addition").getDeclaredMethods();
//////			
//////			for( int i = 0 ; i < method.length ; i++ )
//////			{
//////				System.out.println(method[i].invoke( ti , 2,3));
//////			}
////			Loadable loader = AbstractLoadderFactory.getInstance();
////			Object obj = loader.loadClass("org.apache.log4j.Logger");
////			System.out.println(obj);
//			
//			Object obj1 = ClassLoader.getSystemClassLoader().loadClass("org.apache.velocity.VelocityContext").newInstance();
//			
//			
//			System.out.println("-------"+obj1);
//			Class cls = new TestLoader().loadClass("org.apache.velocity.VelocityContext");
//			System.out.println(cls.newInstance());
//			
//			
//			
//		}
//		catch (Exception e) 
//		{
//			e.printStackTrace();
//		}
//
//	}
//	
//	protected byte[] loadClassBytes(String className) {
//		
//		return null;
//	}
//}
