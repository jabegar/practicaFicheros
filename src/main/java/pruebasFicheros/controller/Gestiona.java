package pruebasFicheros.controller;

import java.io.File;
import java.io.IOException;

import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;

public class Gestiona {

	public static void main(String[] args) {
		Logger logger = LogManager.getLogger(Gestiona.class);
		
		String osName = System.getProperty("os.name");
		String rutaDirectorio;
		String rutaRelativa = ".";
		
		if (osName.contains("Windows")) {
			rutaDirectorio = "C:\\Users\\alumno";
		}
		else {
			rutaDirectorio = "/home/jesus";
		}
		
		File directorio = new File(rutaDirectorio);
		
		if (directorio.exists() && directorio.isDirectory()) {
			File fichero = new File(directorio, "fichero.txt");
			try {
				boolean creado = fichero.createNewFile();
				logger.debug("Archivo creado en " + fichero.getPath());
			} catch (IOException e) {
				logger.error("Error al crear fichero:" + e.getMessage());
			}
		}
		else {
			logger.debug("La ruta no existe");
		}

	}

}
