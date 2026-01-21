package principal;

import java.io.File;

import consola.Leer;
import jakarta.xml.bind.JAXBContext;
import jakarta.xml.bind.JAXBException;
import logica.Bestiario;
import logica.GestionBestiario;

public class Principal {
	
	public static void main(String[] args) {
		
		Bestiario bestiario = cargarXml();
		
		GestionBestiario gestion = new GestionBestiario();
		
		int op = 0;
		
		do {
			mostrarMenu();
			System.out.print("Introduzca opcion: ");
			op = Leer.datoInt();
			
			switch (op) {
			case 1:
				for (String nombre : gestion.obtenerNombresCriaturasHostiles(bestiario)) {
					System.out.println(nombre);
				}
				break;
			case 2:
				System.out.println("Introduzca elemento de debilidad: ");
				String elementoDebilidad = Leer.dato();
				
				System.out.println(gestion.buscarCriaturaDebilidad(bestiario, elementoDebilidad));;
				break;
			case 3:
				System.out.println("Items posibles: "+gestion.contarItemsPosibles(bestiario));;
				break;
			case 4:
				System.out.println("Criatura: "+gestion.obtenerCriaturaFragil(bestiario));
				break;
			case 5:
				System.out.println("Saliendo...");
				break;
			default:
				System.out.println("Opcio no valida");
				
			}
		} while (op != 5);
	}
	
	private static Bestiario cargarXml() {
		Bestiario bestiario = new Bestiario();
		
		try {
			JAXBContext context = JAXBContext.newInstance(Bestiario.class);
			
			jakarta.xml.bind.Unmarshaller unmarshaller = context.createUnmarshaller();
			
			File archivo = new File("C:\\Users\\plaza\\Desktop\\DATOS\\bestiario.xml");
			
			Bestiario fest = (Bestiario) unmarshaller.unmarshal(archivo);
			
			bestiario = fest;
		} catch (JAXBException e) {
			e.printStackTrace();
		}
		
		return bestiario;
	}
	
	private static void mostrarMenu() {
		System.out.println("1. Obtener nombres de las criaturas hostiles");
		System.out.println("2. Buscar criaturas por debilidad");
		System.out.println("3. Contar Total de items posibles");
		System.out.println("4. Obtener criatura mas flagil");
		System.out.println("5. SALIR");
	}
}
