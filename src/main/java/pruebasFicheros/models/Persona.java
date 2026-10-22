package pruebasFicheros.models;

import java.util.List;

public class Persona {
	private String nombre;
	private Double NOTA_MIN;
	private Double NOTA_MAX;
	private List<Double> notas;
	public Persona(String nombre, List<Double> notas) {
		super();
		this.nombre = nombre;
		this.notas = notas;
	}
	public String getNombre() {
		return nombre;
	}
	public void setNombre(String nombre) {
		this.nombre = nombre;
	}
	public List<Double> getNotas() {
		return notas;
	}
	public void setNotas(List<Double> notas) {
		this.notas = notas;
	}
	@Override
	public String toString() {
		return "\nAlumno: " + nombre + ", \nNotas: " + notas;
	}
	
	
}