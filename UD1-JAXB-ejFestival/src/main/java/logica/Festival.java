package logica;

import java.util.ArrayList;
import java.util.List;



import jakarta.xml.bind.annotation.XmlAttribute;
import jakarta.xml.bind.annotation.XmlElement;
import jakarta.xml.bind.annotation.XmlElementWrapper;
import jakarta.xml.bind.annotation.XmlRootElement;
import jakarta.xml.bind.annotation.XmlType;


@XmlRootElement
@XmlType(propOrder = {"lugar", "escenarios"})
public class Festival {

	private String nombre;
	private String lugar;
	private List<Escenario> escenarios = new ArrayList<>();
	public Festival() {
		super();
	}
	
	@XmlAttribute
	public String getNombre() {
		return nombre;
	}
	public void setNombre(String nombre) {
		this.nombre = nombre;
	}
	
	@XmlElement(name = "lugar")
	public String getLugar() {
		return lugar;
	}
	public void setLugar(String lugar) {
		this.lugar = lugar;
	}
	
	@XmlElementWrapper(name = "lista_escenarios")
	@XmlElement(name = "escenario")
	public List<Escenario> getEscenarios() {
		return escenarios;
	}
	public void setEscenarios(List<Escenario> escenarios) {
		this.escenarios = escenarios;
	}
	
	
}
