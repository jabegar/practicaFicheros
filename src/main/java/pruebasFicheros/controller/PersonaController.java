package pruebasFicheros.controller;

import java.io.IOException;
import java.util.ArrayList;
import java.util.Arrays;

import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;

import pruebasFicheros.models.Persona;
import pruebasFicheros.repositories.RepositorioException;
import pruebasFicheros.repositories.RepositorioPersonaTXT;

public class PersonaController {
	static Logger logger = LogManager.getLogger(PersonaController.class);
	
	public static void main(String[] args) {
		RepositorioPersonaTXT repo = new RepositorioPersonaTXT("src/main/resources/alumnos.txt");
		try {
			repo.save(new Persona("Juana", Arrays.asList(2.5, 10.0, 6.1)));
			repo.save(new Persona("Pepe", Arrays.asList(7.0, 7.0, 8.1)));
			repo.save(new Persona("Carlitos", Arrays.asList(6.5, 7.0, 4.1, 6.7)));
			logger.debug(repo.findAll());
			
			logger.debug("\n-----------------------------------------------");
			
			repo.deleteById("Pepe");
			repo.save(new Persona("Carlitos", Arrays.asList(10., 10.0, 10.0)));
			logger.debug(repo.findAll());
			
			logger.debug("\n-----------------------------------------------");
			
			logger.debug(repo.existsById("Carlitos"));
		} catch (RepositorioException e) {
			logger.debug(e.getMessage());
		} catch (IOException e) {
			logger.debug(e.getMessage());
		}

	}

}
