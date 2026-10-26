package pruebasFicheros.controller;

import java.io.FileNotFoundException;
import java.io.FileReader;

import com.google.gson.Gson;
import com.google.gson.JsonIOException;
import com.google.gson.JsonSyntaxException;

import pruebasFicheros.models.Empleado;

public class EmpleadoController {

	public static void main(String[] args) {
		Gson gson = new Gson();
		try {
			Empleado emp = gson.fromJson(new FileReader("src/main/resources/empleado.json"), Empleado.class);
			System.out.println(emp);
		} catch (JsonSyntaxException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		} catch (JsonIOException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		} catch (FileNotFoundException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
	}

}
