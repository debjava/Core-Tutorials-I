// Decompiled by Jad v1.5.8e. Copyright 2001 Pavel Kouznetsov.
// Jad home page: http://www.geocities.com/kpdus/jad.html
// Decompiler options: packimports(3) braces fieldsfirst splitstr(80) 
// Source File Name:   LicenseServer.java

package corona.license;


// Referenced classes of package corona.license:
//            LicenseGenerator, LicenseGeneratorType

public interface LicenseServer
{

    public abstract void initLicenseServer();

    public abstract void startLicenseServer();

    public abstract void stopLicenseServer();

    public abstract LicenseGenerator getDefaultLicenseGenerator();

    public abstract LicenseGenerator getLicenseGenerator();

    public abstract LicenseGenerator getLicenseGenerator(LicenseGeneratorType licensegeneratortype);

    public abstract boolean isLicenseGenerator();

    public abstract boolean isLicenseGenerator(LicenseGeneratorType licensegeneratortype);
}
