package logica;

import java.util.ArrayList;
import java.util.List;

import jakarta.xml.bind.annotation.XmlAttribute;
import jakarta.xml.bind.annotation.XmlElement;
import jakarta.xml.bind.annotation.XmlElementWrapper;
import jakarta.xml.bind.annotation.XmlRootElement;
import jakarta.xml.bind.annotation.XmlType;

@XmlRootElement(name = "liga_esports")
@XmlType(propOrder = {"presupuesto", "equipos"})
public class LigaEsports {

	private String temporada;
	private String region;
	private double presupuesto;
	private List<Equipo> equipos = new ArrayList<>();
	public LigaEsports() {
		super();
	}
	@XmlAttribute
	public String getTemporada() {
		return temporada;
	}
	public void setTemporada(String temporada) {
		this.temporada = temporada;
	}
	@XmlAttribute
	public String getRegion() {
		return region;
	}
	public void setRegion(String region) {
		this.region = region;
	}
	
	@XmlElement(name = "presupuesto_equipos")
	public double getPresupuesto() {
		return presupuesto;
	}
	public void setPresupuesto(double presupuesto) {
		this.presupuesto = presupuesto;
	}
	
	@XmlElementWrapper(name = "lista_equipos")
	@XmlElement(name = "equipo")
	public List<Equipo> getEquipos() {
		return equipos;
	}
	public void setEquipos(List<Equipo> equipos) {
		this.equipos = equipos;
	}
	
	
}
