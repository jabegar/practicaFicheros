package pruebasFicheros.controller;

import java.io.FileNotFoundException;
import java.io.FileReader;
import java.io.FileWriter;
import java.io.IOException;

import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;

import com.google.gson.Gson;
import com.google.gson.GsonBuilder;
import com.google.gson.JsonIOException;
import com.google.gson.JsonSyntaxException;

import pruebasFicheros.models.Empleado;

public class EmpleadoController {
	private static final Logger logger = LogManager.getLogger(EmpleadoController.class);

	public static void main(String[] args) {
		Gson gson = new Gson();
		EmpleadoController ec = new EmpleadoController();
		try {
			Empleado[] empleados = gson.fromJson(new FileReader("src/main/resources/empleado.json"), Empleado[].class);
			
			for (Empleado emp : empleados) {
				logger.debug(emp);
			}
			
			ec.escribeEmpleado(empleados, "src/main/resources/resultado.json");			
		
		} catch (JsonSyntaxException e) {
			logger.error(e.getMessage());
		} catch (JsonIOException e) {
			logger.error(e.getMessage());
		} catch (FileNotFoundException e) {
			logger.error(e.getMessage());
		}
	}
	
	public void escribeEmpleado(Empleado[] empleados, String ruta)	{
		FileWriter fichero = null;
		try {
			fichero = new FileWriter(ruta, true);
			Gson gson = new GsonBuilder().setPrettyPrinting().create();
			String json = gson.toJson(empleados);
			fichero.write(json);
		} catch (IOException e) {
			e.printStackTrace();
		} finally {
			if (fichero != null) {
				try {
					fichero.close();
				} catch (IOException e) {
					System.out.println("Error al escribir empleado");
				}
			}
		}
	 }



}
