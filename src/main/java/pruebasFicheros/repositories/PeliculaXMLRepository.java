package pruebasFicheros.repositories;

import java.io.File;
import java.util.ArrayList;
import java.util.List;

import pruebasFicheros.models.Pelicula;
import pruebasFicheros.models.UtilesDomXML;

public class PeliculaXMLRepository {
	private static final String RUTA_RESOURCES = "src/main/resources/";
	List<Pelicula> peliculas;
	File bdd;
	UtilesDomXML udx;
	
	public PeliculaXMLRepository(String nombreFichero) {
		this.bdd = new File(RUTA_RESOURCES, nombreFichero);
		this.peliculas = new ArrayList<Pelicula>();
		this.udx = new UtilesDomXML();
	}
	
	public List<Pelicula> findAll() {
		
	}
}
