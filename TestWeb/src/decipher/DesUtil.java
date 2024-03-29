﻿package decipher;

import java.security.Key;

import javax.crypto.Cipher;
import javax.crypto.SecretKeyFactory;
import javax.crypto.spec.DESKeySpec;

public class DesUtil {
	
	private static final String SECRET_KEY_TYPE = "DES";
	private static final String ECB_MOB = "DES/ECB/PKCS5Padding";
	private static final String CHAESET_NAME = "UTF-8";
	
	private static Key getKey(String password) throws Exception{
		byte[] DESkey = password.getBytes(CHAESET_NAME);
		DESKeySpec keySpec = new DESKeySpec(DESkey);
		SecretKeyFactory keyFactory = SecretKeyFactory.getInstance(SECRET_KEY_TYPE);
		return keyFactory.generateSecret(keySpec);
	}
	
	public static String encode(String data, String password) throws Exception {
		Cipher enCipher = Cipher.getInstance(ECB_MOB);
		Key key = getKey(password);
		enCipher.init(Cipher.ENCRYPT_MODE, key);
		byte[] pasByte = enCipher.doFinal(data.getBytes(CHAESET_NAME));
		return Base64.encodeBase64String(pasByte);
	}
	
	public static String decode(String data, String password) throws Exception {
		Cipher deCipher = Cipher.getInstance(ECB_MOB);
		Key key = getKey(password);
		deCipher.init(Cipher.DECRYPT_MODE, key);
		byte[] pasByte = deCipher.doFinal(Base64.decodeBase64(data.getBytes(CHAESET_NAME)));
		return new String(pasByte, CHAESET_NAME);
	}
	
	public static void main(String[] args) throws Exception{
		String a =DesUtil.encode("123", "---tenc1234");
		System.out.println(DesUtil.encode("4TRy/WlZxMJRDLJRBDx2pQ", "4TRy/WlZxMJRDLJRBDx2pQ")+"========"+a);
	}
}