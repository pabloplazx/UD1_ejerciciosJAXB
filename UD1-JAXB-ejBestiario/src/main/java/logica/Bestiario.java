package logica;

import java.util.ArrayList;
import java.util.List;

import jakarta.xml.bind.annotation.XmlAttribute;
import jakarta.xml.bind.annotation.XmlElement;
import jakarta.xml.bind.annotation.XmlRootElement;

@XmlRootElement(name = "bestiario")
public class Bestiario {

	private String region;
	private String ultimaActulizacion;
	private List<Criatura> criaturas = new ArrayList<>();
	public Bestiario() {
		super();
	}
	
	@XmlAttribute
	public String getRegion() {
		return region;
	}
	public void setRegion(String region) {
		this.region = region;
	}
	@XmlAttribute(name = "ultima_actualizacion")
	public String getUltimaActulizacion() {
		return ultimaActulizacion;
	}
	public void setUltimaActulizacion(String ultimaActulizacion) {
		this.ultimaActulizacion = ultimaActulizacion;
	}
	@XmlElement(name = "criatura")
	public List<Criatura> getCriaturas() {
		return criaturas;
	}
	public void setCriaturas(List<Criatura> criaturas) {
		this.criaturas = criaturas;
	}
	
	
}
