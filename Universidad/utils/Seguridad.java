package utils;

import java.security.MessageDigest;
import java.security.NoSuchAlgorithmException;

public class Seguridad {
	
	public static String encriptarConMD5(Object parametro) {
		String resultado = null;
		try {
			String cadena = String.valueOf(parametro);
			MessageDigest md = MessageDigest.getInstance("MD5");
			md.update(cadena.getBytes());
			byte[] bytes = md.digest();
			StringBuilder aux = new StringBuilder();
			for(int i=0; i< bytes.length ;i++) {
				aux.append(Integer.toString((bytes[i] & 0xff) + 0x100, 16).substring(1));
			}
			resultado = aux.toString();
		} catch (NoSuchAlgorithmException e) {
			e.printStackTrace();
		} catch (Exception e) {
			e.printStackTrace();
		}
		return resultado;
	}
}