package logica;

import java.util.ArrayList;
import java.util.List;

import jakarta.xml.bind.annotation.XmlAttribute;
import jakarta.xml.bind.annotation.XmlElement;
import jakarta.xml.bind.annotation.XmlElementWrapper;
import jakarta.xml.bind.annotation.XmlType;

@XmlType(propOrder = {"alias", "nivel", "lenguajes"})
public class Programador {
	
	private String id;
	private String alias;
	private String nivel;
	private List<String> lenguajes = new ArrayList<>();
	public Programador(String id, String alias, String nivel, List<String> lenguajes) {
		super();
		this.id = id;
		this.alias = alias;
		this.nivel = nivel;
		this.lenguajes = lenguajes;
	}
	public Programador() {
		super();
	}
	
	@XmlAttribute
	public String getId() {
		return id;
	}
	public void setId(String id) {
		this.id = id;
	}
	
	public String getAlias() {
		return alias;
	}
	public void setAlias(String alias) {
		this.alias = alias;
	}
	public String getNivel() {
		return nivel;
	}
	public void setNivel(String nivel) {
		this.nivel = nivel;
	}
	
	@XmlElementWrapper(name = "lenguajes")
	@XmlElement(name = "lang")
	public List<String> getLenguajes() {
		return lenguajes;
	}
	public void setLenguajes(List<String> lenguajes) {
		this.lenguajes = lenguajes;
	}
	
	
	
	
	
	
	
	

}
