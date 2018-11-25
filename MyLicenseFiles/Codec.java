// Decompiled by Jad v1.5.8e. Copyright 2001 Pavel Kouznetsov.
// Jad home page: http://www.geocities.com/kpdus/jad.html
// Decompiler options: packimports(3) braces fieldsfirst splitstr(80) 
// Source File Name:   Codec.java

package corona.license.util;

import org.apache.commons.codec.binary.Base64;

public class Codec
{

    private Base64 codec;

    public Codec()
    {
        codec = null;
        codec = new Base64();
    }

    public byte[] decode(byte pArray[])
    {
        return codec.decode(pArray);
    }

    public byte[] encode(byte pArray[])
    {
        return codec.encode(pArray);
    }
}
