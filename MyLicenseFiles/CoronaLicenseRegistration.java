// Decompiled by Jad v1.5.8e. Copyright 2001 Pavel Kouznetsov.
// Jad home page: http://www.geocities.com/kpdus/jad.html
// Decompiler options: packimports(3) braces fieldsfirst splitstr(80) 
// Source File Name:   CoronaLicenseRegistration.java

package com.rrs.license;

import corona.license.*;
import java.io.Serializable;

public class CoronaLicenseRegistration
    implements LicenseRegistration, Serializable
{

    private static final long serialVersionUID = 0x8fb24bed492fae1bL;
    private String macAddress;
    private String companyName;
    private String companyTelephoneNumber;
    private String faxTelephoneNumber;
    private Address companyAddress;
    private Address companyHQ;
    private Name contactName;
    private String contactTelephoneNumber;
    private String emailAddress;
    private String workTelephoneNumber;
    private Name billingContactName;
    private Address billingAddress;
    private String billingEmailAddress;
    private String billingTelephoneNumber;

    public CoronaLicenseRegistration()
    {
    }

    public String getCompanyName()
    {
        return companyName;
    }

    public void setCompanyName(String companyName)
    {
        this.companyName = companyName;
    }

    public String getMacAddress()
    {
        return macAddress;
    }

    public void setMacAddress(String macAddress)
    {
        this.macAddress = macAddress;
    }

    public Address getBillingAddress()
    {
        return billingAddress;
    }

    public void setBillingAddress(Address billingAddress)
    {
        this.billingAddress = billingAddress;
    }

    public Address getCompanyAddress()
    {
        return companyAddress;
    }

    public void setCompanyAddress(Address companyAddress)
    {
        this.companyAddress = companyAddress;
    }

    public Address getCompanyHQ()
    {
        return companyHQ;
    }

    public void setCompanyHQ(Address companyHQ)
    {
        this.companyHQ = companyHQ;
    }

    public Name getContactName()
    {
        return contactName;
    }

    public void setContactName(Name contactName)
    {
        this.contactName = contactName;
    }

    public String toString()
    {
        StringBuilder sb = new StringBuilder();
        sb.append("Company Name                 :");
        sb.append(getCompanyName());
        sb.append("\n");
        sb.append("Registered MAC Address       :");
        sb.append(getMacAddress());
        return sb.toString();
    }

    public Name getBillingContactName()
    {
        return billingContactName;
    }

    public void setBillingContactName(Name billingContactName)
    {
        this.billingContactName = billingContactName;
    }

    public String getBillingEmailAddress()
    {
        return billingEmailAddress;
    }

    public void setBillingEmailAddress(String billingEmailAddress)
    {
        this.billingEmailAddress = billingEmailAddress;
    }

    public String getBillingTelephoneNumber()
    {
        return billingTelephoneNumber;
    }

    public void setBillingTelephoneNumber(String billingTelephoneNumber)
    {
        this.billingTelephoneNumber = billingTelephoneNumber;
    }

    public String getCompanyTelephoneNumber()
    {
        return companyTelephoneNumber;
    }

    public void setCompanyTelephoneNumber(String companyTelephoneNumber)
    {
        this.companyTelephoneNumber = companyTelephoneNumber;
    }

    public String getContactTelephoneNumber()
    {
        return contactTelephoneNumber;
    }

    public void setContactTelephoneNumber(String contactTelephoneNumber)
    {
        this.contactTelephoneNumber = contactTelephoneNumber;
    }

    public String getEmailAddress()
    {
        return emailAddress;
    }

    public void setEmailAddress(String emailAddress)
    {
        this.emailAddress = emailAddress;
    }

    public String getFaxTelephoneNumber()
    {
        return faxTelephoneNumber;
    }

    public void setFaxTelephoneNumber(String faxTelephoneNumber)
    {
        this.faxTelephoneNumber = faxTelephoneNumber;
    }

    public String getWorkTelephoneNumber()
    {
        return workTelephoneNumber;
    }

    public void setWorkTelephoneNumber(String workTelephoneNumber)
    {
        this.workTelephoneNumber = workTelephoneNumber;
    }
}
