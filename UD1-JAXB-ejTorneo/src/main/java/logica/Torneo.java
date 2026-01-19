package logica;

import java.util.ArrayList;
import java.util.List;

import jakarta.xml.bind.annotation.XmlElement;
import jakarta.xml.bind.annotation.XmlElementWrapper;
import jakarta.xml.bind.annotation.XmlRootElement;

@XmlRootElement
public class Torneo {

	private List<Entrenador> entrenadores = new ArrayList<>();

	public Torneo() {
		super();
	}

	@XmlElementWrapper(name = "lista_participantes")
	@XmlElement(name = "entrenador")
	public List<Entrenador> getEntrenadores() {
		return entrenadores;
	}

	public void setEntrenadores(List<Entrenador> entrenadores) {
		this.entrenadores = entrenadores;
	}
	
	
}
