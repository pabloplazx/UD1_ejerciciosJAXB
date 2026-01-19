package logica;

import java.util.ArrayList;
import java.util.List;

import jakarta.xml.bind.annotation.XmlAttribute;
import jakarta.xml.bind.annotation.XmlElement;
import jakarta.xml.bind.annotation.XmlElementWrapper;

public class Plato {
	
	private String id;
	private String nombre;
	private double precios;
	private int calorias;
	private List<String> ingredients = new ArrayList<>();
	public Plato() {
		super();
	}
	
	@XmlAttribute
	public String getId() {
		return id;
	}
	public void setId(String id) {
		this.id = id;
	}
	public String getNombre() {
		return nombre;
	}
	public void setNombre(String nombre) {
		this.nombre = nombre;
	}
	@XmlElement(name = "precio")
	public double getPrecios() {
		return precios;
	}
	public void setPrecios(double precios) {
		this.precios = precios;
	}
	public int getCalorias() {
		return calorias;
	}
	public void setCalorias(int calorias) {
		this.calorias = calorias;
	}
	
	@XmlElementWrapper(name = "ingredientes")
	@XmlElement(name = "item")
	public List<String> getIngredients() {
		return ingredients;
	}
	public void setIngredients(List<String> ingredients) {
		this.ingredients = ingredients;
	}
	
	
}
	