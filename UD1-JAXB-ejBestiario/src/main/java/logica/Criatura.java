package logica;

import java.util.ArrayList;
import java.util.List;

import jakarta.xml.bind.annotation.XmlAttribute;
import jakarta.xml.bind.annotation.XmlElement;
import jakarta.xml.bind.annotation.XmlElementWrapper;
import jakarta.xml.bind.annotation.XmlType;

@XmlType(propOrder = {"nombre", "nivel", "debilidad", "items"})
public class Criatura {

	private String id;
	private boolean hostil;
	private String nombre;
	private int nivel;
	private Debilidad debilidad;
	private List<Item> items = new ArrayList<>();

	public Criatura() {
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
	public boolean isHostil() {
		return hostil;
	}

	public void setHostil(boolean hostil) {
		this.hostil = hostil;
	}

	public String getNombre() {
		return nombre;
	}

	public void setNombre(String nombre) {
		this.nombre = nombre;
	}

	public int getNivel() {
		return nivel;
	}

	public void setNivel(int nivel) {
		this.nivel = nivel;
	}

	public Debilidad getDebilidad() {
		return debilidad;
	}

	public void setDebilidad(Debilidad debilidad) {
		this.debilidad = debilidad;
	}
	
	@XmlElementWrapper(name = "lista_drops")
	@XmlElement(name = "item")
	public List<Item> getItems() {
		return items;
	}

	public void setItems(List<Item> items) {
		this.items = items;
	}
	
	
	
	
}
