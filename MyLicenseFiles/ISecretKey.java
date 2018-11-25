// Decompiled by Jad v1.5.8e. Copyright 2001 Pavel Kouznetsov.
// Jad home page: http://www.geocities.com/kpdus/jad.html
// Decompiler options: packimports(3) braces fieldsfirst splitstr(80) 
// Source File Name:   ISecretKey.java

package corona.license;

import java.io.Serializable;

public interface ISecretKey
    extends Serializable
{

    public abstract byte[] getEncodedSecretKey();
}
