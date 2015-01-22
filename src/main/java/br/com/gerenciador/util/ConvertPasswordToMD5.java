package br.com.gerenciador.util;

import java.math.BigInteger;
import java.security.MessageDigest;

public class ConvertPasswordToMD5 {

	public static String convertToMD5(String password) {
		try {
			MessageDigest md = MessageDigest.getInstance("MD5");

			BigInteger hash = new BigInteger(1, md.digest(password.getBytes()));

			return String.format("%32x", hash);
		} catch (Exception e) {
			e.printStackTrace();
			return null;
		}
	}

}