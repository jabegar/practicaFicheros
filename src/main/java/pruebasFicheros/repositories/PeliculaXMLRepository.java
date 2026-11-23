package pruebasFicheros.repositories;

import java.io.File;
import java.util.ArrayList;
import java.util.List;

import org.w3c.dom.Document;

import pruebasFicheros.models.Pelicula;
import pruebasFicheros.models.UtilesDOMPelicula;

public class PeliculaXMLRepository implements IPeliculaXMLRepository {
	private static final String RUTA_RESOURCES = "src/main/resources/";
	List<Pelicula> peliculas;
	File bdd;
	UtilesDOMPelicula udx;
	
	public PeliculaXMLRepository(String nombreFichero) {
		this.bdd = new File(RUTA_RESOURCES, nombreFichero);
		this.peliculas = new ArrayList<Pelicula>();
		this.udx = new UtilesDOMPelicula();
	}
	
	@Override
	public List<Pelicula> findAll() {
		this.cargaSiHaceFalta();
		
		return this.peliculas;
	}
	
	private void cargaSiHaceFalta() {
		if (this.peliculas == null || this.peliculas.isEmpty()) {
			Document doc = this.udx.getDocumentFromXML(bdd);
			this.peliculas = this.udx.leerPeliculas(doc.getDocumentElement());
		}
	}
}
