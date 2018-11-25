// Decompiled by Jad v1.5.8e. Copyright 2001 Pavel Kouznetsov.
// Jad home page: http://www.geocities.com/kpdus/jad.html
// Decompiler options: packimports(3) braces fieldsfirst splitstr(80) 
// Source File Name:   ProductKey.java

package corona.license;

import java.io.Serializable;

public interface ProductKey
    extends Serializable
{

    public abstract String getProductKey();

    public abstract void setProductKey(String s);
}
