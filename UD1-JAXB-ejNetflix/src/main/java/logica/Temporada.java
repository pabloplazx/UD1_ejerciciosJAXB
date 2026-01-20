package logica;

import java.util.ArrayList;
import java.util.List;

import jakarta.xml.bind.annotation.XmlAttribute;
import jakarta.xml.bind.annotation.XmlElement;
import jakarta.xml.bind.annotation.XmlElementWrapper;

public class Temporada {

	private int numero;
	private List<Capitulo> capitulos = new ArrayList<>();
	public Temporada() {
		super();
	}
	
	@XmlAttribute
	public int getNumero() {
		return numero;
	}
	public void setNumero(int numero) {
		this.numero = numero;
	}
	
	@XmlElementWrapper(name = "episodios")
	@XmlElement(name = "capitulo")
	public List<Capitulo> getCapitulos() {
		return capitulos;
	}
	public void setCapitulos(List<Capitulo> capitulos) {
		this.capitulos = capitulos;
	}
	
	
}
