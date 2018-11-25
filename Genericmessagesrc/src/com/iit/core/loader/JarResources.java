//package com.iit.core.loader;
//import java.io.BufferedInputStream;
//import java.io.FileInputStream;
//import java.io.IOException;
//import java.util.Enumeration;
//import java.util.HashMap;
//import java.util.jar.JarEntry;
//import java.util.jar.JarFile;
//import java.util.jar.JarInputStream;
//
//
///**
// * @author debadatta.m
// *
// */
//public class JarResources {
//
//	/**
//	 * 
//	 */
//	private HashMap jarEntrySizes = new HashMap();
//
//	/**
//	 * 
//	 */
//	private HashMap jarEntryContents = new HashMap();
//
//	/**
//	 * 
//	 */
//	private String jarName;
//
//
//	/**
//	 * @param jarFileName
//	 * @throws IOException
//	 */
//	protected JarResources(String jarFileName) throws IOException {
//		this.jarName = jarFileName;
//		System.out.println("=========="+jarFileName+"=============");
//		loadJar();
//	}
//
//	/**
//	 * @param name
//	 * @return
//	 */
//	public byte[] getResource(String name) {
//		return (byte[]) jarEntryContents.get(name);
//	}
//
//	/**
//	 * Load the jar contents
//	 * 
//	 * @throws IOException
//	 */
//	private void loadJar() throws IOException {
//
//		FileInputStream fis = null;
//		BufferedInputStream bis = null;
//		JarInputStream jis = null;
//
//		try {
//			System.out.println("=========="+jarName+"=============");
//			JarFile jarFile = new JarFile(jarName);
//			Enumeration e = jarFile.entries();
//			while (e.hasMoreElements()) {
//				JarEntry jarEntry = (JarEntry) e.nextElement();
//
//				System.out.println(dump(jarEntry));
//
//				jarEntrySizes.put(jarEntry.getName(), new Integer(
//						(int) jarEntry.getSize()));
//			}
//			jarFile.close();
//
//			fis = new FileInputStream(jarName);
//			bis = new BufferedInputStream(fis);
//			jis = new JarInputStream(bis);
//
//			JarEntry jarEntry = null;
//			while ((jarEntry = jis.getNextJarEntry()) != null) {
//				if (jarEntry.isDirectory()) {
//					continue;
//				}
//
//				System.out.println("Entry Name: " + jarEntry.getName() + ","
//						+ "Entry Size: " + jarEntry.getSize());
//
//				int size = (int) jarEntry.getSize();
//				// -1 means unknown size.
//				if (size == -1) {
//					size = ((Integer) jarEntrySizes.get(jarEntry.getName()))
//							.intValue();
//				}
//
//				byte[] b = new byte[(int) size];
//				int rb = 0;
//				int chunk = 0;
//				while (((int) size - rb) > 0) {
//					chunk = jis.read(b, rb, (int) size - rb);
//					if (chunk == -1) {
//						break;
//					}
//					rb += chunk;
//				}
//
//				// add to internal resource HashMap
//				jarEntryContents.put(jarEntry.getName(), b);
//
//				System.out.println(jarEntry.getName() + "  rb=" + rb + ",size="
//						+ size + ",csize=" + jarEntry.getCompressedSize());
//			}
//		} catch (NullPointerException e) {
//			System.out.println("Done loading.");
//		} finally {
//			try {
//				jis.close();
//				bis.close();
//				fis.close();
//			} catch (Exception e) {
//			}
//		}
//	}
//
//	
//	/**
//	 * @param je
//	 * @return
//	 */
//	private String dump(JarEntry je) {
//		StringBuffer sb = new StringBuffer();
//		if (je.isDirectory()) {
//			sb.append("d ");
//		} else {
//			sb.append("f ");
//		}
//
//		if (je.getMethod() == JarEntry.STORED) {
//			sb.append("stored   ");
//		} else {
//			sb.append("defalted ");
//		}
//
//		sb.append(je.getName());
//		sb.append("\t");
//		sb.append("" + je.getSize());
//		if (je.getMethod() == JarEntry.DEFLATED) {
//			sb.append("/" + je.getCompressedSize());
//		}
//
//		return (sb.toString());
//	}
//}
