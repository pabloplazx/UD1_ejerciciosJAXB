package logica;

import jakarta.xml.bind.annotation.XmlAttribute;

public class Entrenador {
	
	private String idLicencia;
	private String nombre;
	private String ciudad;
	private Equipo equipo;
	
	public Entrenador() {
		super();
	}

	@XmlAttribute
	public String getIdLicencia() {
		return idLicencia;
	}

	public void setIdLicencia(String idLicencia) {
		this.idLicencia = idLicencia;
	}

	public String getNombre() {
		return nombre;
	}

	public void setNombre(String nombre) {
		this.nombre = nombre;
	}

	public String getCiudad() {
		return ciudad;
	}

	public void setCiudad(String ciudad) {
		this.ciudad = ciudad;
	}

	public Equipo getEquipo() {
		return equipo;
	}

	public void setEquipo(Equipo equipo) {
		this.equipo = equipo;
	}
	
	

}
