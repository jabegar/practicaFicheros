package pruebasFicheros.services;

import java.util.List;

import pruebasFicheros.models.Pelicula;
import pruebasFicheros.repositories.IPeliculaXMLRepository;
import pruebasFicheros.repositories.PeliculaXMLRepository;

public class ServicioPelicula implements IServicioPelicula {
	IPeliculaXMLRepository repo;
	List<Pelicula> peliculas;
	
	public ServicioPelicula(String nombreFichero) {
		this.repo = new PeliculaXMLRepository(nombreFichero);
		this.peliculas = this.findAll();
	}
	@Override
	public List<Pelicula> findAll() {
		return this.repo.findAll();
	}

}
