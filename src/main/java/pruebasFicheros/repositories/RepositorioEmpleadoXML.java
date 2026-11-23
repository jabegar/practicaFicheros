package pruebasFicheros.repositories;

import java.util.ArrayList;
import java.util.List;

import pruebasFicheros.models.Empleado;
import pruebasFicheros.models.EmpleadoXMLException;
import pruebasFicheros.models.UtilesDOMXMLEmpleado;

public class RepositorioEmpleadoXML {
	List<Empleado> empleados;
	UtilesDOMXMLEmpleado utils;
	
	public RepositorioEmpleadoXML(String nombreFichero) {
		this.empleados = new ArrayList<Empleado>();
		this.utils = new UtilesDOMXMLEmpleado(nombreFichero);
	}
	
	public List<Empleado> findAll() throws EmpleadoXMLException {
		if (this.empleados == null || this.empleados.isEmpty()) {
			this.empleados = this.utils.leerEmpleadosDesdeXML(this.utils.getDocumentFromXML().getDocumentElement());
		}
		return this.empleados;
	}
	
	public void escribirFichero(List<Empleado> empleados) {
		this.utils.escribeEmpleadoEnXML(empleados);
	}
}
