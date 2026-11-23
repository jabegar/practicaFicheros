package pruebasFicheros.models;

public class Puesto {
	private String identificador;
	private String nombre;
	private String departamento;
	private int salario;

	public Puesto(String nombre, int salario) {
		this.nombre = nombre;
		this.salario = salario;
	}

	public String getIdentificador() {
		return identificador;
	}

	public void setIdentificador(String identificador) {
		this.identificador = identificador;
	}

	public String getNombre() {
		return nombre;
	}

	public void setNombre(String nombre) {
		this.nombre = nombre;
	}

	public String getDepartamento() {
		return departamento;
	}

	public void setDepartamento(String departamento) {
		this.departamento = departamento;
	}

	public int getSalario() {
		return salario;
	}

	public void setSalario(int salario) {
		this.salario = salario;
	}

	@Override
	public String toString() {
		return "Puesto [identificador=" + identificador + ", nombre=" + nombre + ", departamento=" + departamento
				+ ", salario=" + salario + "]";
	}
}
