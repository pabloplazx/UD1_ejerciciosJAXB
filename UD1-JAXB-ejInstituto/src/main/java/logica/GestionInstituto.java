package logica;

import java.io.File;
import jakarta.xml.bind.JAXBContext;
import jakarta.xml.bind.JAXBException;
import jakarta.xml.bind.Unmarshaller;

public class GestionInstituto {
	
	public static Instituto cargarXml() {
		Instituto insti = null;
		try {
			JAXBContext context = JAXBContext.newInstance(Instituto.class);
			Unmarshaller unmarshaller = context.createUnmarshaller();
			
			// Asegúrate de que esta ruta ES CORRECTA en tu ordenador
			File archivo = new File("C:\\Users\\plaza\\Desktop\\DATOS\\instituto.xml");
			
			if (archivo.exists()) {
				insti = (Instituto) unmarshaller.unmarshal(archivo);
			} else {
				System.err.println("ERROR: El archivo no existe en: " + archivo.getAbsolutePath());
			}
			
		} catch (JAXBException e) {
			e.printStackTrace();
		}
		return insti;
	}
	
	public static void mostrarMenu() {
		System.out.println("\n--- MENU INSTITUTO ---");
		System.out.println("1. Cargar el xml");
		System.out.println("2. Listar los alumnos de un curso (por ID del curso)");
		System.out.println("3. Mostrar expediente del alumno (por DNI)");
		System.out.println("4. Calcular nota media de un alumno ");
		System.out.println("5. Alumno mas joven");
		System.out.println("6. SALIR");
	}
	
	public static void listarAlumnos(Instituto i, String idCurso) {
		if (i == null) {
			System.out.println("AVISO: Datos no cargados. Usa la opción 1 primero.");
			return;
		}
		
		boolean encontrado = false;
		for (Curso curso : i.getCursos()) {
			// Comparamos ignorando mayúsculas/minúsculas
			if (curso.getId().equalsIgnoreCase(idCurso)) {
				encontrado = true;
				System.out.println("--- Alumnos del curso " + curso.getId() + " ---");
				for (Alumno alumno : curso.getAlumnos()) {
					System.out.println("Nombre: " + alumno.getNombre() + " | DNI: " + alumno.getDni());
				}
				break; 
			}
		}
		
		if (!encontrado) {
			System.out.println("No se ha encontrado ningún curso con el ID: " + idCurso);
		}
	}
	
	public static void boletinAlumno(Instituto i, String dniAlumno) {
		if (i == null) {
			System.out.println("AVISO: Datos no cargados.");
			return;
		}

		boolean encontrado = false;
		
		// Etiqueta para salir de ambos bucles cuando encontremos al alumno
		searchLoop:
		for (Curso curso : i.getCursos()) {
			for (Alumno alumno : curso.getAlumnos()) {
				if (alumno.getDni().equalsIgnoreCase(dniAlumno)) {
					
					System.out.println("--- Boletín de " + alumno.getNombre() + " ---");
					for (Nota nota : alumno.getNotas()) {
						System.out.println(nota);
					}
					encontrado = true;
					break searchLoop; // Salimos de ambos bucles
				}
			}
		}
		
		if (!encontrado) {
			System.out.println("No se ha encontrado el alumno con DNI: " + dniAlumno);
		}
	}
	
	public static void notaMediaAlumno(Instituto i, String dniAlumno) {
	    if (i == null) {
	        System.out.println("ERROR: El objeto Instituto es NULL. ¿Has pulsado la opción 1?");
	        return;
	    }
	    
	    // --- ZONA DE DEBUG (CHIVATOS) ---
	    System.out.println("--- INICIO DEBUG ---");
	    System.out.println("Buscando DNI: [" + dniAlumno + "]");
	    System.out.println("Cursos cargados: " + i.getCursos().size());
	    
	    for (Curso c : i.getCursos()) {
	        System.out.println(" -> Curso ID: " + c.getId() + " tiene " + c.getAlumnos().size() + " alumnos.");
	        for (Alumno a : c.getAlumnos()) {
	            System.out.println("    -> Alumno encontrado: Nombre=" + a.getNombre() + ", DNI=[" + a.getDni() + "]");
	        }
	    }
	    System.out.println("--- FIN DEBUG ---");
	    // --------------------------------
	    
	    boolean encontrado = false;
	    double sumaTotal = 0;
	    int numeroNotas = 0;
	    String nombreAlumno = "";
	    
	    searchLoop:
	    for (Curso curso : i.getCursos()) {
	        for (Alumno alumno : curso.getAlumnos()) {
	            // Usamos trim() para quitar espacios en blanco invisibles
	            if (alumno.getDni() != null && alumno.getDni().trim().equalsIgnoreCase(dniAlumno.trim())) {
	                encontrado = true;
	                nombreAlumno = alumno.getNombre();
	                for (Nota nota : alumno.getNotas()) {
	                    sumaTotal += nota.getNota();
	                    numeroNotas++;
	                }
	                break searchLoop; 
	            }
	        }
	    }
	    
	    if (!encontrado) {
	        System.out.println("RESULTADO: Alumno no encontrado con ese DNI.");
	    } else {
	        if (numeroNotas > 0) {
	            double media = sumaTotal / numeroNotas;
	            System.out.printf("La media de %s es = %.2f\n", nombreAlumno, media);
	        } else {
	            System.out.println("El alumno " + nombreAlumno + " no tiene notas registradas.");
	        }
	    }
	}
	public static void alumnoMasJoven(Instituto i) {
		if (i == null) {
			System.out.println("AVISO: Datos no cargados. Usa la opción 1 primero.");
			return;
		}

		int edadJoven = Integer.MAX_VALUE;
		String nombreAlumnoJoven = "";
		boolean hayAlumnos = false;
		
		for (Curso curso : i.getCursos()) {
			for (Alumno alumno : curso.getAlumnos()) {
				hayAlumnos = true;
				if (alumno.getEdad() < edadJoven) {
					edadJoven = alumno.getEdad();
					nombreAlumnoJoven = alumno.getNombre();
				}
			}
		}
		
		if (hayAlumnos) {
			System.out.println("El alumno más joven es: " + nombreAlumnoJoven + " (" + edadJoven + " años).");
		} else {
			System.out.println("No hay alumnos en el instituto.");
		}
	}
}