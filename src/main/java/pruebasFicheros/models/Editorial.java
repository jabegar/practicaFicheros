package pruebasFicheros.models;

public class Editorial {
	private String nombre;
	private String cif;
	
	public Editorial(String nombre, String cif) {
		this.nombre = nombre;
		this.cif = cif;
	}

	public Editorial() {
		super();
	}

	public String getNombre() {
		return nombre;
	}

	public void setNombre(String nombre) {
		this.nombre = nombre;
	}

	public String getCif() {
		return cif;
	}

	public void setCif(String cif) {
		this.cif = cif;
	}

	@Override
	public String toString() {
		return "Editorial [nombre=" + nombre + ", cif=" + cif + "]";
	}
}
