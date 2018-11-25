/*********************************************************************************************
 * Copyright 2006 IDEAL INVENT Technologies Pvt. Ltd.                                        *
 * IDEAL INVENT Technologies Pvt. Ltd reserves all rights in the Program as delivered.       *
 * The Program or any portion thereof may not be reproduced in any form whatsoever except    *
 * as provided by license without the written consent of IDEAL INVENT Technologies Pvt. Ltd. *
 *																							 *
 * File Name                   : Security.java                                 	 	 		 *
 * Author                      : Debadatta Mishra                                            *
 * Creation Date               : Nov 25, 2007                                                *
 * Modification History        :                											 *
 *																						     *
 *     Version No.               Date               Brief description of change              *
 *  ---------------------------------------------------------------------------------------  *
 *                       |      			|				 								 *
 *                       |                  |											 	 *
 *  ---------------------------------------------------------------------------------------  *
 *********************************************************************************************/
package com.iit.core.util;

import java.security.InvalidKeyException;
import java.security.NoSuchAlgorithmException;
import java.security.spec.InvalidKeySpecException;

import javax.crypto.Cipher;
import javax.crypto.KeyGenerator;
import javax.crypto.SecretKey;
import javax.crypto.SecretKeyFactory;
import javax.crypto.spec.DESedeKeySpec;

import com.iit.core.common.Common;

/**
 * This class is an implementation for the Triple DES algorithm,
 * provided by SUN JCE, Java Cryptography Extension.
 * 
 * @author <a href="mailTo:debadatta.m@idealinvent.com">Debadatta Mishra</a>
 *
 */
public final class Security {
	/**
	 * Object of type {@link Cipher}
	 */
	private static Cipher cipher = null;

	static {
		try {
			cipher = Cipher.getInstance("DESede");
		} catch (Exception e) {
			e.printStackTrace();
		}
	}

	/**
	 * private constructor.
	 */
	private Security() {
		super();
	}

	/**
	 * This method is used to obtain an object of 
	 * <code> {@link SecretKey} </code>.
	 * @return a {@link SecretKey}
	 * @throws NoSuchAlgorithmException
	 * @author <a href="mailTo:debadatta.m@idealinvent.com">Debadatta Mishra</a>
	 */
	public static SecretKey generateKey() throws NoSuchAlgorithmException {
		KeyGenerator keygen = KeyGenerator.getInstance("DESede");
		return keygen.generateKey();
	}

	/**
	 * This method is used to obtain an object of type 
	 * <code> {@link SecretKey} </code> by passing the 
	 * key alogorithm.
	 * @param stringKey of type string 
	 * @return
	 * @throws NoSuchAlgorithmException
	 * @throws InvalidKeyException
	 * @throws InvalidKeySpecException
	 * @author <a href="mailTo:debadatta.m@idealinvent.com">Debadatta Mishra</a>
	 */
	public static SecretKey getSecretAgentKey(String stringKey)
			throws NoSuchAlgorithmException, InvalidKeyException,
			InvalidKeySpecException {
		byte[] rawkey = stringKey.getBytes();
		DESedeKeySpec keyspec = new DESedeKeySpec(rawkey);
		SecretKeyFactory keyfactory = SecretKeyFactory.getInstance("DESede");
		SecretKey key = keyfactory.generateSecret(keyspec);
		return key;
	}

	/**
	 * This method is used to obtain an object of type
	 * <code> {@link SecretKey} </code>.
	 * @return an object of type {@link SecretKey}
	 * @throws NoSuchAlgorithmException
	 * @throws InvalidKeyException
	 * @throws InvalidKeySpecException
	 * @author <a href="mailTo:debadatta.m@idealinvent.com">Debadatta Mishra</a>
	 */
	public static SecretKey getDefaultSecretAgentKey()
			throws NoSuchAlgorithmException, InvalidKeyException,
			InvalidKeySpecException {
		byte[] rawkey = Common.SECRET_KEY.getBytes();
		DESedeKeySpec keyspec = new DESedeKeySpec(rawkey);
		SecretKeyFactory keyfactory = SecretKeyFactory.getInstance("DESede");
		SecretKey key = keyfactory.generateSecret(keyspec);
		return key;
	}

	/**
	 * This method is used to obtain an encrypted string by
	 * passing the normal or original string and the secret key.
	 * @param normalString of type String
	 * @param secretKey of type {@link SecretKey}
	 * @return an encrypted string
	 * @author <a href="mailTo:debadatta.m@idealinvent.com">Debadatta Mishra</a>
	 */
	public static String getEncryptedString(String normalString,
			SecretKey secretKey) {
		String encryptedString = null;
		try {
			cipher.init(Cipher.ENCRYPT_MODE, secretKey);
			byte[] testStr = cipher.doFinal(normalString.getBytes());
			encryptedString = new String(testStr);
		} catch (Exception e) {
			e.printStackTrace();
		}
		return encryptedString;
	}

	/**
	 * This method is used to obtain the encrypted string
	 * by passing the normal or original string. 
	 * @param normalString of type String
	 * @return an encrypted String .
	 * @author <a href="mailTo:debadatta.m@idealinvent.com">Debadatta Mishra</a>
	 */
	public static String getEncryptedString(String normalString) {
		String encryptedString = null;
		try {
			cipher.init(Cipher.ENCRYPT_MODE, getDefaultSecretAgentKey());
			byte[] testStr = cipher.doFinal(normalString.getBytes());
			encryptedString = new String(testStr);
		} catch (Exception e) {
			e.printStackTrace();
		}
		return encryptedString;
	}

	/**
	 * This method is used to obtain the decrypted String
	 * by passing the encrypted string.
	 * 
	 * @param encryptedString of type String
	 * @return a decrypted string
	 * @author <a href="mailTo:debadatta.m@idealinvent.com">Debadatta Mishra</a>
	 */
	public static String getDecryptedString(String encryptedString) {
		String decryptedString = null;
		try {
			cipher.init(Cipher.DECRYPT_MODE, getDefaultSecretAgentKey());
			byte[] nowOriginal = cipher.doFinal(encryptedString.getBytes());
			decryptedString = new String(nowOriginal);
		} catch (Exception e) {
			e.printStackTrace();
		}
		return decryptedString;
	}

	/**
	 * This method is used to obtain the decrypted or original String by
	 * passing the encrypted String and the object of secret key.
	 * 
	 * @param encryptedString of type String
	 * @param secretKey of type {@link SecretKey}
	 * @return a decrypted String
	 * @author <a href="mailTo:debadatta.m@idealinvent.com">Debadatta Mishra</a>
	 */
	public static String getDecryptedString(String encryptedString,
			SecretKey secretKey) {
		String decryptedString = null;
		try {
			cipher.init(Cipher.DECRYPT_MODE, secretKey);
			byte[] nowOriginal = cipher.doFinal(encryptedString.getBytes());
			decryptedString = new String(nowOriginal);
		} catch (Exception e) {
			e.printStackTrace();
		}
		return decryptedString;
	}

}
