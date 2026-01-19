package logica;

import jakarta.xml.bind.annotation.XmlAttribute;
import jakarta.xml.bind.annotation.XmlValue;

public class Nota {
	
	private String asignatura;
	private double nota;
	
	public Nota() {
		super();
	}
	
	// CORRECCIÓN: "asginatura" estaba mal escrito. Debe ser "asignatura"
	@XmlAttribute(name = "asignatura")
	public String getAsignatura() {
		return asignatura;
	}
	public void setAsignatura(String asignatura) {
		this.asignatura = asignatura;
	}
	
	@XmlValue
	public double getNota() {
		return nota;
	}
	public void setNota(double nota) {
		this.nota = nota;
	}

	@Override
	public String toString() {
		return "Nota [asignatura=" + asignatura + ", nota=" + nota + "]";
	}
}