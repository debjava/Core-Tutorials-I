// Decompiled by Jad v1.5.8e. Copyright 2001 Pavel Kouznetsov.
// Jad home page: http://www.geocities.com/kpdus/jad.html
// Decompiler options: packimports(3) braces fieldsfirst splitstr(80) 
// Source File Name:   LicenseRegistration.java

package corona.license;

import java.io.Serializable;

// Referenced classes of package corona.license:
//            Address, Name

public interface LicenseRegistration
    extends Serializable
{

    public abstract void setCompanyName(String s);

    public abstract String getCompanyName();

    public abstract void setMacAddress(String s);

    public abstract String getMacAddress();

    public abstract Address getBillingAddress();

    public abstract void setBillingAddress(Address address);

    public abstract Address getCompanyAddress();

    public abstract void setCompanyAddress(Address address);

    public abstract Address getCompanyHQ();

    public abstract void setCompanyHQ(Address address);

    public abstract Name getContactName();

    public abstract void setContactName(Name name);

    public abstract String getEmailAddress();

    public abstract void setEmailAddress(String s);

    public abstract String getWorkTelephoneNumber();

    public abstract void setWorkTelephoneNumber(String s);

    public abstract String getCompanyTelephoneNumber();

    public abstract void setCompanyTelephoneNumber(String s);

    public abstract String getContactTelephoneNumber();

    public abstract void setContactTelephoneNumber(String s);

    public abstract String getFaxTelephoneNumber();

    public abstract void setFaxTelephoneNumber(String s);

    public abstract Name getBillingContactName();

    public abstract void setBillingContactName(Name name);

    public abstract String getBillingEmailAddress();

    public abstract void setBillingEmailAddress(String s);

    public abstract String getBillingTelephoneNumber();

    public abstract void setBillingTelephoneNumber(String s);
}
