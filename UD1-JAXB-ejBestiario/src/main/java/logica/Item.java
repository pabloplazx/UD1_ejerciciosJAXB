package logica;

import jakarta.xml.bind.annotation.XmlAttribute;
import jakarta.xml.bind.annotation.XmlValue;

public class Item {

	private String probabilidad;
	private String nombre;
	
	public Item() {
		super();
	}

	@XmlAttribute
	public String getProbabilidad() {
		return probabilidad;
	}

	public void setProbabilidad(String probabilidad) {
		this.probabilidad = probabilidad;
	}

	@XmlValue
	public String getNombre() {
		return nombre;
	}

	public void setNombre(String nombre) {
		this.nombre = nombre;
	}
	
	
}
