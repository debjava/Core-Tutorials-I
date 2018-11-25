// Decompiled by Jad v1.5.8e. Copyright 2001 Pavel Kouznetsov.
// Jad home page: http://www.geocities.com/kpdus/jad.html
// Decompiler options: packimports(3) braces fieldsfirst splitstr(80) 
// Source File Name:   License.java

package corona.license;

import java.io.Serializable;

public interface License
    extends Serializable
{

    public abstract long getStartDate();

    public abstract long getEndDate();

    public abstract String getLicenseKey();

    public abstract int getProductType();

    public abstract void setStartDate(long l);

    public abstract void setEndDate(long l);

    public abstract void setLicenseKey(String s);

    public abstract void setProductType(int i);
}
