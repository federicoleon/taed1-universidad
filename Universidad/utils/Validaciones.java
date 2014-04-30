package utils;

import java.util.regex.Matcher;
import java.util.regex.Pattern;

import excepciones.ExcepcionStringANumero;

public class Validaciones {
	
	private static final String PATRON_EMAIL = "^[A-Za-z0-9-]+(\\.[A-Za-z0-9-]+)*@[A-Za-z0-9-]+(\\.[A-Za-z0-9]+)*(\\.[A-Za-z]{2,})$";
	
	private enum ExtensionesImagenValidas {
		JPG("jpg"), 
	    JPEG("jpeg"), 
	    GIF("gif"), 
	    PNG("png");
	    
	    private String extension;
	    
	    private ExtensionesImagenValidas(String extension) {
	    	this.extension = extension;
	    }
	    
	    public String getExtension() {
	    	return this.extension;
	    }
	    
	    public static boolean esExtensionValida(String ext) {
	    	return ( ext.equalsIgnoreCase(JPG.getExtension()) ||
    			ext.equalsIgnoreCase(JPEG.getExtension()) ||
    			ext.equalsIgnoreCase(GIF.getExtension()) ||
    			ext.equalsIgnoreCase(PNG.getExtension()));
	    }
	}
	
	public static boolean tieneFormatoEmailValido(String email) {
		Pattern patron = Pattern.compile(PATRON_EMAIL);
		Matcher matcher = patron.matcher(email);
        return matcher.matches();
	}
	
	public static boolean esFormatoImagenValido(String nombreArchivo) {
		String[] aux = nombreArchivo.split("\\.");
		try {
			String extension = aux[(aux.length - 1)];
			return ExtensionesImagenValidas.esExtensionValida(extension);
		} catch(Exception e) {
			return false;
		}
	}
	
	public static Integer convertirANumero(String text) throws ExcepcionStringANumero {
		try {
			return Integer.parseInt(text);
		} catch(NumberFormatException e) {
			throw new ExcepcionStringANumero();
		}
	}
}