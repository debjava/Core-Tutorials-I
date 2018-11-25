// Decompiled by Jad v1.5.8e. Copyright 2001 Pavel Kouznetsov.
// Jad home page: http://www.geocities.com/kpdus/jad.html
// Decompiler options: packimports(3) braces fieldsfirst splitstr(80) 
// Source File Name:   ProductLicense.java

package com.rrs.license;

import corona.license.License;
import java.io.Serializable;

public class ProductLicense
    implements License, Serializable
{

    private long startDate;
    private long endDate;
    private String licenseKey;
    private int productType;

    public ProductLicense()
    {
        licenseKey = null;
    }

    public ProductLicense(long startDate, long endDate, String licenseKey, int productType)
    {
        this.licenseKey = null;
        this.startDate = startDate;
        this.endDate = endDate;
        this.licenseKey = licenseKey;
        this.productType = productType;
    }

    public long getStartDate()
    {
        return startDate;
    }

    public long getEndDate()
    {
        return endDate;
    }

    public String getLicenseKey()
    {
        return licenseKey;
    }

    public void setEndDate(long endDate)
    {
        this.endDate = endDate;
    }

    public void setLicenseKey(String licenseKey)
    {
        this.licenseKey = licenseKey;
    }

    public void setStartDate(long startDate)
    {
        this.startDate = startDate;
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
