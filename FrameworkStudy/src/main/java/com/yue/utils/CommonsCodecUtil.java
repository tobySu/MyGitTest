/**
 * @Copyright:Copyright (c) 1991 - 2016
 * @Company: Macroview
 */
package com.yue.utils;

import java.lang.reflect.InvocationTargetException;
import java.security.GeneralSecurityException;

import javax.crypto.Cipher;
import javax.crypto.SecretKey;
import javax.crypto.SecretKeyFactory;
import javax.crypto.spec.DESKeySpec;

import org.apache.commons.codec.binary.Base64;

/**
 *  
 * @author Toby
 * @since: v1.0
 */
public class CommonsCodecUtil {
	
	private static final String DES = "DES";
	
	private final static String pwd = "MacroviewMIDAS@AuthenServer8710";

	/**
	 * 使用DES解密Base64编码的加密字符串, 返回原始字符串.
	 * 
	 * @param input Base64编码的加密字符串
	 * @param keyBytes 符合DES要求的密钥
	 */
	public static String desDecryptFromBase64(String input, byte[] keyBytes) {
		byte[] decryptResult = des(Base64.decodeBase64(input), keyBytes, Cipher.DECRYPT_MODE);
		return new String(decryptResult);
	}
	
	/**
	 * 使用DES加密原始字符串, 返回Base64编码的结果.
	 * 
	 * @param input 原始输入字符串
	 * @param keyBytes 符合DES要求的密钥
	 */
	public static String desEncryptToBase64(String input, byte[] keyBytes) {
		byte[] encryptResult = des(input.getBytes(), keyBytes, Cipher.ENCRYPT_MODE);
		return Base64.encodeBase64String(encryptResult);
	}
	
	/**
	 * 使用DES加密或解密无编码的原始字节数组, 返回无编码的字节数组结果.
	 * 
	 * @param inputBytes 原始字节数组
	 * @param keyBytes 符合DES要求的密钥
	 * @param mode Cipher.ENCRYPT_MODE 或 Cipher.DECRYPT_MODE
	 */
	private static byte[] des(byte[] inputBytes, byte[] keyBytes, int mode) {
		try {
			DESKeySpec desKeySpec = new DESKeySpec(keyBytes);
			SecretKeyFactory keyFactory = SecretKeyFactory.getInstance(DES);
			SecretKey secretKey = keyFactory.generateSecret(desKeySpec);

			Cipher cipher = Cipher.getInstance(DES);
			cipher.init(mode, secretKey);
			return cipher.doFinal(inputBytes);
		} catch (GeneralSecurityException e) {
			throw convertReflectionExceptionToUnchecked(e);
		}
	}
	
	/**
	 * 将反射时的checked exception转换为unchecked exception.
	 */
	private static RuntimeException convertReflectionExceptionToUnchecked(Exception e) {
		if (e instanceof IllegalAccessException || e instanceof IllegalArgumentException
				|| e instanceof NoSuchMethodException) {
			return new IllegalArgumentException("Reflection Exception.", e);
		} else if (e instanceof InvocationTargetException) {
			return new RuntimeException("Reflection Exception.", ((InvocationTargetException) e).getTargetException());
		} else if (e instanceof RuntimeException) {
			return (RuntimeException) e;
		}
		return new RuntimeException("Unexpected Checked Exception.", e);
	}
	
	public static void main(String[] args) {
		//test();
		test2();
	}
	
	private static void test(){
		String str = "tobytest";
		System.out.println("原始字符串："+ str);
		String desen = desEncryptToBase64(str,pwd.getBytes());
		System.out.println("加密后字符串："+ desen);
		System.out.println("解密后字符串："+ desDecryptFromBase64(desen, pwd.getBytes()));
		
	}
	private static void test2(){
		String str = "tobytest";
		byte[] decryptResult = des(str.getBytes(), pwd.getBytes(), Cipher.ENCRYPT_MODE);
		String str2 = new String(decryptResult);
		System.out.println(str2);
		byte[] encryptResult = des(str2.getBytes(), pwd.getBytes(), Cipher.DECRYPT_MODE);
		System.out.println(new String(encryptResult));
		
	}
}
