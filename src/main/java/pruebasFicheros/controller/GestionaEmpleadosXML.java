package pruebasFicheros.controller;

import java.util.ArrayList;
import java.util.List;

import pruebasFicheros.models.Empleado;
import pruebasFicheros.models.Puesto;
import pruebasFicheros.models.UtilesDOMXMLEmpleado;

public class GestionaEmpleadosXML {

	public static void main(String[] args) {
		UtilesDOMXMLEmpleado utils = new UtilesDOMXMLEmpleado("empleados.xml");

		List<Empleado> empleados = new ArrayList<Empleado>();
		Empleado empleado1 = new Empleado("Juan García López", "Google", new Puesto("Desarrollador", 25000));
		empleados.add(empleado1);

		Empleado empleado2 = new Empleado("María Sánchez Pérez", "Microsoft", new Puesto("Directora", 45000));
		empleados.add(empleado2);
		
		Empleado empleado3 = new Empleado("EMP001", "Carlos Rodríguez", 28, "Amazon", new Puesto("Programador", 30000));
		empleados.add(empleado3);
		
		Empleado empleado4 = new Empleado("EMP002", "Lucía Fernández", 35, "Apple", new Puesto("Gerente", 40000));
		empleados.add(empleado4);
		
		Empleado empleado5 = new Empleado("EMP003", "Pedro Martínez", 42, "IBM", new Puesto("Administrador", 32000));
		empleados.add(empleado5);
		
		utils.escribeEmpleadoEnXML(empleados);

	}

}
