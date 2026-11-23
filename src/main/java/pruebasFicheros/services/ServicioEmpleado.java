package pruebasFicheros.services;

import java.util.ArrayList;
import java.util.List;

import pruebasFicheros.models.Empleado;
import pruebasFicheros.models.EmpleadoXMLException;
import pruebasFicheros.repositories.RepositorioEmpleadoXML;

public class ServicioEmpleado {
	private RepositorioEmpleadoXML repo;
	private List<Empleado> empleados;
	
	public ServicioEmpleado(String nombreFichero) {
		this.repo = new RepositorioEmpleadoXML(nombreFichero);
		this.empleados = new ArrayList<Empleado>();
	}
	
	public List<Empleado> leerEmpleados() {
		List<Empleado> emp = null;
		try {
			emp = this.repo.findAll();
		} catch (EmpleadoXMLException e) {
			System.out.println(e.getMessage());
		} finally {
			return emp;
		}
	}
	
	public void escribirEmpleados(List<Empleado> empleados) {
		this.repo.escribirFichero(empleados);
	}
}
