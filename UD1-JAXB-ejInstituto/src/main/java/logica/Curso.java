package logica;

import java.util.ArrayList;
import java.util.List;

import jakarta.xml.bind.annotation.XmlAttribute;
import jakarta.xml.bind.annotation.XmlElement;
import jakarta.xml.bind.annotation.XmlElementWrapper;
import jakarta.xml.bind.annotation.XmlType;

@XmlType(propOrder = {"aula", "alumnos"})
public class Curso {

	private String id;
	private String tutor;
	private int aula;
	private List<Alumno> alumnos = new ArrayList<>();
	public Curso() {
		super();
	}
	
	@XmlAttribute
	public String getId() {
		return id;
	}
	public void setId(String id) {
		this.id = id;
	}
	@XmlAttribute
	public String getTutor() {
		return tutor;
	}
	public void setTutor(String tutor) {
		this.tutor = tutor;
	}
	@XmlElement(name = "aula")
	public int getAula() {
		return aula;
	}
	public void setAula(int aula) {
		this.aula = aula;
	}
	@XmlElementWrapper(name = "listado_alumno")
	@XmlElement(name = "alumno")
	public List<Alumno> getAlumnos() {
		return alumnos;
	}
	public void setAlumnos(List<Alumno> alumnos) {
		this.alumnos = alumnos;
	}
	
	
}
