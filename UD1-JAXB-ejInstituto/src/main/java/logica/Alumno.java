package logica;

import java.util.ArrayList;
import java.util.List;

import jakarta.xml.bind.annotation.XmlAttribute;
import jakarta.xml.bind.annotation.XmlElement;
import jakarta.xml.bind.annotation.XmlElementWrapper;
import jakarta.xml.bind.annotation.XmlType;

@XmlType(propOrder = {"nombre", "edad", "notas"})
public class Alumno {
	private String dni;
	private String nombre;
	private int edad;
	private List<Nota> notas = new ArrayList<>();
	public Alumno() {
		super();
	}
	
	@XmlAttribute(name = "dni")
	public String getDni() {
		return dni;
	}
	public void setDni(String dni) {
		this.dni = dni;
	}
	@XmlElement
	public String getNombre() {
		return nombre;
	}
	public void setNombre(String nombre) {
		this.nombre = nombre;
	}
	public int getEdad() {
		return edad;
	}
	public void setEdad(int edad) {
		this.edad = edad;
	}
	
	@XmlElementWrapper(name = "boletin")
	@XmlElement(name = "nota")
	public List<Nota> getNotas() {
		return notas;
	}
	public void setNotas(List<Nota> notas) {
		this.notas = notas;
	}

	@Override
	public String toString() {
		return "Alumno [dni=" + dni + ", edad=" + edad + ", notas=" + notas + "]";
	}
	
	
	
	
	
	

}
