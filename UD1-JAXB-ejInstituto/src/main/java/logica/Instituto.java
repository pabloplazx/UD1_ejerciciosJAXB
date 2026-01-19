package logica;

import java.util.ArrayList;
import java.util.List;

import jakarta.xml.bind.annotation.XmlAttribute;
import jakarta.xml.bind.annotation.XmlElement;
import jakarta.xml.bind.annotation.XmlElementWrapper;
import jakarta.xml.bind.annotation.XmlRootElement;
import jakarta.xml.bind.annotation.XmlType;

@XmlRootElement
@XmlType(propOrder = {"web", "cursos"})
public class Instituto {

	private String nombre;
	private String web;
	private List<Curso> cursos = new ArrayList<>();
	public Instituto() {
		super();
	}
	
	@XmlAttribute(name = "nombre")
	public String getNombre() {
		return nombre;
	}
	public void setNombre(String nombre) {
		this.nombre = nombre;
	}
	
	@XmlElement(name = "web")
	public String getWeb() {
		return web;
	}
	public void setWeb(String web) {
		this.web = web;
	}
	
	@XmlElementWrapper(name = "oferta_educativa")
	@XmlElement(name = "curso")
	public List<Curso> getCursos() {
		return cursos;
	}
	public void setCursos(List<Curso> cursos) {
		this.cursos = cursos;
	}
	@Override
	public String toString() {
		return "Instituto [nombre=" + nombre + ", cursos=" + cursos + "]";
	}
	
	
}
