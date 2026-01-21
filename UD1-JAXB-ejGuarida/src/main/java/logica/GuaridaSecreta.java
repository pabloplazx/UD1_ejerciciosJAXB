package logica;

import java.util.ArrayList;
import java.util.List;

import jakarta.xml.bind.annotation.XmlAttribute;
import jakarta.xml.bind.annotation.XmlElement;
import jakarta.xml.bind.annotation.XmlElementWrapper;
import jakarta.xml.bind.annotation.XmlRootElement;
import jakarta.xml.bind.annotation.XmlType;

@XmlRootElement(name = "guarida_secreta")
@XmlType(propOrder = {"villano", "armas", "planMaestro"})
public class GuaridaSecreta {

	private String id; 
	private String ubicacion;
	private Villano villano;
	private List<Arma> armas = new ArrayList<>();
	private String planMaestro;
	public GuaridaSecreta() {
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
	public String getUbicacion() {
		return ubicacion;
	}
	public void setUbicacion(String ubicacion) {
		this.ubicacion = ubicacion;
	}
	public Villano getVillano() {
		return villano;
	}
	public void setVillano(Villano villano) {
		this.villano = villano;
	}
	
	@XmlElementWrapper(name = "arsenal")
	@XmlElement(name = "arma")
	public List<Arma> getArmas() {
		return armas;
	}
	public void setArmas(List<Arma> armas) {
		this.armas = armas;
	}
	public String getPlanMaestro() {
		return planMaestro;
	}
	public void setPlanMaestro(String planMaestro) {
		this.planMaestro = planMaestro;
	}
	
	
}
