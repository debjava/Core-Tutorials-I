// Decompiled by Jad v1.5.8e. Copyright 2001 Pavel Kouznetsov.
// Jad home page: http://www.geocities.com/kpdus/jad.html
// Decompiler options: packimports(3) braces fieldsfirst splitstr(80) 
// Source File Name:   ComponentLicense.java

package com.rrs.license;

import corona.license.License;
import java.io.Serializable;

public class ComponentLicense
    implements License, Serializable
{

    private long startDate;
    private long endDate;
    private String key;
    private int productType;

    public ComponentLicense(long startDate, long endDate, String key)
    {
        this.key = null;
        this.startDate = startDate;
        this.endDate = endDate;
        this.key = key;
    }

    public long getStartDate()
    {
        return 0L;
    }

    public long getEndDate()
    {
        return 0L;
    }

    public String getLicenseKey()
    {
        return null;
    }

    public void setStartDate(long l)
    {
    }

    public void setEndDate(long l)
    {
    }

    public void setLicenseKey(String s)
    {
    }

    public int getProductType()
    {
        return productType;
    }

    public void setProductType(int productType)
    {
        this.productType = productType;
    }
}
