package PasswordEncryption;

import java.security.MessageDigest;
import java.security.NoSuchAlgorithmException;
import java.util.Iterator;

public interface Encryption {
	public static String encryptpass(String pass)  {
		
		MessageDigest messageDigest;
		try {
			String encryptedpass = null;
			messageDigest = MessageDigest.getInstance("MD5");
			messageDigest.update(pass.getBytes());
	        byte[] encrypt = messageDigest.digest();
	        StringBuffer sb = new StringBuffer();
	        for(byte b:encrypt) {
	        	sb.append(b);
	        }
	        encryptedpass = sb.toString();
	        return encryptedpass;
		} catch (NoSuchAlgorithmException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
        return " " ;
		
	}

}
