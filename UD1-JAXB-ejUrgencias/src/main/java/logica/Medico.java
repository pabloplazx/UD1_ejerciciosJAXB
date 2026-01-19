package logica;

import jakarta.xml.bind.annotation.XmlAttribute;
import jakarta.xml.bind.annotation.XmlValue;

public class Medico {
	
	private String especialidad;
	private String nombreDoctor;
	
	public Medico() {
		super();
	}

	@XmlAttribute(name = "especialidad")
	public String getEspecialidad() {
		return especialidad;
	}

	public void setEspecialidad(String especialidad) {
		this.especialidad = especialidad;
	}

	@XmlValue
	public String getNombreDoctor() {
		return nombreDoctor;
	}

	public void setNombreDoctor(String nombreDoctor) {
		this.nombreDoctor = nombreDoctor;
	}

	@Override
	public String toString() {
		return "Medico [especialidad=" + especialidad + ", nombreDoctor=" + nombreDoctor + "]";
	}
	
	
	

}
