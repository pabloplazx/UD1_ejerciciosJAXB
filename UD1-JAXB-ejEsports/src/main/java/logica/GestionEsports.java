package logica;

import java.time.LocalDate;
import java.util.ArrayList;
import java.util.List;

public class GestionEsports {

	public void mostrarMenu() {
		System.out.println("1. Buscar jugadores por rol");
		System.out.println("2. Calcular masa salaria de un equipo");
		System.out.println("3. Buscar jugadores jovenes");
		System.out.println("4. Sancionar jugador");
		System.out.println("5. SALIR");
	}
	
	public void buscarJugadoresRol(LigaEsports liga, String rol) {
		
		boolean encontrado = false;
		
		for (Equipo equipo : liga.getEquipos()) {
			for (Jugador jugador : equipo.getJugadores()) {
				if (jugador.getRol().equalsIgnoreCase(rol)) {
					encontrado = true;
					System.out.println(jugador);
				}
			}
		}
		
		if (!encontrado) {
			System.out.println("No se encontro ningun jugador con ese rol en el equipo");
		}
	}
	
	public double masaSalarial(LigaEsports liga, String tagEquipo) {
		double masaSalarial = 0;
		
		boolean encontrado = false;
		
		for (Equipo equipo : liga.getEquipos()) {
			if (equipo.getTag().equalsIgnoreCase(tagEquipo)) {
				encontrado = true;
				
				for (Jugador jugador : equipo.getJugadores()) {
					masaSalarial += jugador.getSalario();
				}
			}
		}
		
		if (!encontrado) {
			masaSalarial = -1;
		}
		return masaSalarial;
	}
	
	public void buscarJugadoresJovenes(LigaEsports liga, LocalDate ferchaCorte) {
		
		List<Jugador> jugadoresJovenes = new ArrayList<>();
		
		for (Equipo equipo : liga.getEquipos()) {
			for (Jugador jugador : equipo.getJugadores()) {
				if (jugador.getFechaNacimiento().isBefore(ferchaCorte)) {
					jugadoresJovenes.add(jugador);
				}
			}
		}
		
		if (jugadoresJovenes.isEmpty()) {
			System.out.println("No hay jugadores mas jovenes que esa edad");
		} else {
			for (Jugador jugador : jugadoresJovenes) {
				System.out.println(jugador);
			}
		}
	}
	
	public void sancionarJugador(LigaEsports liga, String nick) {
		
		boolean encontrado = false;
		
		for (Equipo equipo : liga.getEquipos()) {
			for (Jugador jugador : equipo.getJugadores()) {
				if (jugador.getNick().equalsIgnoreCase(nick)) {
					encontrado = true;
					
					if (jugador.isActivo()) {
						jugador.setActivo(false);
					}
					
					double salarioNuevo = (double) jugador.getSalario() / 2;
					
					jugador.setSalario(salarioNuevo);
				}
			}
		}
		
		if (!encontrado) {
			System.out.println("No se pudo encontrar ningun jugador con ese nick");
		}
	}
}
