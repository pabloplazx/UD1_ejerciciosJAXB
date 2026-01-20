package logica;

import jakarta.xml.bind.annotation.XmlAttribute;
import jakarta.xml.bind.annotation.XmlType;

@XmlType(propOrder = {"alias", "oro", "estadisticas", "mochila"})
public class Jugador {

	private String clase;
	private int nivel;
	private String alias;
	private double oro;
	private Estadisticas estadisticas = new Estadisticas();
	private Mochila mochila = new Mochila();
	
	public Jugador() {
		super();
	}

	@XmlAttribute
	public String getClase() {
		return clase;
	}

	public void setClase(String clase) {
		this.clase = clase;
	}

	@XmlAttribute
	public int getNivel() {
		return nivel;
	}

	public void setNivel(int nivel) {
		this.nivel = nivel;
	}

	public String getAlias() {
		return alias;
	}

	public void setAlias(String alias) {
		this.alias = alias;
	}

	public double getOro() {
		return oro;
	}

	public void setOro(double oro) {
		this.oro = oro;
	}

	public Estadisticas getEstadisticas() {
		return estadisticas;
	}

	public void setEstadisticas(Estadisticas estadisticas) {
		this.estadisticas = estadisticas;
	}

	public Mochila getMochila() {
		return mochila;
	}

	public void setMochila(Mochila mochila) {
		this.mochila = mochila;
	}
	
	
	
	
}
