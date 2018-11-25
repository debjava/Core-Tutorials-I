// Decompiled by Jad v1.5.8e. Copyright 2001 Pavel Kouznetsov.
// Jad home page: http://www.geocities.com/kpdus/jad.html
// Decompiler options: packimports(3) braces fieldsfirst splitstr(80) 
// Source File Name:   Validator.java

package com.rrs.license.client;

import corona.license.*;
import corona.license.util.Codec;
import corona.license.util.LicenseUtils;
import java.io.*;
import java.security.*;
import java.security.spec.InvalidKeySpecException;
import java.security.spec.X509EncodedKeySpec;
import java.util.*;
import javax.crypto.*;
import javax.crypto.spec.SecretKeySpec;
import org.doomdark.uuid.EthernetAddress;

// Referenced classes of package com.rrs.license.client:
//            KeyAndRegistrationReader

public class Validator
{

    private Codec codec;
    private FileInputStream fis;
    private BufferedInputStream bis;
    private LicenseUtils licUtils;
    private File licenseFile;
    private String productSerialNumber;
    private String productName;
    private String licenseeName;
    private String RRSContact;
    private static final String CORONAHOME = "CORONA_HOME";
    private static final String BDMHOME = "CORONA_HOME_BDM";
    private static final String HWSHOME = "CORONA_HOME_HWS";
    private static final String SASHOME = "CORONA_HOME_SAS";
    private static final String NATIVELIBPATH = "/lib/native";

    public Validator()
    {
        codec = null;
        fis = null;
        bis = null;
        licUtils = null;
        licenseFile = null;
        productSerialNumber = null;
        productName = null;
        licenseeName = null;
        RRSContact = null;
        codec = new Codec();
        licUtils = new LicenseUtils();
        RRSContact = "401 N. Michigan Avenue, Suite 360\nChicago, IL - 60611\nPhone:312.245.2900";
    }

    public boolean validate(File licensefile, File publickeyfile, File psnfile, int productType)
        throws IOException
    {
        String strNativeLibPath = null;
        String strProductHome = null;
        licenseFile = licensefile;
        switch(productType)
        {
        case 0: // '\0'
            strProductHome = System.getenv("CORONA_HOME_BDM");
            break;

        case 1: // '\001'
            strProductHome = System.getenv("CORONA_HOME");
            break;

        case 2: // '\002'
            strProductHome = System.getenv("CORONA_HOME_HWS");
            break;

        case 3: // '\003'
            strProductHome = System.getenv("CORONA_HOME_SAS");
            break;
        }
        if(strProductHome == null)
        {
            System.out.println("------------------------------------------------");
            System.out.println("WARN:  Product install not located!");
            System.out.println("WARN:  Please contact Red Rabbit Software");
            System.out.println("------------------------------------------------");
            return false;
        } else
        {
            strNativeLibPath = strProductHome.concat("/lib/native");
            return validate(licensefile, publickeyfile, psnfile, productType, strNativeLibPath);
        }
    }

    public boolean validate(File licensefile, File publickeyfile, File psnfile, int productType, String nativeLibPath)
        throws IOException
    {
        licenseFile = licensefile;
        if(!licensefile.exists())
        {
            System.out.println("------------------------------------------------");
            System.out.println("WARN:  Product not licensed!");
            System.out.println("WARN:  Please contact Red Rabbit Software to obtain a license");
            System.out.println("------------------------------------------------");
            return false;
        }
        if(!publickeyfile.exists())
        {
            System.out.println("------------------------------------------------");
            System.out.println("WARN:  Unable to process product license!");
            System.out.println("WARN:  Please contact Red Rabbit Software to obtain your key to unlock the licen" +
"se"
);
            System.out.println("------------------------------------------------");
            return false;
        }
        if(!psnfile.exists())
        {
            System.out.println("------------------------------------------------");
            System.out.println("WARN:  This instance of the Corona Platform has not been registered!");
            System.out.println("WARN:  Please contact Red Rabbit Software to register your product");
            System.out.println("------------------------------------------------");
            return false;
        }
        EthernetAddress eth = LicenseUtils.getEth(nativeLibPath);
        String mac = eth.toString();
        ProductKey pk1 = KeyAndRegistrationReader.getProductKey(psnfile.getCanonicalPath());
        LicenseRegistration lr1 = KeyAndRegistrationReader.getLicenseRegistration(psnfile.getCanonicalPath());
        productSerialNumber = pk1.getProductKey();
        licenseeName = lr1.getCompanyName();
        if(productSerialNumber == null || productSerialNumber.equals(""))
        {
            System.out.println("------------------------------------------------");
            System.out.println("WARN:  This instance of the Corona Platform has not been registered");
            System.out.println("WARN:  Please register your product");
            System.out.println("------------------------------------------------");
            return false;
        }
        ArrayList licenseFileList = LicenseUtils.loadFile(licensefile);
        String str = (String)licenseFileList.get(0);
        byte buf[] = str.getBytes();
        byte decodedLicenseBytes[] = codec.decode(buf);
        fis = new FileInputStream(licensefile);
        bis = new BufferedInputStream(fis);
        int avail = bis.available();
        ByteArrayInputStream bais = new ByteArrayInputStream(decodedLicenseBytes);
        ObjectInputStream ois = null;
        try
        {
            ois = new ObjectInputStream(bais);
        }
        catch(StreamCorruptedException sce)
        {
            System.out.println("------------------------------------------------");
            System.out.println("The License File is corrupted");
            System.out.println("Please contact Red Rabbit Software");
            System.out.println("------------------------------------------------");
            return false;
        }
        License theLic = null;
        ISecretKey csk = null;
        try
        {
            theLic = (License)ois.readObject();
            csk = (ISecretKey)ois.readObject();
        }
        catch(IOException e)
        {
            System.out.println("------------------------------------------------");
            System.out.println("The License Key may be corrupted");
            System.out.println("Please contact Red Rabbit Software");
            System.out.println("------------------------------------------------");
            e.printStackTrace();
            return false;
        }
        catch(ClassNotFoundException e)
        {
            System.out.println("------------------------------------------------");
            System.out.println("The License class is not found or is invalid");
            System.out.println("Please contact Red Rabbit Software");
            System.out.println("------------------------------------------------");
            e.printStackTrace();
            return false;
        }
        int theType = theLic.getProductType();
        if(productType != theType)
        {
            System.out.println("------------------------------------------------");
            System.out.println("The License issued is NOT meant for this product");
            System.out.println("Please contact Red Rabbit Software for appropriate license");
            System.out.println("------------------------------------------------");
            overwrite("License Invalid - Please Contact Red Rabbit Software");
            return false;
        }
        switch(productType)
        {
        case 0: // '\0'
            productName = "Business Domain Modeler";
            break;

        case 1: // '\001'
            productName = "Corona Management Server";
            break;

        case 2: // '\002'
            productName = "Enterprise HotWire Studio";
            break;

        case 3: // '\003'
            productName = "Solution Accelerator Studio";
            break;
        }
        String licenseKeyHex = theLic.getLicenseKey();
        byte encodedsecretkey[] = csk.getEncodedSecretKey();
        long startTime = theLic.getStartDate();
        Calendar cal = new GregorianCalendar();
        cal.setTimeInMillis(startTime);
        long endTime = theLic.getEndDate();
        cal.clear();
        cal.setTimeInMillis(endTime);
        fis = null;
        bis = null;
        fis = new FileInputStream(publickeyfile);
        bis = new BufferedInputStream(fis);
        avail = bis.available();
        byte buf2[] = new byte[avail];
        bis.read(buf2);
        PublicKey pubkey = decodePublicKey(buf2);
        if(pubkey == null)
        {
            System.out.println("------------------------------------------------");
            System.out.println("WARN:  You do not have a valid key in your license file");
            System.out.println("WARN:  Please contact Red Rabbit Software");
            System.out.println("------------------------------------------------");
            return false;
        }
        SecretKey seckey = decodeSecretKey(encodedsecretkey, pubkey);
        if(seckey == null)
        {
            System.out.println("------------------------------------------------");
            System.out.println("WARN:  Your key in your license file could not be decoded");
            System.out.println("WARN:  Please contact Red Rabbit Software");
            System.out.println("------------------------------------------------");
            return false;
        }
        byte temp[] = seckey.getEncoded();
        byte licenseKey[] = (byte[])null;
        try
        {
            licenseKey = licUtils.decodeHex(licenseKeyHex.toCharArray());
        }
        catch(Exception e)
        {
            System.out.println("------------------------------------------------");
            System.out.println("WARN:  The license key could not be decoded");
            System.out.println("WARN:  Please contact Red Rabbit Software");
            System.out.println("------------------------------------------------");
            e.printStackTrace();
            overwrite("License Invalid - Please Contact Red Rabbit Software");
            return false;
        }
        byte decryptedLicenseKey[] = (byte[])null;
        try
        {
            decryptedLicenseKey = licUtils.decrypt(licenseKey, seckey);
        }
        catch(InvalidKeyException e)
        {
            System.out.println("------------------------------------------------");
            System.out.println("The License Key is Invalid");
            System.out.println("Please contact Red Rabbit Software");
            System.out.println("------------------------------------------------");
            e.printStackTrace();
            overwrite("License Invalid - Please Contact Red Rabbit Software");
            return false;
        }
        catch(NoSuchAlgorithmException e)
        {
            System.out.println("------------------------------------------------");
            System.out.println("The License Algorithm is Not Available");
            System.out.println("Please contact Red Rabbit Software");
            System.out.println("------------------------------------------------");
            e.printStackTrace();
            overwrite("License Invalid - Please Contact Red Rabbit Software");
            return false;
        }
        catch(NoSuchPaddingException e)
        {
            System.out.println("------------------------------------------------");
            System.out.println("The License Algorithm Padding is Not Available");
            System.out.println("Please contact Red Rabbit Software");
            System.out.println("------------------------------------------------");
            e.printStackTrace();
            return false;
        }
        catch(IllegalBlockSizeException e)
        {
            System.out.println("------------------------------------------------");
            System.out.println("The License Key has Illegal Block Size");
            System.out.println("Please contact Red Rabbit Software");
            System.out.println("------------------------------------------------");
            e.printStackTrace();
            return false;
        }
        catch(BadPaddingException e)
        {
            System.out.println("------------------------------------------------");
            System.out.println("The License Algorithm has bad Padding");
            System.out.println("Please contact Red Rabbit Software");
            System.out.println("------------------------------------------------");
            e.printStackTrace();
            return false;
        }
        String licenseString = new String(decryptedLicenseKey);
        String vals[] = licenseString.split("\\$");
        String mac1 = vals[0];
        String productSerialNumber1 = vals[1];
        boolean valid = validateLicensePeriod(startTime, endTime);
        if(!valid)
        {
            System.out.println("------------------------------------------------");
            System.out.println("WARN:  Platform is NOT allowed to execute as time expired");
            System.out.println("Please contact Red Rabbit Software");
            System.out.println("------------------------------------------------");
            overwrite("License Invalid - Please Contact Red Rabbit Software");
            return valid;
        }
        int result = mac.compareTo(mac1);
        int result2 = productSerialNumber.compareTo(productSerialNumber1);
        if(result == 0)
        {
            if(result2 == 0)
            {
                System.out.println("------------------------------------------------");
                System.out.println("INFO:  Platform is allowed to execute: ");
                System.out.println("------------------------------------------------");
                return true;
            } else
            {
                System.out.println("------------------------------------------------");
                System.out.println("WARN:  Platform registration is not authorized ");
                System.out.println("WARN:  Please contact Red Rabbit Software immediately as you are in violation of" +
" your license registration"
);
                System.out.println("------------------------------------------------");
                overwrite("License Invalid - Please Contact Red Rabbit Software");
                return false;
            }
        } else
        {
            System.out.println("------------------------------------------------");
            System.out.println("WARN:  Platform is NOT allowed to execute as mac address is different");
            System.out.println("Please contact Red Rabbit Software");
            System.out.println("------------------------------------------------");
            overwrite("License Invalid - Please Contact Red Rabbit Software");
            return false;
        }
    }

    private boolean validateLicensePeriod(long startTime, long endTime)
    {
        boolean valid = false;
        long time = System.currentTimeMillis();
        long startdiff = time - startTime;
        long enddiff = endTime - time;
        if(startdiff < 0L || enddiff < 0L)
        {
            valid = false;
        } else
        {
            valid = true;
        }
        return valid;
    }

    private SecretKey decodeSecretKey(byte encodedsecretkey[], PublicKey pubkey)
    {
        byte decodedsecretkey[] = (byte[])null;
        try
        {
            decodedsecretkey = licUtils.decryptKey(encodedsecretkey, pubkey);
        }
        catch(InvalidKeyException e)
        {
            System.out.println("------------------------------------------------");
            System.out.println("The Key is Invalid");
            System.out.println("Please contact Red Rabbit Software");
            System.out.println("------------------------------------------------");
            e.printStackTrace();
            return null;
        }
        catch(NoSuchAlgorithmException e)
        {
            System.out.println("------------------------------------------------");
            System.out.println("The Algorithm is Not Available");
            System.out.println("Please contact Red Rabbit Software");
            System.out.println("------------------------------------------------");
            e.printStackTrace();
            return null;
        }
        catch(NoSuchPaddingException e)
        {
            System.out.println("------------------------------------------------");
            System.out.println("The Algorithm Padding is Not Available");
            System.out.println("Please contact Red Rabbit Software");
            System.out.println("------------------------------------------------");
            e.printStackTrace();
            return null;
        }
        catch(IllegalBlockSizeException e)
        {
            System.out.println("------------------------------------------------");
            System.out.println("The Key has Illegal Block Size");
            System.out.println("Please contact Red Rabbit Software");
            System.out.println("------------------------------------------------");
            e.printStackTrace();
            return null;
        }
        catch(BadPaddingException e)
        {
            System.out.println("------------------------------------------------");
            System.out.println("The Algorithm has bad Padding");
            System.out.println("Please contact Red Rabbit Software");
            System.out.println("------------------------------------------------");
            e.printStackTrace();
            return null;
        }
        SecretKey seckey = null;
        seckey = new SecretKeySpec(decodedsecretkey, "AES");
        return seckey;
    }

    private PublicKey decodePublicKey(byte buf2[])
    {
        byte decodedKeyBytes[] = codec.decode(buf2);
        PublicKey pubkey = null;
        X509EncodedKeySpec pubKeySpec = new X509EncodedKeySpec(decodedKeyBytes);
        KeyFactory keyFactory = null;
        try
        {
            keyFactory = KeyFactory.getInstance("RSA");
        }
        catch(NoSuchAlgorithmException e)
        {
            System.out.println("------------------------------------------------");
            System.out.println("The Public Key has no Algorithm Available");
            System.out.println("Please contact Red Rabbit Software");
            System.out.println("------------------------------------------------");
            e.printStackTrace();
            return null;
        }
        try
        {
            pubkey = keyFactory.generatePublic(pubKeySpec);
        }
        catch(InvalidKeySpecException e)
        {
            System.out.println("------------------------------------------------");
            System.out.println("The Public Key Spec is Invalid");
            System.out.println("Please contact Red Rabbit Software");
            System.out.println("------------------------------------------------");
            e.printStackTrace();
            return null;
        }
        byte pubkeybytes[] = pubkey.getEncoded();
        return pubkey;
    }

    public String getProductSerialNumber(File psnfile)
    {
        if(!psnfile.exists())
        {
            System.out.println("------------------------------------------------");
            System.out.println("WARN:  This instance of the Corona Platform has not been registered!");
            System.out.println("------------------------------------------------");
            return null;
        }
        try
        {
            ProductKey pk1 = KeyAndRegistrationReader.getProductKey(psnfile.getCanonicalPath());
            return pk1.getProductKey();
        }
        catch(IOException e)
        {
            System.out.println("------------------------------------------------");
            System.out.println("WARN:  This instance of the Corona Platform has not been registered!");
            System.out.println("------------------------------------------------");
            e.printStackTrace();
            return null;
        }
    }

    public final String getLicenseeName()
    {
        return licenseeName;
    }

    public final String getProductName()
    {
        return productName;
    }

    public final String getProductSerialNumber()
    {
        return productSerialNumber;
    }

    public final String getRRSContact()
    {
        return RRSContact;
    }

    private void overwrite(String msg)
    {
        byte errmsg[] = msg.getBytes();
        byte errmsg_encoded[] = codec.encode(errmsg);
        try
        {
            FileOutputStream licfos = new FileOutputStream(licenseFile);
            BufferedOutputStream licbos = new BufferedOutputStream(licfos);
            licbos.write(errmsg_encoded);
            licbos.flush();
        }
        catch(FileNotFoundException fnfe)
        {
            fnfe.printStackTrace();
        }
        catch(IOException ioe)
        {
            ioe.printStackTrace();
        }
    }

    public static void main(String args[])
    {
        String licensefilename = "license.rrs";
        File licensefile = new File(licensefilename);
        String pubkeyfilename = "public.rrs";
        File pubkeyfile = new File(pubkeyfilename);
        String psnfilename = "prjfile";
        File psnfile = new File(psnfilename);
        int testProductType = 1;
        Validator validator = new Validator();
        try
        {
            validator.validate(licensefile, pubkeyfile, psnfile, testProductType);
            System.out.println((new StringBuilder("Product Serial Number is: ")).append(validator.getProductSerialNumber(psnfile)).toString());
            System.out.println((new StringBuilder("Product Name: ")).append(validator.getProductName()).toString());
            System.out.println((new StringBuilder("Licensee Name: ")).append(validator.getLicenseeName()).toString());
            System.out.println((new StringBuilder("RRS Contact: ")).append(validator.getRRSContact()).toString());
        }
        catch(IOException e)
        {
            e.printStackTrace();
        }
    }
}
