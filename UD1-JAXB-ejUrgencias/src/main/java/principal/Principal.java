package principal;

import java.io.File;

import consola.Leer;
import jakarta.xml.bind.JAXBContext;
import jakarta.xml.bind.JAXBException;
import logica.GestionUrgencias;
import logica.Urgencias;

public class Principal {

	public static void main(String[] args) {
		System.out.println("Base de datos de un hospital de urgencias");
		
		Urgencias urgencias = new Urgencias();
		GestionUrgencias gestion = new GestionUrgencias();
		int op = 0;
		
		do {
			mostrarMenu();
			System.out.print("Introduzca opcion: ");
			op = Leer.entero();
			
			switch (op) {
			case 1:
				urgencias = cargarXml();
				break;
			case 2:
				System.out.print("Introudzca gravedad: ");
				String gravedad = Leer.linea();
				
				GestionUrgencias.listarPacientesGravedad(urgencias, gravedad);
				break;
			case 3:
				System.out.print("Introduzca especialidad: ");
				String especialidad = Leer.linea();
				
				GestionUrgencias.buscarMedico(urgencias, especialidad);
				break;
			case 4:
				System.out.println("La media de edad de los pacientes es: "+GestionUrgencias.calcularEdadMedia(urgencias));
				break;
			case 5:
				System.out.print("Introduzca el SIP del paciente: ");
				String sipPaciente = Leer.linea();
				
				GestionUrgencias.buscarPaciente(urgencias, sipPaciente);
				break;
			case 6:
				System.out.println("Saliendo...");
				break;
			default:
				System.out.println("Opcion no valida");
			}
		} while (op != 6);
	}
	
	private static void mostrarMenu() {
		System.out.println("1. Leer datos del xml");
		System.out.println("2. Listar los diferentes pacientes por gravedad");
		System.out.println("3. Buscar un medico por especialidad");
		System.out.println("4. Calcular la edad media de los diferentes pacientes");
		System.out.println("5. Buscar un paciente mediante el SIP");
		System.out.println("6. SALIR");
	}
	
	private static Urgencias cargarXml() {
		Urgencias urgencias = new Urgencias();
		try {
			JAXBContext context = JAXBContext.newInstance(Urgencias.class);
			
			jakarta.xml.bind.Unmarshaller unmarshaller = context.createUnmarshaller();
			
			File archivo = new File("C:\\Users\\plaza\\Desktop\\datos\\urgencias.xml");
			
			Urgencias urg = (Urgencias) unmarshaller.unmarshal(archivo);
			
			urgencias = urg;
		} catch (JAXBException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		return urgencias;
	}
}
