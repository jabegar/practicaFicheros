package pruebasFicheros.controller;

import java.io.IOException;
import java.util.ArrayList;
import java.util.Arrays;

import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;

import pruebasFicheros.models.Persona;
import pruebasFicheros.repositories.RepositorioException;
import pruebasFicheros.repositories.RepositorioPersonaTXT;
import pruebasFicheros.services.IServicioPersonas;
import pruebasFicheros.services.ServicioPersonas;

public class PersonaController {
	static Logger logger = LogManager.getLogger(PersonaController.class);
	
	public static void main(String[] args) {
		final String RUTA_DATOS = "src/main/resources/datos.txt";
		IServicioPersonas sp = new ServicioPersonas(RUTA_DATOS);
		sp.alta("Juana", Arrays.asList(2.5, 10.0, 6.1));
		sp.alta("Pepe", Arrays.asList(7.0, 7.0, 8.1));
		sp.alta("Carlitos", Arrays.asList(6.5, 7.0, 4.1, 6.7));
		logger.debug(sp.listar().toString());
		
		logger.debug("\n-----------------------------------------------");
	
		sp.baja("Pepe");
		sp.alta("Carlitos", Arrays.asList(10., 10.0, 10.0));
		sp.modificarNotas("Carlitos", Arrays.asList(10., 10.0, 10.0));
		logger.debug(sp.listar().toString());
			
		logger.debug("\n-----------------------------------------------");
			
		logger.debug(sp.buscar("Carlitos"));
		logger.debug(sp.media(sp.buscar("Carlitos")));
	}

}
