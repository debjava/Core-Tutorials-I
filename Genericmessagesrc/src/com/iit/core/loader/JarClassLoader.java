//package com.iit.core.loader;
//
//import java.io.IOException;
//
//
///**
// * @author debadatta.m
// *
// */
//public class JarClassLoader extends AbstractClassLoader 
//{
//	/**
//	 * 
//	 */
//	private JarResources jarResources;
//
//	/**
//	 * @param jarName
//	 * @throws IOException
//	 */
//	protected JarClassLoader(String jarName) throws IOException 
//	{
//		jarResources = new JarResources(jarName);
//	}
//
//	
//	/* (non-Javadoc)
//	 * @see com.iit.core.loader.AbstractClassLoader#loadClassBytes(java.lang.String)
//	 */
//	protected byte[] loadClassBytes(String className) {
//		className = formatClassName(className);
//
//		return (jarResources.getResource(className));
//	}
//}
