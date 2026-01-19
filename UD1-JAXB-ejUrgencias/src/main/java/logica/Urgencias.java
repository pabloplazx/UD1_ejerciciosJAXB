package logica;

import java.util.ArrayList;
import java.util.List;

import jakarta.xml.bind.annotation.XmlAttribute;
import jakarta.xml.bind.annotation.XmlElement;
import jakarta.xml.bind.annotation.XmlElementWrapper;
import jakarta.xml.bind.annotation.XmlRootElement;

@XmlRootElement
public class Urgencias {
	
	private String turno;
	private String hospital;
	private List<Medico> equipo_medio = new ArrayList<>();
	private List<Paciente> pacientes = new ArrayList<>();
	public Urgencias() {
		super();
	}
	
	@XmlAttribute(name = "turno")
	public String getTurno() {
		return turno;
	}
	public void setTurno(String turno) {
		this.turno = turno;
	}
	
	@XmlElement
	public String getHospital() {
		return hospital;
	}
	public void setHospital(String hospital) {
		this.hospital = hospital;
	}
	@XmlElementWrapper(name = "equipo_medico")
	@XmlElement(name = "medico")
	public List<Medico> getEquipo_medio() {
		return equipo_medio;
	}
	public void setEquipo_medio(List<Medico> equipo_medio) {
		this.equipo_medio = equipo_medio;
	}
	
	@XmlElementWrapper(name = "sala_espera")
	@XmlElement(name = "paciente")
	public List<Paciente> getPacientes() {
		return pacientes;
	}
	public void setPacientes(List<Paciente> pacientes) {
		this.pacientes = pacientes;
	}
	
	

}
