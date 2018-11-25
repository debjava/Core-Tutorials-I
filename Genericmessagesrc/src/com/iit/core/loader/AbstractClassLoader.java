//package com.iit.core.loader;
//
//import java.util.Collections;
//import java.util.HashMap;
//import java.util.Map;
//
///**
// * @author debadatta.m
// *
// */
//public abstract class AbstractClassLoader extends ClassLoader {
//
//	/**
//	 * 
//	 */
//	private Map classes;
//	/**
//	 * 
//	 */
//	private char classNameReplacementChar;
//
//	/**
//	 * No arguments constructor
//	 */
//	protected AbstractClassLoader() {
//		classes = Collections.synchronizedMap(new HashMap());
//	}
//	/*
//	 * (non-Javadoc)
//	 * 
//	 * @see java.lang.ClassLoader#loadClass(java.lang.String)
//	 */
//	public Class loadClass(String className) throws ClassNotFoundException {
//		return (loadClass(className, true));
//	}
//
//	/*
//	 * (non-Javadoc)
//	 * 
//	 * @see java.lang.ClassLoader#loadClass(java.lang.String, boolean)
//	 */
//	public synchronized Class loadClass(String className, boolean resolveIt)
//			throws ClassNotFoundException {
//
//		Class result;
//		byte[] classBytes;
//		System.out.println("Coming here............******");
//		System.out.println("Loading class: " + className + ", " + resolveIt + "");
//
//		result = (Class) classes.get(className);
//		if (result != null) {
//			System.out.println("Returning local loaded class");
//			return result;
//		}
//
//		try {
//			result = super.findSystemClass(className);
//			System.out.println("Returning system class");
//			return result;
//		} catch (ClassNotFoundException e) {
//			System.out.println(e);
//		}
//
//		classBytes = loadClassBytes(className);
//		if (classBytes == null) {
//			throw new ClassNotFoundException();
//		}
//
//		result = defineClass(className, classBytes, 0, classBytes.length);
//		if (result == null) {
//			throw new ClassFormatError();
//		}
//
//		if (resolveIt)
//			resolveClass(result);
//
//		classes.put(className, result);
//		System.out.println("Return newly loaded class");
//		return result;
//	}
//
//	/**
//	 * @param replacement
//	 */
//	public void setClassNameReplacementChar(char replacement) {
//		classNameReplacementChar = replacement;
//	}
//
//	/**
//	 * Abstarct method that allows class content to be loading from other
//	 * sources
//	 * 
//	 * @param className
//	 * @return
//	 */
//	protected abstract byte[] loadClassBytes(String className);
//
//	/**
//	 * @param className
//	 * @return
//	 */
//	protected String formatClassName(String className) {
//		if (classNameReplacementChar == '\u0000') {
//			// '/' is used to map the package to the path
//			return className.replace('.', '/') + ".class";
//		} else {
//			// Replace '.' with custom char, such as '_'
//			return className.replace('.', classNameReplacementChar) + ".class";
//		}
//	}
//}
