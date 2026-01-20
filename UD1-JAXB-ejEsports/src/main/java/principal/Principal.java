package principal;

import java.io.File;
import java.time.LocalDate;

import consola.Leer;
import jakarta.xml.bind.JAXBContext;
import jakarta.xml.bind.JAXBException;
import jakarta.xml.bind.Marshaller;
import logica.GestionEsports;
import logica.LigaEsports;

public class Principal {

	public static void main(String[] args) {
		
		System.out.println("Base de datos de una liga de esports");
		
		int op = 0;
		
		LigaEsports liga = cargarXml();
		
		GestionEsports gestion = new GestionEsports();
		
		do {
			gestion.mostrarMenu();
			System.out.print("Introduzca opcion: ");
			op = Leer.datoInt();
			
			switch (op) {
			case 1:
				System.out.print("Introduzca rol: ");
				String rol = Leer.dato();
				
				gestion.buscarJugadoresRol(liga, rol);
				break;
			case 2:
				System.out.println("Introduzca tag del equipo: ");
				String tagEquipo = Leer.dato();
				
				System.out.println("Masa salarial: "+gestion.masaSalarial(liga, tagEquipo));
				break;
			case 3:
				System.out.print("Introduzca fecha de corte: ");
				LocalDate fechaCorte = Leer.datoFecha();
				
				gestion.buscarJugadoresJovenes(liga, fechaCorte);
				break;
			case 4:
				System.out.println("Introduzca nick del jugador: ");
				String nick = Leer.dato();
				
				gestion.sancionarJugador(liga, nick);
				
				guardarXml(liga);
				break;
			case 5:
				System.out.println("Saliendo...");
				break;
			default:
				System.out.println("Opción no válida");
				break;
			}
		} while (op != 6);
	}
	
	private static LigaEsports cargarXml() {
		LigaEsports liga = new LigaEsports();
		
		try {
			JAXBContext context = JAXBContext.newInstance(LigaEsports.class);
			
			jakarta.xml.bind.Unmarshaller unmarshaller = context.createUnmarshaller();
			
			File archivo = new File("C:\\Users\\plaza\\Desktop\\DATOS\\esports.xml");
			
			LigaEsports lig = (LigaEsports) unmarshaller.unmarshal(archivo);
			
			liga = lig;
		} catch (JAXBException e) {
			e.printStackTrace();
		}
		
		return liga;
	}
	
	private static void guardarXml(LigaEsports liga) {
		try {
			JAXBContext context = JAXBContext.newInstance(LigaEsports.class);
			Marshaller marshaller = context.createMarshaller();
			
			// Para que el XML salga ordenado y con sangrías (bonito)
			marshaller.setProperty(Marshaller.JAXB_FORMATTED_OUTPUT, true);
			
			// Ruta de escritura (Puede ser la misma para sobrescribir o una nueva)
			File archivo = new File("C:\\Users\\plaza\\Desktop\\DATOS\\esports.xml");
			
			marshaller.marshal(liga, archivo);
			
			System.out.println("--> Cambios guardados correctamente en el XML.");
			
		} catch (JAXBException e) {
			System.out.println("Error al guardar el XML.");
			e.printStackTrace();
		}
	}
}
