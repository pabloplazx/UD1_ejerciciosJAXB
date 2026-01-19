package logica;

import java.util.ArrayList;
import java.util.List;

import jakarta.xml.bind.annotation.XmlAttribute;
import jakarta.xml.bind.annotation.XmlElement;

public class Equipo {

	private String modo;
	private List<Programador> programadores = new ArrayList<>();
	public Equipo(String modo, List<Programador> programadores) {
		super();
		this.modo = modo;
		this.programadores = programadores;
	}
	public Equipo() {
		super();
	}
	@XmlAttribute
	public String getModo() {
		return modo;
	}
	public void setModo(String modo) {
		this.modo = modo;
	}
	
	@XmlElement(name = "programador")
	public List<Programador> getProgramadores() {
		return programadores;
	}
	public void setProgramadores(List<Programador> programadores) {
		this.programadores = programadores;
	}
	
	
	
}
