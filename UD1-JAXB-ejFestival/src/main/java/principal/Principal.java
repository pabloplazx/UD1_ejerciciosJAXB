package principal;

import java.io.File;

import consola.Leer;
import jakarta.xml.bind.JAXBContext;
import jakarta.xml.bind.JAXBException;
import logica.Festival;
import logica.GestionFestival;

public class Principal {

	public static void main(String[] args) {
		
		System.out.println("Gestion de la base de datos de un festival");
		
		int op = 0;
		
		Festival festival = cargarXml();
		
		do {
			GestionFestival.mostrarMenu();
			System.out.print("Introduzca opcion: ");
			
			op = Leer.entero();
			
			switch (op) {
			case 1:
				System.out.print("Introduzca id del escenario: ");
				String idEscenario = Leer.linea();
				
				GestionFestival.listarArtistas(festival, idEscenario);
				break;
			case 2:
				System.out.print("Introduzca nombre del artista: ");
				String nombreArtista = Leer.linea();
				
				GestionFestival.buscarCancionesArtista(festival, nombreArtista);
				break;
			case 3:
				System.out.println(GestionFestival.calcularPresupuestoTotal(festival));;
				break;
			case 4:
				System.out.println("Introduzca nombre del genero: ");
				String nombreGenero = Leer.linea();
				
				System.out.println(GestionFestival.contarArtistasGenero(festival, nombreGenero));;
				break;
			case 5:
				System.out.println("Saliendo...");
				break;
			default:
				System.out.println("Opcion no valida");
				break;
				
			}

		} while (op != 5);
	}
	
	private static Festival cargarXml() {
		Festival festival = new Festival();
		
		try {
			JAXBContext context = JAXBContext.newInstance(Festival.class);
			
			jakarta.xml.bind.Unmarshaller unmarshaller = context.createUnmarshaller();
			
			File archivo = new File("C:\\Users\\plaza\\Desktop\\DATOS\\festival.xml");
			
			Festival fest = (Festival) unmarshaller.unmarshal(archivo);
			
			festival = fest;
		} catch (JAXBException  e) {
			e.printStackTrace();
		}
		
		return festival;
	}
}
