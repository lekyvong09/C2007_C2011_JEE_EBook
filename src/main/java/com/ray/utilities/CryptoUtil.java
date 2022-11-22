package com.ray.utilities;

import java.security.MessageDigest;
import java.security.NoSuchAlgorithmException;

public class CryptoUtil {
	final protected static char[] hexArray = "0123456789ABCDEF".toCharArray();
	
	public static String hashPassword(String inputString, String SALT) {
		
		try {
			MessageDigest md = MessageDigest.getInstance("SHA-256");
			md.update(SALT.getBytes());
			md.update(inputString.getBytes());
			
			byte[] outString = md.digest();
			return bytesToHex(outString);
			
		} catch (NoSuchAlgorithmException e) {
			e.printStackTrace();
		}

		return "";
	}
	
	
	private static String bytesToHex(byte[] bytes) {
		char[] hexChars = new char[bytes.length * 2];
		int v;
		
		for (int j = 0; j < bytes.length; j++) {
			v = bytes[j] & 0xFF;
			hexChars[j * 2] = hexArray[v >>> 4];
			hexChars[j * 2 + 1] = hexArray[v & 0x0F];
		}
		
		return new String(hexChars);
	}
}
