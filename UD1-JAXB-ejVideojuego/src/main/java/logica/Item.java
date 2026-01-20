package logica;

import jakarta.xml.bind.annotation.XmlAttribute;

public class Item {

	private boolean equipado;
	private String nombre;
	private double peso;
	public Item() {
		super();
	}
	
	@XmlAttribute
	public boolean isEquipado() {
		return equipado;
	}
	public void setEquipado(boolean equipado) {
		this.equipado = equipado;
	}
	public String getNombre() {
		return nombre;
	}
	public void setNombre(String nombre) {
		this.nombre = nombre;
	}
	public double getPeso() {
		return peso;
	}
	public void setPeso(double peso) {
		this.peso = peso;
	}
	
	
}
