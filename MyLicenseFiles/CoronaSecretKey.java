// Decompiled by Jad v1.5.8e. Copyright 2001 Pavel Kouznetsov.
// Jad home page: http://www.geocities.com/kpdus/jad.html
// Decompiler options: packimports(3) braces fieldsfirst splitstr(80) 
// Source File Name:   CoronaSecretKey.java

package com.rrs.license;

import corona.license.ISecretKey;
import java.io.Serializable;

public class CoronaSecretKey
    implements ISecretKey, Serializable
{

    private byte encodedSecretKey[];

    public CoronaSecretKey()
    {
        encodedSecretKey = null;
    }

    public CoronaSecretKey(byte encodedSecretKey[])
    {
        this.encodedSecretKey = null;
        this.encodedSecretKey = encodedSecretKey;
    }

    public byte[] getEncodedSecretKey()
    {
        return encodedSecretKey;
    }
}
