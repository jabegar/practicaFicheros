package pruebasFicheros.models;

public class Libro {
	private String id;
	private String categoria;
	private String titulo;
	private String autor;
	private Editorial editorial;
	
	public Libro(String titulo) {
		super();
		this.titulo = titulo;
	}
	
	public Libro(String id, String titulo) {
		super();
		this.id = id;
		this.titulo = titulo;
	}

	public String getId() {
		return id;
	}

	public void setId(String id) {
		this.id = id;
	}

	public String getCategoria() {
		return categoria;
	}

	public void setCategoria(String categoria) {
		this.categoria = categoria;
	}

	public String getTitulo() {
		return titulo;
	}

	public void setTitulo(String titulo) {
		this.titulo = titulo;
	}

	public String getAutor() {
		return autor;
	}

	public void setAutor(String autor) {
		this.autor = autor;
	}
	
	public Editorial getEditorial() {
		return this.editorial;
	}
	
	public void setEditorial(Editorial editorial) {
		this.editorial = editorial;
	}

	@Override
	public String toString() {
		return "Libro [id=" + id + ", categoria=" + categoria + ", titulo=" + titulo + ", autor=" + autor + ", editorial=" + editorial + "]";
	}
	
	
}
