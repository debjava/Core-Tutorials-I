// Decompiled by Jad v1.5.8e. Copyright 2001 Pavel Kouznetsov.
// Jad home page: http://www.geocities.com/kpdus/jad.html
// Decompiler options: packimports(3) braces fieldsfirst splitstr(80) 
// Source File Name:   KeyAndRegistrationReader.java

package com.rrs.license.client;

import com.rrs.license.CoronaLicenseRegistration;
import com.rrs.license.CoronaProductKey;
import corona.license.LicenseRegistration;
import corona.license.ProductKey;
import java.io.*;

// Referenced classes of package com.rrs.license.client:
//            PsnReader

public class KeyAndRegistrationReader
{

    private static final String KEYCLS = "psn";
    private static final String REGCLS = "rgn";

    public KeyAndRegistrationReader()
    {
    }

    protected static ProductKey getProductKey(String JarFile)
    {
        CoronaProductKey cpk = null;
        PsnReader jarReader = new PsnReader();
        byte theBuffer[] = jarReader.getPsnEntry(JarFile, "psn");
        try
        {
            ObjectInputStream ois = new ObjectInputStream(new ByteArrayInputStream(theBuffer));
            cpk = (CoronaProductKey)ois.readObject();
            ois.close();
        }
        catch(IOException e)
        {
            e.printStackTrace();
        }
        catch(ClassNotFoundException e)
        {
            e.printStackTrace();
        }
        return cpk;
    }

    protected static LicenseRegistration getLicenseRegistration(String JarFile)
    {
        CoronaLicenseRegistration clr = null;
        PsnReader jarReader = new PsnReader();
        byte theBuffer[] = jarReader.getPsnEntry(JarFile, "rgn");
        try
        {
            ObjectInputStream ois = new ObjectInputStream(new ByteArrayInputStream(theBuffer));
            clr = (CoronaLicenseRegistration)ois.readObject();
            ois.close();
        }
        catch(IOException e)
        {
            e.printStackTrace();
        }
        catch(ClassNotFoundException e)
        {
            e.printStackTrace();
        }
        return clr;
    }
}
