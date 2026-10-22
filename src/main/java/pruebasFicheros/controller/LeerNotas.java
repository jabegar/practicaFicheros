package pruebasFicheros.controller;

import java.io.File;
import java.io.FileNotFoundException;
import java.io.FileReader;
import java.io.FileWriter;
import java.io.IOException;
import java.io.PrintWriter;
import java.nio.charset.StandardCharsets;
import java.util.ArrayList;
import java.util.List;
import java.util.Locale;
import java.util.Scanner;

import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;

import pruebasFicheros.models.Persona;

public class LeerNotas {
	private static Logger logger = LogManager.getLogger(LeerNotas.class);

	public static void main(String[] args) {
		LeerNotas ln = new LeerNotas();
		String rutaLeer = "src\\main\\resources\\ficheroEscribir.txt";
		List<Persona> personas = ln.leeFicheros(rutaLeer, true);

		for (Persona persona : personas) {
			logger.debug(persona);
		}
		
		String rutaEscribir = "src\\main\\resources\\ficheroEscribir.txt";
		ln.escribePersonas(personas, rutaEscribir, 7);
	}
	
	public List<Persona> leeFicheros(String ruta, boolean tieneCabecera) {
		File f = new File(ruta);
		List<Persona> personas = new ArrayList<Persona>();
		
		try {
			FileReader fr = new FileReader(f);
			Scanner sc = new Scanner(fr);
			sc.useLocale(Locale.ENGLISH);
			
			if(tieneCabecera == true) {
				sc.nextLine();
			}
			while(sc.hasNext()) {
				String nombre = sc.next();
				List<Double> notas = new ArrayList<Double>();
				while (sc.hasNextDouble()) {
					notas.add(sc.nextDouble());
				}
				personas.add(new Persona(nombre, notas));
			}
		

		} catch (FileNotFoundException e) {
			logger.error(e.getMessage());
		}
		return personas;
	}
	
	public void escribePersonas(List<Persona> personas, String rutaFichero, int notasMaximas) {
		PrintWriter out = null;
		try {
			FileWriter ficheroSalida;
			ficheroSalida = new FileWriter(rutaFichero, StandardCharsets.UTF_8);			
			out = new PrintWriter(ficheroSalida);

			out.printf(Locale.ENGLISH, "%-10s", "Nombre");
			for(int i = 1; i <= notasMaximas; i++) {
				out.printf(Locale.ENGLISH, "%-6s", "Nota" + i);
			}
			out.printf("%n");
			for(Persona p: personas) {
 				out.printf(Locale.ENGLISH, "%-10s", p.getNombre());
				for (double nota : p.getNotas()) {
					out.printf(Locale.ENGLISH, "%6.2f", nota);
				}
				out.printf("%n");
			}	
		}
		catch (IOException e) {
			logger.debug("IOException");
			}
		finally		{
			if (out!=null)
				out.close();
		}
	}

}
