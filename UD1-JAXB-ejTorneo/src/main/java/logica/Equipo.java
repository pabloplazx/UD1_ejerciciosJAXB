package logica;

import java.util.ArrayList;
import java.util.List;

public class Equipo {
	
	private List<Monstruo> monstruos = new ArrayList<>();

	public Equipo() {
		super();
	}

	public List<Monstruo> getMonstruos() {
		return monstruos;
	}

	public void setMonstruos(List<Monstruo> monstruos) {
		this.monstruos = monstruos;
	}
	
	

}
