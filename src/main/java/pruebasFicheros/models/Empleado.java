package pruebasFicheros.models;

public class Empleado {
	private String identificador;
	private String nombreApellido;
	private int edad;
	private String empresa;
	
	@Override
	public String toString() {
		return "Empleado [identificador=" + identificador + ", nombreApellido=" + nombreApellido + ", edad=" + edad
				+ ", empresa=" + empresa + "]";
	}

	public Empleado(String identificador, String nombreApellido, int edad, String empresa) {
		super();
		this.identificador = identificador;
		this.nombreApellido = nombreApellido;
		this.edad = edad;
		this.empresa = empresa;
	}
}
