package logica;

import jakarta.xml.bind.annotation.XmlAttribute;
import jakarta.xml.bind.annotation.XmlType;

@XmlType(propOrder = {"titulo", "autor", "precio", "publicado"})
public class Libro {
	
	private String isbn;
	private String titulo;
	private String autor;
	private Precio precio;
	private Boolean publicado;
	
	
	public Boolean getPublicado() {
		return publicado;
	}
	public void setPublicado(Boolean publiicado) {
		this.publicado = publiicado;
	}
	public String getAutor() {
		return autor;
	}
	public void setAutor(String autor) {
		this.autor = autor;
	}
	public Precio getPrecio() {
		return precio;
	}
	public void setPrecio(Precio precio) {
		this.precio = precio;
	}
	
	@XmlAttribute(name = "isbn")
	public String getIsbn() {
		return isbn;
	}
	public void setIsbn(String isbn) {
		this.isbn = isbn;
	}
	public String getTitulo() {
		return titulo;
	}
	public void setTitulo(String titulo) {
		this.titulo = titulo;
	}

	

}
