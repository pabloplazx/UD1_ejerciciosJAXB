package logica;

import java.util.ArrayList;
import java.util.List;

import jakarta.xml.bind.annotation.XmlAttribute;
import jakarta.xml.bind.annotation.XmlElement;

public class Mochila {

	private int capacidadMaxima;
	private List<Item> items = new ArrayList<>();
	
	public Mochila() {
		super();
	}

	@XmlAttribute
	public int getCapacidadMaxima() {
		return capacidadMaxima;
	}

	public void setCapacidadMaxima(int capacidadMaxima) {
		this.capacidadMaxima = capacidadMaxima;
	}

	@XmlElement(name = "item")
	public List<Item> getItems() {
		return items;
	}

	public void setItems(List<Item> items) {
		this.items = items;
	}
	
	
	
	
}
