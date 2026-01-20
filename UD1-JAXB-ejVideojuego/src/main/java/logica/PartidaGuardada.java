package logica;

import java.util.ArrayList;
import java.util.Date;
import java.util.List;

import jakarta.xml.bind.annotation.XmlAttribute;
import jakarta.xml.bind.annotation.XmlElement;
import jakarta.xml.bind.annotation.XmlRootElement;

@XmlRootElement
public class PartidaGuardada {

	private Date fecha;
	private List<Jugador> jugadores = new ArrayList<>();
	public PartidaGuardada() {
		super();
	}
	
	@XmlAttribute
	public Date getFecha() {
		return fecha;
	}
	public void setFecha(Date fecha) {
		this.fecha = fecha;
	}
	
	@XmlElement(name = "jugador")
	public List<Jugador> getJugadores() {
		return jugadores;
	}
	public void setJugadores(List<Jugador> jugadores) {
		this.jugadores = jugadores;
	}
	
	
}
