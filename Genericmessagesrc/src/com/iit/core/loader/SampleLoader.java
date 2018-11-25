//package com.iit.core.loader;
//
//
//import com.iit.core.util.FileUtil;
//
//import javassist.*;
//
//public class SampleLoader extends ClassLoader 
//{
//
//    private ClassPool pool;
//
//    public SampleLoader() throws NotFoundException {
//        pool = new ClassPool();
//        String libDirName = FileUtil.APPLN_HOME+"/"+"lib"+"/";
////        pool.insertClassPath("./lib"); 
//        pool.appendClassPath(libDirName);
////        pool.insertClassPath(libDirName);
//    }
//
//    /* Finds a specified class.
//     * The bytecode for that class can be modified.
//     */
//    protected Class findClass(String name) throws ClassNotFoundException {
//    	
//    	System.out.println("In findClass====="+name);
//    	
//    	Class cls1 = null;
//    	CtClass cc = null;
//    	
//    	ClassPool cp = new ClassPool();
//        try {
//        	String libDirName = FileUtil.APPLN_HOME+"/"+"lib"+"/"+"messagedataimpl.jar";
//        	System.out.println("LibDirName======="+libDirName);
//        	
//        	String fileLists = FileUtil.getFilesList(FileUtil.APPLN_HOME+"/"+"lib");
//        	System.out.println("Total File List====>>>"+fileLists);
//        	
//        	String[] ss = fileLists.split("[;]");
//        	ClassPath clsPath = null;
//        	for( int i = 0 , n = ss.length ; i < n ; i++ )
//        	{
//        		try
//        		{
//        			clsPath = cp.appendClassPath(fileLists);
//        			System.out.println("*********** Coming here ************");
//            		cp.insertClassPath(ss[i]);
//            		cc = cp.get(name);
//            		System.out.println("cc in SampleLoader====="+cc);
//            		cp.getClassLoader().loadClass(name);
//            		byte[] b = cc.toBytecode();
//                  cls1 = defineClass(name, b, 0, b.length);
//        		}
//        		catch( Exception e )
//        		{
//        			cp.removeClassPath(clsPath);
//        			continue;
//        		}
//        		
//        	}
//        	
////        	ClassPath clsPath = cp.appendClassPath(fileLists);
////        	cp.insertClassPath(fileLists);
//          
////            CtClass cc = pool.get(name);
////        	CtClass cc = cp.get(name);
//            
//            System.out.println("cc in SampleLoader====="+cc);
//            
//            
//            // modify the CtClass object here
////            byte[] b = cc.toBytecode();
////            return defineClass(name, b, 0, b.length);
////            cls1 = defineClass(name, b, 0, b.length);
//        } 
////        catch (NotFoundException e) 
////        {
////            throw new ClassNotFoundException();
////        }
////        catch (IOException e) 
////        {
////            throw new ClassNotFoundException();
////        }
////        catch (CannotCompileException e) 
////        {
////            throw new ClassNotFoundException();
////        }
//        catch( Exception e )
//        {
//        	
//        	cls1 = cp.getClassLoader().loadClass(name);
//        	e.printStackTrace();
//        }
//        
//        return cls1;
//    }
//}
