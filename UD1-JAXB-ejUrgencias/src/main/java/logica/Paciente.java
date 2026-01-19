package logica;

import jakarta.xml.bind.annotation.XmlAttribute;
import jakarta.xml.bind.annotation.XmlElement;

public class Paciente {
	
	private String sip;
	private String nombre;
	private int edad;
	private String sintomas;
	private String gravedad;
	public Paciente() {
		super();
	}
	
	@XmlAttribute(name = "sip")
	public String getSip() {
		return sip;
	}
	public void setSip(String sip) {
		this.sip = sip;
	}
	
	@XmlElement
	public String getNombre() {
		return nombre;
	}
	public void setNombre(String nombre) {
		this.nombre = nombre;
	}
	@XmlElement
	public int getEdad() {
		return edad;
	}
	public void setEdad(int edad) {
		this.edad = edad;
	}
	@XmlElement
	public String getSintomas() {
		return sintomas;
	}
	public void setSintomas(String sintomas) {
		this.sintomas = sintomas;
	}
	@XmlElement
	public String getGravedad() {
		return gravedad;
	}
	public void setGravedad(String gravedad) {
		this.gravedad = gravedad;
	}
	@Override
	public String toString() {
		return "Paciente [sip=" + sip + ", nombre=" + nombre + ", edad=" + edad + ", sintomas=" + sintomas
				+ ", gravedad=" + gravedad + "]";
	}
	
	
	

}
