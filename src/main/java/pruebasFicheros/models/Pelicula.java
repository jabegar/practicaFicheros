package pruebasFicheros.models;

import java.util.ArrayList;
import java.util.List;

public class Pelicula {
	private String titulo;
	private int duracion;
	private String genero;
	private String sinopsis;
	private List<String> actores;
	private String fecha;
	private String director;
	
	public Pelicula(String titulo) {
		this.titulo = titulo;
		this.actores = new ArrayList<String>();
	}

	public String getTitulo() {
		return titulo;
	}

	public void setTitulo(String titulo) {
		this.titulo = titulo;
	}

	public int getDuracion() {
		return duracion;
	}

	public void setDuracion(int duracion) {
		this.duracion = duracion;
	}

	public String getGenero() {
		return genero;
	}

	public void setGenero(String genero) {
		this.genero = genero;
	}

	public String getSinopsis() {
		return sinopsis;
	}

	public void setSinopsis(String sinopsis) {
		this.sinopsis = sinopsis;
	}

	public List<String> getActores() {
		return actores;
	}

	public void addActor(String actor) {
		this.actores.add(actor);
	}

	public String getFecha() {
		return fecha;
	}

	public void setFecha(String fecha) {
		this.fecha = fecha;
	}

	public String getDirector() {
		return director;
	}

	public void setDirector(String director) {
		this.director = director;
	}

	@Override
	public String toString() {
		return "Pelicula [titulo=" + titulo + ", genero=" + genero + ", director=" + director + "]";
	}
	
	
}
