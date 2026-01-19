package logica;

public class GestionFestival {

	public static void mostrarMenu() {
		System.out.println("1. Listar artista por escenario");
		System.out.println("2. Buscar canciones de un artista");
		System.out.println("3. Calcular presupuesto total");
		System.out.println("4. Contar artistas por genero");
		System.out.println("5. SALIR");
	}
	
	public static void listarArtistas(Festival festival, String idEscenario) {
		boolean encontrado = false;
		
		for (Escenario escenario : festival.getEscenarios()) {
			if (escenario.getId().equalsIgnoreCase(idEscenario)) {
				encontrado = true;
				
				for (Artista artista : escenario.getArtistas()) {
					System.out.println(artista.getNombre());
				}
			}
		}
		
		if (!encontrado) {
			System.out.println("No se encontro ningun escenario con ese id");
		}
	}
	
	public static void buscarCancionesArtista(Festival festival, String nombreArtista)	 {
		boolean encontrado = false;
		
		for (Escenario escen : festival.getEscenarios()) {
			for (Artista artista : escen.getArtistas()) {
				if (artista.getNombre().equalsIgnoreCase(nombreArtista)) {
					encontrado = true;
					for (Cancion cancion : artista.getCanciones()) {
						System.out.println(cancion);
					}
				}
			}
		}
		
		if (!encontrado) {
			System.out.println("No se pudo encontrar ningun artista con ese nombre");
		}
	}
	
	public static int calcularPresupuestoTotal(Festival festival) {
		
		int sumaTotal = 0;
		for (Escenario escen : festival.getEscenarios()) {
			for (Artista artista : escen.getArtistas()) {
				sumaTotal += artista.getCache();
			}
		}
		
		return sumaTotal;
	}
	
	public static int contarArtistasGenero(Festival festival, String nombreGenero) {
		int numeroGeneros = 0;
		
		for (Escenario esc : festival.getEscenarios()) {
			for (Artista artista : esc.getArtistas()) {
				if (artista.getGenero().equalsIgnoreCase(nombreGenero)) {
					numeroGeneros++;
				}
			}
		}
		
		return numeroGeneros;
	}
}
