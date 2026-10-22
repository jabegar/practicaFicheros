package pruebasFicheros.repositories;

import java.io.File;
import java.io.FileNotFoundException;
import java.io.FileReader;
import java.io.FileWriter;
import java.io.IOException;
import java.io.PrintWriter;
import java.util.ArrayList;
import java.util.List;
import java.util.Locale;
import java.util.Scanner;

import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;

import pruebasFicheros.models.Persona;

public class RepositorioPersonaTXT implements IRepositorioPersona {
	private File fichero;
	private List<Persona> personas;
	static Logger logger = LogManager.getLogger(RepositorioPersonaTXT.class);

	
	public RepositorioPersonaTXT(String ruta) throws IllegalArgumentException{
		if (ruta == null || ruta.isBlank()) {
			throw new IllegalArgumentException("La ruta no puede estar vacia");
		}
		this.fichero = new File(ruta);
		this.personas = new ArrayList<Persona>();
	}
	
	public int buscarPosicion(List<Persona> lista, String nombre) {
		for (int i = 0; i < lista.size(); i++) {
			Persona p = lista.get(i);
			if (p.getNombre().equals(nombre)) {
				return i;
			}
		}
		return -1;
	}
	
	private List<Persona> leerFichero() {
		List<Persona> personas = new ArrayList<Persona>();
		
		try {
			FileReader fr = new FileReader(this.fichero);
			Scanner sc = new Scanner(fr);
			sc.useLocale(Locale.ENGLISH);
			
			while(sc.hasNext()) {
				String nombre = sc.next();
				List<Double> notas = new ArrayList<Double>();
				while (sc.hasNextDouble()) {
					notas.add(sc.nextDouble());
				}
				personas.add(new Persona(nombre, notas));
			}
			
			return personas;

		} catch (FileNotFoundException e) {
			logger.debug(e.getMessage());
		}
		return personas;
	}

	@Override
	public List<Persona> findAll() throws RepositorioException {
		if (this.personas == null || this.personas.size() == 0) {
			this.personas = this.leerFichero();
		}
		return this.personas;
	}

	@Override
	public Persona findById(String nombre) throws RepositorioException {
		List<Persona> personas = this.findAll();
		Persona persona = null;
		for (Persona p : personas) {
			if (p.getNombre().equals(nombre)) {
				persona = p;
			}
		}
		return persona;
	}

	@Override
	public boolean existsById(String nombre) throws RepositorioException {
		Persona p = this.findById(nombre);
		
		return p != null;
	}

	@Override
	public int count() throws RepositorioException {
		return this.findAll().size();
	}

	@Override
	public void save(Persona persona) throws RepositorioException, IOException {
		if (this.personas.size() == 0) {
			this.personas.add(persona);
		}
		else {
			if (this.existsById(persona.getNombre())) {
				Persona p = this.findById(persona.getNombre());
				p.setNombre(persona.getNombre());
				p.setNotas(persona.getNotas());
			}
			else {
				this.personas.add(persona);
			}
		}
		
		this.escribeFichero();
	}
	
	public void escribeFichero() throws IOException {
		FileWriter writer = new FileWriter(this.fichero);
		PrintWriter pw = new PrintWriter(writer);
		for (Persona p : this.personas) {
			pw.printf(Locale.ENGLISH, "%-10s", p.getNombre());
			for (double nota : p.getNotas()) {
				pw.printf(Locale.ENGLISH, "%6.2f", nota);
			}
			pw.printf(Locale.ENGLISH, "%n");
		}
		writer.close();
	}

	@Override
	public boolean deleteById(String nombre) throws RepositorioException, IOException {
		if (this.existsById(nombre)) {
			Persona p = this.findById(nombre);
			this.personas.remove(p);
			
			this.escribeFichero();
		}
		
		return false;
	}
	
	

}
