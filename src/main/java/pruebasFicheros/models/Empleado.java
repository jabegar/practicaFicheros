package pruebasFicheros.models;

public class Empleado {
	private String identificador;
	private String nombreApellido;
	private int edad;
	private String empresa;
//	private Domicilio domicilio;
	private Puesto puesto;

	public Empleado (String nombreApellido, String empresa, Puesto puesto) {
		this.nombreApellido = nombreApellido;
		this.empresa = empresa;
	}
	public Empleado(String identificador, String nombreApellido, int edad, String empresa,
			Puesto puesto /* , Domicilio domicilio */) {
		super();
		this.identificador = identificador;
		this.nombreApellido = nombreApellido;
		this.edad = edad;
		this.empresa = empresa;
		this.puesto = puesto;
//		this.domicilio = domicilio;
	}

	public String getIdentificador() {
		return identificador;
	}

	public void setIdentificador(String identificador) {
		this.identificador = identificador;
	}

	public String getNombreApellido() {
		return nombreApellido;
	}

	public void setNombreApellido(String nombreApellido) {
		this.nombreApellido = nombreApellido;
	}

	public int getEdad() {
		return edad;
	}

	public void setEdad(int edad) {
		this.edad = edad;
	}

	public String getEmpresa() {
		return empresa;
	}

	public void setEmpresa(String empresa) {
		this.empresa = empresa;
	}

	public Puesto getPuesto() {
		return puesto;
	}
	public void setPuesto(Puesto puesto) {
		this.puesto = puesto;
	}
	@Override
	public String toString() {
		return "Empleado [identificador=" + identificador + ", nombreApellido=" + nombreApellido + ", edad=" + edad
				+ ", empresa=" + empresa + "]";
	}
}
