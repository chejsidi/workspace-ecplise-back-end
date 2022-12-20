package beans;

import java.io.File;
import java.io.IOException;
import java.nio.file.Files;
import java.nio.file.Path;

public class Imagen {
	private String ruta;
	private String nombre;
	private String tamano;
	public Imagen(String ruta, String nombre) {
		this.nombre = nombre;
		this.ruta = ruta;
	} 
	
	public String tamanioDesglosado (String ruta) throws IOException {
		long bytes, kilobytes, megabytes;
		String result = "";
		try {
			File f = new File(ruta);
			bytes = f.length();
			megabytes = bytes / 1048576;
			kilobytes = (bytes % 1048576) / 1024;
			bytes = (bytes % 1048576) % 1024;  
			result = megabytes + " Mb " + kilobytes + " Kb " + bytes + " bytes";
			return result;
		}
		finally{
			
		}
		
	}

	public String getRuta() {
		return ruta;
	}

	public void setRuta(String ruta) {
		this.ruta = ruta;
	}

	public String getNombre() {
		return nombre;
	}

	public void setNombre(String nombre) {
		this.nombre = nombre;
	}

	public String getTamano() {
		return tamano;
	}

	public void setTamano(String tamano) {
		this.tamano = tamano;
	}
	
	
}
