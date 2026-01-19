package logica;

import java.util.ArrayList;
import java.util.List;



import jakarta.xml.bind.annotation.XmlAttribute;
import jakarta.xml.bind.annotation.XmlElement;
import jakarta.xml.bind.annotation.XmlElementWrapper;
import jakarta.xml.bind.annotation.XmlType;

@XmlType(propOrder = {"nombre", "genero", "cache","canciones"})
public class Artista {

	private String hora;
	private String nombre;
	private String genero;
	private double cache;
	private List<Cancion> canciones = new ArrayList<>();
	
	public Artista() {
		super();
	}

	@XmlAttribute(name = "hora")
	public String getHora() {
		return hora;
	}

	public void setHora(String hora) {
		this.hora = hora;
	}

	
	public String getNombre() {
		return nombre;
	}

	public void setNombre(String nombre) {
		this.nombre = nombre;
	}

	public String getGenero() {
		return genero;
	}

	public void setGenero(String genero) {
		this.genero = genero;
	}

	public double getCache() {
		return cache;
	}

	public void setCache(double cache) {
		this.cache = cache;
	}

	@XmlElementWrapper(name = "setlist")
	@XmlElement(name = "cancion")
	public List<Cancion> getCanciones() {
		return canciones;
	}

	public void setCanciones(List<Cancion> canciones) {
		this.canciones = canciones;
	}
	
	
	
	
}
