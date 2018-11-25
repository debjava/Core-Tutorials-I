// Decompiled by Jad v1.5.8e. Copyright 2001 Pavel Kouznetsov.
// Jad home page: http://www.geocities.com/kpdus/jad.html
// Decompiler options: packimports(3) braces fieldsfirst splitstr(80) 
// Source File Name:   LicenseUtils.java

package corona.license.util;

import corona.license.LicenseRegistration;
import corona.license.ProductKey;
import java.io.*;
import java.security.*;
import java.util.ArrayList;
import java.util.Iterator;
import javax.crypto.*;
import javax.crypto.spec.SecretKeySpec;
import org.doomdark.uuid.EthernetAddress;
import org.doomdark.uuid.NativeInterfaces;

public class LicenseUtils
{

    KeyGenerator kgen;
    KeyPairGenerator keyPairGen;
    Cipher encryptionCipher;
    Cipher decryptionCipher;
    Cipher symmetricCipher;
    private static final String CORONAHOME = "CORONA_HOME";
    private static final String NATIVELIBPATH = "/lib/native";

    public LicenseUtils()
    {
        kgen = null;
        keyPairGen = null;
        encryptionCipher = null;
        decryptionCipher = null;
        symmetricCipher = null;
        try
        {
            kgen = KeyGenerator.getInstance("AES");
            kgen.init(128);
            symmetricCipher = Cipher.getInstance("AES/ECB/PKCS5Padding");
            keyPairGen = KeyPairGenerator.getInstance("RSA");
            keyPairGen.initialize(1024, new SecureRandom());
            encryptionCipher = Cipher.getInstance("RSA/ECB/PKCS1Padding");
            decryptionCipher = Cipher.getInstance("RSA/ECB/PKCS1Padding");
        }
        catch(NoSuchAlgorithmException e)
        {
            e.printStackTrace();
        }
        catch(NoSuchPaddingException e)
        {
            e.printStackTrace();
        }
    }

    public static EthernetAddress getEth(String strNativeLibDirFullPath)
    {
        EthernetAddress eth = null;
        try
        {
            if(strNativeLibDirFullPath != null)
            {
                File fNativeLibDir = new File(strNativeLibDirFullPath);
                if(fNativeLibDir.exists())
                {
                    NativeInterfaces.setLibDir(fNativeLibDir);
                } else
                {
                    NativeInterfaces.setUseStdLibDir(true);
                }
            } else
            {
                NativeInterfaces.setUseStdLibDir(true);
            }
            eth = NativeInterfaces.getPrimaryInterface();
        }
        catch(Exception exp)
        {
            exp.printStackTrace();
        }
        return eth;
    }

    public KeyPair generateKeys()
    {
        KeyPair pair = keyPairGen.generateKeyPair();
        return pair;
    }

    public SecretKey generateKey()
    {
        SecretKey skey = kgen.generateKey();
        return skey;
    }

    public byte[] encrypt(byte source[], Key key)
        throws NoSuchAlgorithmException, NoSuchPaddingException, InvalidKeyException, IllegalBlockSizeException, BadPaddingException
    {
        symmetricCipher.init(1, key);
        byte encryptedSource[] = symmetricCipher.doFinal(source);
        return encryptedSource;
    }

    public byte[] decrypt(byte encryptedSource[], Key key)
        throws NoSuchAlgorithmException, NoSuchPaddingException, InvalidKeyException, IllegalBlockSizeException, BadPaddingException
    {
        symmetricCipher.init(2, key);
        byte source[] = symmetricCipher.doFinal(encryptedSource);
        return source;
    }

    public byte[] encryptKey(byte keySource[], Key key)
        throws NoSuchAlgorithmException, NoSuchPaddingException, InvalidKeyException, IllegalBlockSizeException, BadPaddingException
    {
        encryptionCipher.init(1, key);
        byte encryptedKeySource[] = encryptionCipher.doFinal(keySource);
        return encryptedKeySource;
    }

    public byte[] decryptKey(byte encryptedKeySource[], Key key)
        throws NoSuchAlgorithmException, NoSuchPaddingException, InvalidKeyException, IllegalBlockSizeException, BadPaddingException
    {
        decryptionCipher.init(2, key);
        byte keySource[] = decryptionCipher.doFinal(encryptedKeySource);
        return keySource;
    }

    public String getLicenseString(LicenseRegistration licenseRegistration2, ProductKey coronaProductKey2)
    {
        String lKey = (new StringBuilder(String.valueOf(licenseRegistration2.getMacAddress()))).append("$").append(coronaProductKey2.getProductKey()).toString();
        System.out.println((new StringBuilder("MacAddress$ProductKey: ")).append(lKey).toString());
        return lKey;
    }

    public static String toHex(byte buf[])
    {
        StringBuffer strbuf = new StringBuffer(buf.length * 2);
        for(int i = 0; i < buf.length; i++)
        {
            if((buf[i] & 0xff) < 16)
            {
                strbuf.append("0");
            }
            strbuf.append(Long.toString(buf[i] & 0xff, 16));
        }

        return strbuf.toString();
    }

    private void byte2hex(byte b, StringBuffer buf)
    {
        char hexChars[] = {
            '0', '1', '2', '3', '4', '5', '6', '7', '8', '9', 
            'A', 'B', 'C', 'D', 'E', 'F'
        };
        int high = (b & 0xf0) >> 4;
        int low = b & 0xf;
        buf.append(hexChars[high]);
        buf.append(hexChars[low]);
    }

    public String toHexString(byte block[])
    {
        StringBuffer buf = new StringBuffer();
        int len = block.length;
        for(int i = 0; i < len; i++)
        {
            byte2hex(block[i], buf);
            if(i < len - 1)
            {
                buf.append(":");
            }
        }

        return buf.toString();
    }

    public byte[] decodeHex(char data[])
        throws Exception
    {
        int len = data.length;
        if((len & 1) != 0)
        {
            throw new Exception("Odd number of characters.");
        }
        byte out[] = new byte[len >> 1];
        int i = 0;
        for(int j = 0; j < len;)
        {
            int f = toDigit(data[j], j) << 4;
            j++;
            f |= toDigit(data[j], j);
            j++;
            out[i] = (byte)(f & 0xff);
            i++;
        }

        return out;
    }

    protected int toDigit(char ch, int index)
        throws Exception
    {
        int digit = Character.digit(ch, 16);
        if(digit == -1)
        {
            throw new Exception((new StringBuilder("Illegal hexadecimal charcter ")).append(ch).append(" at index ").append(index).toString());
        } else
        {
            return digit;
        }
    }

    public static ArrayList loadFile(String fileName)
    {
        if(fileName == null || fileName == "")
        {
            throw new IllegalArgumentException();
        }
        ArrayList fileContents = new ArrayList();
        try
        {
            BufferedReader in = new BufferedReader(new FileReader(fileName));
            if(!in.ready())
            {
                throw new IOException();
            }
            String line;
            while((line = in.readLine()) != null) 
            {
                fileContents.add(line);
            }
            in.close();
        }
        catch(IOException e)
        {
            System.out.println(e);
            return null;
        }
        return fileContents;
    }

    public static ArrayList loadFile(File licensefile)
    {
        String fileName = null;
        try
        {
            fileName = licensefile.getCanonicalPath();
        }
        catch(IOException e)
        {
            e.printStackTrace();
        }
        ArrayList fileContents = loadFile(fileName);
        return fileContents;
    }

    public static void unloadFile(String fileName, ArrayList fileInfo)
    {
        if(fileName == null || fileName == "")
        {
            throw new IllegalArgumentException();
        }
        try
        {
            BufferedWriter out = new BufferedWriter(new FileWriter(fileName));
            for(Iterator iterator = fileInfo.iterator(); iterator.hasNext(); out.flush())
            {
                String line = (String)iterator.next();
                out.write(line);
                out.write("\n");
            }

            out.close();
        }
        catch(IOException e)
        {
            System.out.println(e);
        }
    }

    public static void main(String args[])
    {
        KeyGenerator kgen = null;
        Cipher cipher = null;
        byte encrypted[] = (byte[])null;
        byte decrypted[] = (byte[])null;
        try
        {
            kgen = KeyGenerator.getInstance("AES");
            kgen.init(128);
            Provider prov = kgen.getProvider();
            System.out.println((new StringBuilder("Provider Info:")).append(prov.getInfo()).toString());
            System.out.println((new StringBuilder("Provider Name:")).append(prov.getName()).toString());
            System.out.println((new StringBuilder("Provider Version:")).append(prov.getVersion()).toString());
            cipher = Cipher.getInstance("AES/ECB/PKCS5Padding");
        }
        catch(NoSuchAlgorithmException e1)
        {
            e1.printStackTrace();
        }
        catch(NoSuchPaddingException e1)
        {
            e1.printStackTrace();
        }
        SecretKey skey = kgen.generateKey();
        byte raw[] = skey.getEncoded();
        System.out.println("---------------------------------------");
        System.out.println(raw);
        System.out.println((new StringBuilder("Secret Key encoding format:")).append(skey.getFormat()).toString());
        System.out.println((new StringBuilder("Secret Key algorithm:")).append(skey.getAlgorithm()).toString());
        System.out.println(raw);
        byte abyte0[] = raw;
        int i = 0;
        for(int j = abyte0.length; i < j; i++)
        {
            byte keybyte = abyte0[i];
            System.out.print(keybyte);
        }

        System.out.println();
        System.out.println(new String(raw));
        System.out.println((new StringBuilder("Secret Key hex format: ")).append(toHex(raw)).toString());
        System.out.println("---------------------------------------");
        try
        {
            cipher.init(1, skey);
        }
        catch(InvalidKeyException e)
        {
            e.printStackTrace();
        }
        try
        {
            byte text[] = "This is just an example".getBytes();
            encrypted = cipher.doFinal(text);
            System.out.println("---------------------------------------");
            System.out.println(text);
            byte abyte1[] = text;
            int k = 0;
            for(int l = abyte1.length; k < l; k++)
            {
                byte it1 = abyte1[k];
                System.out.print(it1);
            }

            System.out.println();
            System.out.println(new String(text));
            System.out.println((new StringBuilder("Text in hex format: ")).append(toHex(text)).toString());
            System.out.println("---------------------------------------");
            System.out.println(encrypted);
            abyte1 = encrypted;
            k = 0;
            for(int i1 = abyte1.length; k < i1; k++)
            {
                byte it2 = abyte1[k];
                System.out.print(it2);
            }

            System.out.println();
            System.out.println(new String(encrypted));
            System.out.println((new StringBuilder("Encrypted Text in hex format: ")).append(toHex(encrypted)).toString());
            System.out.println("---------------------------------------");
        }
        catch(IllegalBlockSizeException e)
        {
            e.printStackTrace();
        }
        catch(BadPaddingException e)
        {
            e.printStackTrace();
        }
        System.out.println("--------  Using asymmetric keys on secret key ----------");
        KeyPairGenerator kpgen = null;
        try
        {
            kpgen = KeyPairGenerator.getInstance("RSA");
        }
        catch(NoSuchAlgorithmException e)
        {
            e.printStackTrace();
        }
        kpgen.initialize(1024, new SecureRandom());
        KeyPair pair = kpgen.generateKeyPair();
        java.security.PrivateKey privateKey = pair.getPrivate();
        java.security.PublicKey publicKey = pair.getPublic();
        Cipher pubCipher = null;
        Cipher priCipher = null;
        try
        {
            pubCipher = Cipher.getInstance("RSA/ECB/PKCS1Padding");
        }
        catch(NoSuchAlgorithmException e)
        {
            e.printStackTrace();
        }
        catch(NoSuchPaddingException e)
        {
            e.printStackTrace();
        }
        try
        {
            pubCipher.init(1, publicKey);
        }
        catch(InvalidKeyException e)
        {
            e.printStackTrace();
        }
        byte pubCipherText[] = (byte[])null;
        try
        {
            pubCipherText = pubCipher.doFinal(raw);
        }
        catch(IllegalBlockSizeException e)
        {
            e.printStackTrace();
        }
        catch(BadPaddingException e)
        {
            e.printStackTrace();
        }
        System.out.println("---------------------------------------");
        System.out.println(pubCipherText);
        byte abyte2[] = pubCipherText;
        int j1 = 0;
        for(int k1 = abyte2.length; j1 < k1; j1++)
        {
            byte it1 = abyte2[j1];
            System.out.print(it1);
        }

        System.out.println();
        System.out.println(new String(pubCipherText));
        System.out.println((new StringBuilder("Text in hex format: ")).append(toHex(pubCipherText)).toString());
        System.out.println("---------------------------------------");
        try
        {
            priCipher = Cipher.getInstance("RSA/ECB/PKCS1Padding");
        }
        catch(NoSuchAlgorithmException e)
        {
            e.printStackTrace();
        }
        catch(NoSuchPaddingException e)
        {
            e.printStackTrace();
        }
        try
        {
            priCipher.init(2, privateKey);
        }
        catch(InvalidKeyException e)
        {
            e.printStackTrace();
        }
        byte pubClearText[] = (byte[])null;
        try
        {
            pubClearText = priCipher.doFinal(pubCipherText);
        }
        catch(IllegalBlockSizeException e)
        {
            e.printStackTrace();
        }
        catch(BadPaddingException e)
        {
            e.printStackTrace();
        }
        System.out.println("---------------------------------------");
        System.out.println(pubClearText);
        byte abyte3[] = pubClearText;
        int l1 = 0;
        for(int i2 = abyte3.length; l1 < i2; l1++)
        {
            byte it2 = abyte3[l1];
            System.out.print(it2);
        }

        System.out.println();
        System.out.println(new String(pubClearText));
        System.out.println((new StringBuilder("Text in hex format: ")).append(toHex(pubClearText)).toString());
        System.out.println("---------------------------------------");
        System.out.println("-------- Using the retrieved Secret Key ----------------");
        System.out.println("---------------------------------------");
        SecretKeySpec skeySpec = new SecretKeySpec(pubClearText, "AES");
        try
        {
            cipher.init(2, skeySpec);
        }
        catch(InvalidKeyException e)
        {
            e.printStackTrace();
        }
        try
        {
            decrypted = cipher.doFinal(encrypted);
        }
        catch(IllegalBlockSizeException e)
        {
            e.printStackTrace();
        }
        catch(BadPaddingException e)
        {
            e.printStackTrace();
        }
        System.out.println(decrypted);
        byte abyte4[] = decrypted;
        int j2 = 0;
        for(int k2 = abyte4.length; j2 < k2; j2++)
        {
            byte it3 = abyte4[j2];
            System.out.print(it3);
        }

        System.out.println();
        System.out.println(new String(decrypted));
        System.out.println((new StringBuilder("Decrypted Text in hex format: ")).append(toHex(decrypted)).toString());
        System.out.println("---------------------------------------");
    }
}
