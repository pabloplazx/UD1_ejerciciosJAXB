package logica;

import java.util.ArrayList;
import java.util.List;

import jakarta.xml.bind.annotation.XmlAttribute;
import jakarta.xml.bind.annotation.XmlElement;
import jakarta.xml.bind.annotation.XmlElementWrapper;
import jakarta.xml.bind.annotation.XmlRootElement;

@XmlRootElement
public class Menu {
	private String fecha;
	private String comida;
	private String nombreRestaurante;
	private boolean abierto;
	private List<Plato> platos = new ArrayList<>();
	public Menu() {
		super();
	}
	
	@XmlAttribute
	public String getFecha() {
		return fecha;
	}
	public void setFecha(String fecha) {
		this.fecha = fecha;
	}
	@XmlAttribute(name = "turno")
	public String getComida() {
		return comida;
	}
	public void setComida(String comida) {
		this.comida = comida;
	}
	@XmlElement(name = "restaurante")
	public String getNombreRestaurante() {
		return nombreRestaurante;
	}
	public void setNombreRestaurante(String nombreRestaurante) {
		this.nombreRestaurante = nombreRestaurante;
	}
	@XmlElement(name = "abierto")
	public boolean isAbierto() {
		return abierto;
	}
	public void setAbierto(boolean abierto) {
		this.abierto = abierto;
	}
	
	@XmlElementWrapper(name = "lista_platos")
	@XmlElement(name = "plato")
	public List<Plato> getPlatos() {
		return platos;
	}
	public void setPlatos(List<Plato> platos) {
		this.platos = platos;
	}
	
	
	
	
}
