package pruebasFicheros.services;

import java.io.IOException;
import java.util.ArrayList;
import java.util.List;

import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;

import pruebasFicheros.models.Persona;
import pruebasFicheros.repositories.IRepositorioPersona;
import pruebasFicheros.repositories.RepositorioException;
import pruebasFicheros.repositories.RepositorioPersonaTXT;

public class ServicioPersonas implements IServicioPersonas {
	static Logger logger = LogManager.getLogger(ServicioPersonas.class);
	private IRepositorioPersona rp;
	private List<Persona> personas;
	
	public ServicioPersonas(String ruta) {
		this.rp = new RepositorioPersonaTXT(ruta);
		this.listar();		
	}

	@Override
	public List<Persona> listar() {
		try {
			if (this.personas == null || this.personas.size() == 0) {
				this.personas = rp.findAll();
			}
		} catch (RepositorioException e) {
			this.errorPersistente(e);
		}
		return this.personas;
	}

	@Override
	public Persona buscar(String nombre) {
		Persona p = null;
		try {
			p = this.rp.findById(nombre);
		} catch (RepositorioException e) {
			this.errorPersistente(e);;
		}
		return p;
	}

	@Override
	public boolean alta(String nombre, List<Double> notas) {
		boolean hecho = false;
		Persona p = new Persona(nombre, notas);
		try {
			if (this.rp.existsById(nombre)) {
				this.datoNoValido("Ya existe: " + nombre);
			}
			else {			
				this.rp.save(p);
				hecho = true;
			}
		} catch (RepositorioException e) {
			this.errorPersistente(e);
		} catch (IOException e) {
			this.datoNoValido(e.getMessage());
		}
		return hecho;
	}

	@Override
	public boolean modificarNotas(String nombre, List<Double> notas) {
		boolean hecho = false;
		try {
			if (this.rp.existsById(nombre) == false) {
				this.datoNoValido("No existe: " + nombre);
			}
			else {			
				this.rp.save(new Persona(nombre, notas));
				hecho = true;
			}
		} catch (RepositorioException e) {
			this.errorPersistente(e);
		} catch (IOException e) {
			this.datoNoValido(e.getMessage());
		}
		return hecho;
	}

	@Override
	public boolean baja(String nombre) {
		boolean hecho = false;
		
		try { 
			hecho = this.rp.deleteById(nombre);
			if (hecho == false) {
				this.datoNoValido("No existe: " + nombre);
			}
		} catch (RepositorioException e) {
			this.errorPersistente(e);
		} catch (IOException e) {
			this.errorPersistente(e);
		}
		return hecho;
	}

	@Override
	public double media(Persona p) {
		List<Double> notas = p.getNotas();
		double total = 0;
		double media = 0;
		if(notas.size() != 0) {
			for (Double nota : notas) {
				total += nota;
			}
			
			media = total / notas.size();
		}
		return media;
	}
	
	private void datoNoValido(String mensaje) {
		logger.error("Dato no valido: " + mensaje);
	}
	
	private void errorPersistente(Exception e) {
		logger.error("Error de persistencia: " + e.getMessage());
	}

}
