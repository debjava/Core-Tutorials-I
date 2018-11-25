// Decompiled by Jad v1.5.8e. Copyright 2001 Pavel Kouznetsov.
// Jad home page: http://www.geocities.com/kpdus/jad.html
// Decompiler options: packimports(3) braces fieldsfirst splitstr(80) 
// Source File Name:   LicenseData.java

package corona.license;

import java.io.Serializable;
import java.security.PrivateKey;
import java.security.PublicKey;
import javax.crypto.SecretKey;

// Referenced classes of package corona.license:
//            LicenseRegistration, ProductKey

public class LicenseData
    implements Serializable
{

    private byte secretKey[];
    private byte publicKey[];
    private byte privateKey[];
    private byte encryptedSecretKey[];
    private String mac;
    private LicenseRegistration licenseRegistration;
    private ProductKey productKey;
    private String licenseString;
    private byte licenseKey[];
    private SecretKey sk;
    private PublicKey pubkey;
    private PrivateKey prikey;

    public LicenseData()
    {
        licenseRegistration = null;
        productKey = null;
        sk = null;
        pubkey = null;
        prikey = null;
    }

    public byte[] getEncryptedSecretKey()
    {
        return encryptedSecretKey;
    }

    public void setEncryptedSecretKey(byte encryptedSecretKey[])
    {
        this.encryptedSecretKey = encryptedSecretKey;
    }

    public byte[] getLicenseKey()
    {
        return licenseKey;
    }

    public void setLicenseKey(byte licenseKey[])
    {
        this.licenseKey = licenseKey;
    }

    public LicenseRegistration getLicenseRegistration()
    {
        return licenseRegistration;
    }

    public void setLicenseRegistration(LicenseRegistration licenseRegistration)
    {
        this.licenseRegistration = licenseRegistration;
    }

    public String getLicenseString()
    {
        return licenseString;
    }

    public void setLicenseString(String licenseString)
    {
        this.licenseString = licenseString;
    }

    public String getMac()
    {
        return mac;
    }

    public void setMac(String mac)
    {
        this.mac = mac;
    }

    public byte[] getPrivateKey()
    {
        return privateKey;
    }

    public void setPrivateKey(byte privateKey[])
    {
        this.privateKey = privateKey;
    }

    public ProductKey getProductKey()
    {
        return productKey;
    }

    public void setProductKey(ProductKey productKey)
    {
        this.productKey = productKey;
    }

    public byte[] getPublicKey()
    {
        return publicKey;
    }

    public void setPublicKey(byte publicKey[])
    {
        this.publicKey = publicKey;
    }

    public byte[] getSecretKey()
    {
        return secretKey;
    }

    public void setSecretKey(byte secretKey[])
    {
        this.secretKey = secretKey;
    }

    public void setAllKeys(SecretKey sk, PublicKey pubkey, PrivateKey prikey)
    {
        this.sk = sk;
        this.pubkey = pubkey;
        this.prikey = prikey;
    }

    public Object[] getAllKeys()
    {
        Object keys[] = {
            sk, pubkey
        };
        return keys;
    }
}
