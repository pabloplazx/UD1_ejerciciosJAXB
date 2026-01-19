package principal;

import consola.Leer;
import logica.GestionInstituto;
import logica.Instituto;

public class Principal {

	public static void main(String[] args) {
		
		System.out.println("Gestion y metodos sobre un instituto");
		
		// Variable principal fuera del bucle
		Instituto insti = new Instituto();
		
		int op = 0;
		
		do {
			GestionInstituto.mostrarMenu();
			System.out.print("Introduzca opcion: ");
			op = Leer.entero();
			
			switch (op) {
			case 1:
				// ASIGNACIÓN CRÍTICA: insti = método()
				Instituto temp = GestionInstituto.cargarXml();
				if(temp != null) {
					insti = temp; 
					System.out.println("¡XML cargado con éxito! Instituto: " + insti.getNombre());
				}
				break;
			case 2:
				System.out.print("Introduzca ID del CURSO (ej: 1A): "); // Ojo: Pide ID curso, no alumno
				String idCurso = Leer.linea();
				GestionInstituto.listarAlumnos(insti, idCurso);
				break;
			case 3:
				System.out.print("Introduzca DNI del alumno: ");
				String dniExpediente = Leer.linea();
				GestionInstituto.boletinAlumno(insti, dniExpediente);
				break;
			case 4:
				System.out.print("Introduzca DNI del alumno: ");
				String dniMedia = Leer.linea();
				GestionInstituto.notaMediaAlumno(insti, dniMedia);
				break;
			case 5:
				GestionInstituto.alumnoMasJoven(insti);
				break;
			case 6:
				System.out.println("Saliendo...");
				break;
			default:
				System.out.println("Opcion no valida");
			}
		} while (op != 6);
	}
}