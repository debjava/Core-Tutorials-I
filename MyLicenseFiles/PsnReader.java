// Decompiled by Jad v1.5.8e. Copyright 2001 Pavel Kouznetsov.
// Jad home page: http://www.geocities.com/kpdus/jad.html
// Decompiler options: packimports(3) braces fieldsfirst splitstr(80) 
// Source File Name:   PsnReader.java

package com.rrs.license.client;

import java.io.*;
import java.util.Enumeration;
import java.util.HashMap;
import java.util.jar.*;

public class PsnReader
{

    private static final String MANIFESTPREFIX = "META-INF";
    private JarInputStream newJarIS;
    private JarFile jarFile;

    public PsnReader()
    {
        newJarIS = null;
        jarFile = null;
    }

    protected byte[] getPsnEntry(String inputJarFile, String className)
    {
        byte retBuff[] = (byte[])null;
        try
        {
            jarFile = new JarFile(inputJarFile);
            JarEntry jarEntry = jarFile.getJarEntry(className);
            retBuff = getClassBytes(jarEntry, jarFile);
        }
        catch(IOException e1)
        {
            e1.printStackTrace();
        }
        return retBuff;
    }

    protected HashMap getAllPsnEntries(String inputJarFile)
    {
        HashMap hMapClassBuffers = new HashMap();
        try
        {
            jarFile = new JarFile(inputJarFile);
            for(Enumeration jarEntries = jarFile.entries(); jarEntries.hasMoreElements();)
            {
                JarEntry jarEntry = (JarEntry)(JarEntry)jarEntries.nextElement();
                String strClassName = jarEntry.getName();
                if(!strClassName.startsWith("META-INF"))
                {
                    byte retBuff[] = getClassBytes(jarEntry, jarFile);
                    hMapClassBuffers.put(strClassName, retBuff);
                }
            }

        }
        catch(IOException e1)
        {
            e1.printStackTrace();
        }
        return hMapClassBuffers;
    }

    private byte[] getClassBytes(JarEntry jEntry, JarFile jFile)
    {
        byte buffer[] = new byte[1024];
        ByteArrayOutputStream baos = null;
        try
        {
            InputStream is = jFile.getInputStream(jEntry);
            baos = new ByteArrayOutputStream();
            int bytesRead;
            while((bytesRead = is.read(buffer)) != -1) 
            {
                baos.write(buffer, 0, bytesRead);
            }
        }
        catch(IOException e)
        {
            e.printStackTrace();
        }
        if(baos != null)
        {
            return baos.toByteArray();
        } else
        {
            return null;
        }
    }
}
