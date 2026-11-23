package pruebasFicheros.controller;

import java.util.List;

import org.w3c.dom.Document;

import pruebasFicheros.models.Pelicula;
import pruebasFicheros.models.UtilesDOMPelicula;
import pruebasFicheros.services.IServicioPelicula;
import pruebasFicheros.services.ServicioPelicula;

public class GestionaPeliculas {

	public static void main(String[] args) {
		IServicioPelicula service = new ServicioPelicula("peliculas.xml");
		System.out.println(service.findAll());
	}
}
