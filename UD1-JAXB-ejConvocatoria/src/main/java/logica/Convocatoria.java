package logica;

import java.util.ArrayList;
import java.util.List;

import jakarta.xml.bind.annotation.XmlAttribute;
import jakarta.xml.bind.annotation.XmlElement;
import jakarta.xml.bind.annotation.XmlElementWrapper;
import jakarta.xml.bind.annotation.XmlRootElement;
import jakarta.xml.bind.annotation.XmlType;

@XmlRootElement
// CORRECCIÓN: Usamos "aspirantes" (nombre en Java), NO "lista_aspirantes" (nombre en XML)
// Nota: "anio" no se pone aquí porque es un atributo (@XmlAttribute), no un elemento.
@XmlType(propOrder =  {"plaza", "ciudad", "aspirantes"})
public class Convocatoria {
	
	private String año;
	private String plaza;
	private String ciudad;
	private List<Aspirante> aspirantes = new ArrayList<>();
	
	public Convocatoria() {
		super();
	}

	public String getCiudad() {
		return ciudad;
	}
	public void setCiudad(String ciudad) {
		this.ciudad = ciudad;
	}

	@XmlAttribute(name = "anio")
	public String getAño() {
		return año;
	}

	public void setAño(String año) {
		this.año = año;
	}

	@XmlElement
	public String getPlaza() {
		return plaza;
	}

	public void setPlaza(String plaza) {
		this.plaza = plaza;
	}

	@XmlElementWrapper(name = "lista_aspirantes")
	@XmlElement(name = "aspirante")
	public List<Aspirante> getAspirantes() {
		return aspirantes;
	}

	public void setAspirantes(List<Aspirante> aspirantes) {
		this.aspirantes = aspirantes;
	}
}