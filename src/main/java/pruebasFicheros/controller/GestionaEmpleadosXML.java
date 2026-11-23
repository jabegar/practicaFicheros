package pruebasFicheros.controller;

import java.util.ArrayList;
import java.util.List;

import org.w3c.dom.Document;

import pruebasFicheros.models.Empleado;
import pruebasFicheros.models.Puesto;
import pruebasFicheros.services.ServicioEmpleado;

public class GestionaEmpleadosXML {

	public static void main(String[] args) {
		ServicioEmpleado svc = new ServicioEmpleado("empleados.xml");

		List<Empleado> empleados = new ArrayList<Empleado>();
		Empleado empleado1 = new Empleado("E001", "Juan García López", 41, "Google", new Puesto("P001", "Desarrollador", "Software", 25000));
		empleados.add(empleado1);

		Empleado empleado2 = new Empleado("María Sánchez Pérez", "Microsoft", new Puesto("P002", "Directora", "General", 45000));
		empleados.add(empleado2);
		
		Empleado empleado3 = new Empleado("E002", "Carlos Rodríguez", 28, "Amazon", new Puesto("Programador", 30000));
		empleados.add(empleado3);
		
		Empleado empleado4 = new Empleado("E003", "Lucía Fernández", 35, "Apple", new Puesto("Gerente", 40000));
		empleados.add(empleado4);
		
		Empleado empleado5 = new Empleado("E004", "Pedro Martínez", 42, "IBM", new Puesto("Administrador", 32000));
		empleados.add(empleado5);
		
		svc.escribirEmpleados(empleados);
		
		List<Empleado> empLectura = svc.leerEmpleados();
		System.out.println(empLectura);

	}

}
