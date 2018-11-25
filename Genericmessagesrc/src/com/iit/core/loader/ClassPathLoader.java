/*********************************************************************************************
 * Copyright 2006 IDEAL INVENT Technologies Pvt. Ltd.                                        *
 * IDEAL INVENT Technologies Pvt. Ltd reserves all rights in the Program as delivered.       *
 * The Program or any portion thereof may not be reproduced in any form whatsoever except    *
 * as provided by license without the written consent of IDEAL INVENT Technologies Pvt. Ltd. *
 *																							 *
 * File Name                   : ActionProcessor.java                                 	 	 *
 * Author                      : Debadatta Mishra                                            *
 * Creation Date               : Nov 25, 2007                                                *
 * Modification History        :                											 *
 *																						     *
 *     Version No.               Date               Brief description of change              *
 *  ---------------------------------------------------------------------------------------  *
 *                       |      			|				 								 *
 *                       |                  |											 	 *
 *  ---------------------------------------------------------------------------------------  *
 *********************************************************************************************/
package com.iit.core.loader;

import java.io.File;
import java.net.URL;
import java.net.URLClassLoader;
import java.util.ArrayList;
import java.util.List;
import java.util.jar.Attributes;
import java.util.jar.JarFile;
import java.util.jar.Manifest;

/**
 * This is a thread-safe singleton class for class loading.
 * @author Debadatta Mishra
 *
 */
public class ClassPathLoader implements Loaddable {
	private String libDir = null;
	private static URLClassLoader urlClassLoader = null;
	private static List urlList = null;
	ClassLoader contextLoader = null;

	private ClassPathLoader() {
		super();
		libDir = System.getProperty("user.dir") + "/" + "lib";
	}

	public static ClassPathLoader getInstance() {
		return ClassHolder.classPathLoader;
	}

	private static class ClassHolder {
		private static final ClassPathLoader classPathLoader = new ClassPathLoader();
	}

	/**
	 * This method is used to create an instance of the class.
	 * @param className of type String indicating the class name.
	 * @return {@link Object}
	 */
	private Object loadClassInstance(String className) {
		Object instance = null;
		try {
			instance = getClassPathLoader().loadClass(className).newInstance();
		} catch (Exception e) {
			e.printStackTrace();
		}
		return instance;
	}

	/**
	 * This method is used to obtain a <code> {@link URLClassLoader} </code>
	 * @return {@link URLClassLoader}
	 */
	public URLClassLoader getClassPathLoader() {
		contextLoader = Thread.currentThread().getContextClassLoader();
		urlList = getUrlList(libDir);
		urlClassLoader = new URLClassLoader(getUrls(urlList), contextLoader);
		return urlClassLoader;
	}

	/**
	 * This method is used to obtain the list of url by passing the
	 * directory name.
	 * @param dirName of type String indicating the directory name
	 * @return a List.
	 */
	private static List getUrlList(String dirName) {
		List urlList = new ArrayList();
		List manifestJarList = getManifestClassPathList(dirName + "/"
				+ "coremessageapi.jar");
		List extraJarList = getExtraJarList(dirName, manifestJarList);
		for (int j = 0, n = extraJarList.size(); j < n; j++) {
			urlList.add(dirName + "/" + (String) extraJarList.get(j));
		}
		return urlList;
	}

	/**
	 * This mthod is used to obtain the array of urls
	 * @param urlList of type {@link List}
	 * @return URL[]
	 */
	private static URL[] getUrls(List urlList) {
		List urls = new ArrayList();
		try {
			for (int i = 0, n = urlList.size(); i < n; i++) {
				urls.add(new URL("file", "", (String) urlList.get(i)));
			}
		} catch (Exception e) {
			e.printStackTrace();
		}
		return (URL[]) urls.toArray(new URL[urlList.size()]);
	}

	/* (non-Javadoc)
	 * @see com.iit.core.loader.Loaddable#getLoadedClassObject(java.lang.String)
	 */
	public Object getLoadedClassObject(String className) {
		return loadClassInstance(className);
	}

	/**
	 * This method is used to obtain the manifest path information.
	 * @param filePath of type String indicating the file path
	 * @return a {@link List}
	 */
	public static List getManifestClassPathList(String filePath) {
		List manifestJarList = new ArrayList();
		try {
			JarFile jarFile = new JarFile(filePath);
			Manifest manifest = jarFile.getManifest();
			Attributes manifestAtr = manifest.getMainAttributes();
			String jarNames = manifestAtr.getValue("Class-Path");
			String[] onlyJars = jarNames.split("[/ ]");
			for (int i = 0; i < onlyJars.length; i++) {
				if (!onlyJars[i].equalsIgnoreCase("lib"))
					manifestJarList.add(onlyJars[i]);
			}
		} catch (Exception e) {
			e.printStackTrace();
		}
		return manifestJarList;
	}

	/**
	 * This method is used to determine , how many extra jar files are
	 * there in the class path.
	 * @param dirName of type String indicating the directory name
	 * @param manifestJarList of type {@link List}
	 * @return a list of jar files
	 */
	private static List getExtraJarList(String dirName, List manifestJarList) {
		List extraJarList = new ArrayList();
		try {
			File files = new File(dirName);
			String[] jarFileNames = files.list();

			for (int j = 0; j < jarFileNames.length; j++) {
				String temJarName = jarFileNames[j];
				if (!manifestJarList.contains(temJarName)) {
					extraJarList.add(temJarName);
				}
			}
		} catch (Exception e) {
			e.printStackTrace();
		}
		return extraJarList;
	}

}
