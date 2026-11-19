package pruebasFicheros.controller;

import java.util.List;

import org.w3c.dom.Document;

import pruebasFicheros.models.Pelicula;
import pruebasFicheros.models.UtilesDOMPelicula;
import pruebasFicheros.repositories.PeliculaXMLRepository;

public class GestionaPeliculas {

	public static void main(String[] args) {
		PeliculaXMLRepository repo = new PeliculaXMLRepository("peliculas.xml");
		System.out.println(repo.findAll());
	}
}
