// Decompiled by Jad v1.5.8e. Copyright 2001 Pavel Kouznetsov.
// Jad home page: http://www.geocities.com/kpdus/jad.html
// Decompiler options: packimports(3) braces fieldsfirst splitstr(80) 
// Source File Name:   LicenseGeneratorType.java

package corona.license;


public class LicenseGeneratorType
{

    public static final LicenseGeneratorType CORONA_DEV_LICENSE = new LicenseGeneratorType("CORONA_DEV_LICENSE");
    public static final LicenseGeneratorType CORONA_EVAL_LICENSE = new LicenseGeneratorType("CORONA_EVAL_LICENSE");
    public static final LicenseGeneratorType CORONA_PROD_LICENSE = new LicenseGeneratorType("CORONA_PROD_LICENSE");
    public static final LicenseGeneratorType COMPONENT_LICENSE = new LicenseGeneratorType("COMPONENT_LICENSE");
    private String _type;

    public LicenseGeneratorType(String aType)
    {
        _type = null;
        _type = aType;
    }

}
