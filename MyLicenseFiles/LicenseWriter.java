// Decompiled by Jad v1.5.8e. Copyright 2001 Pavel Kouznetsov.
// Jad home page: http://www.geocities.com/kpdus/jad.html
// Decompiler options: packimports(3) braces fieldsfirst splitstr(80) 
// Source File Name:   LicenseWriter.java

package corona.license;

import com.rrs.license.CoronaSecretKey;
import java.io.IOException;

// Referenced classes of package corona.license:
//            License, LicenseRegistration

public interface LicenseWriter
{

    public abstract void generateLicenseFile(String s, License license, CoronaSecretKey coronasecretkey, LicenseRegistration licenseregistration)
        throws IOException;
}
