package pruebasFicheros.services;

import java.util.List;

import pruebasFicheros.models.Persona;

public interface IServicioPersonas {
	public List<Persona> listar();
	public Persona buscar(String nombre);
	public boolean alta(String nombre, List<Double> notas);
	public boolean modificarNotas(String nombre, List<Double> notas);
	public boolean baja(String nombre);
	public double media(Persona p);
}
