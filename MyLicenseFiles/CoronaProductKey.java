// Decompiled by Jad v1.5.8e. Copyright 2001 Pavel Kouznetsov.
// Jad home page: http://www.geocities.com/kpdus/jad.html
// Decompiler options: packimports(3) braces fieldsfirst splitstr(80) 
// Source File Name:   CoronaProductKey.java

package com.rrs.license;

import corona.license.ProductKey;
import java.io.Serializable;

public class CoronaProductKey
    implements ProductKey, Serializable
{

    String productKey;

    public CoronaProductKey()
    {
    }

    public String getProductKey()
    {
        return productKey;
    }

    public void setProductKey(String productKey)
    {
        this.productKey = productKey;
    }
}
