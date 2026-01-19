package principal;

import java.util.ArrayList;
import java.util.List;
import java.io.File;

import consola.Leer;
import jakarta.xml.bind.JAXBContext;
import jakarta.xml.bind.JAXBException;
import jakarta.xml.bind.Marshaller;
import jakarta.xml.bind.Unmarshaller;
import logica.Biblioteca;
import logica.Libro;
import logica.Precio;


public class Main {

	public static void main(String[] args) {
	
		añadirValores();
		
		
		System.out.println("Ahora leemos valores");
		leerValores();
		

	}
	
	private static void añadirValores() {
		
		List<Libro> libros = new ArrayList<>();
		Biblioteca biblioteca = new Biblioteca();

		Precio precio1 = new Precio();
		precio1.setCantidad(15.5);
		precio1.setMoneda("EUR");
		
		Libro libro1 = new Libro();
		libro1.setIsbn("978-123456");
		libro1.setTitulo("El quijote");
		libro1.setAutor("Miguel de Cervantes");
		libro1.setPrecio(precio1);
		libro1.setPublicado(true);
		
		Precio precio2 = new Precio();
		precio2.setCantidad(30.0);
		precio2.setMoneda("USD");
		
		Libro libro2 = new Libro();
		libro2.setIsbn("978-987654");
		libro2.setTitulo("Clean Code");
		libro2.setAutor("Robert C. Martin");
		libro2.setPrecio(precio2);
		libro2.setPublicado(true);
		
		libros.add(libro1);
		libros.add(libro2);
		
		biblioteca.setNombre("Biblioteca general");
		biblioteca.setLibros(libros);
		biblioteca.setId("LIB-2024");
		
		
		try {
			JAXBContext context 
				= JAXBContext.newInstance(Biblioteca.class);
			Marshaller marshall = context.createMarshaller();
			
			marshall.setProperty(Marshaller.JAXB_FORMATTED_OUTPUT, true);
			marshall.marshal(biblioteca, new File("C:\\Users\\plaza\\Desktop\\datos\\biblioteca.xml"));
			
		} catch (JAXBException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
	}
	
	private static void leerValores() {
		try {
            JAXBContext context = JAXBContext.newInstance(Biblioteca.class);
            Unmarshaller unmarshaller = context.createUnmarshaller();
            
            // Leemos el fichero y lo convertimos a Objeto
            Biblioteca biblioLeida = (Biblioteca) unmarshaller.unmarshal(new File("C:\\Users\\plaza\\Desktop\\datos\\biblioteca.xml"));
            
            // Comprobamos
            System.out.println("ID Biblioteca: " + biblioLeida.getId());
            System.out.println("Nombre: " + biblioLeida.getNombre());
            
            for(Libro l : biblioLeida.getLibros()) {
                System.out.println("Libro: " + l.getTitulo() + " | Precio: " + l.getPrecio().getCantidad() + " " + l.getPrecio().getMoneda());
            }
            
        } catch (Exception e) {
            e.printStackTrace();
        }
	}
}
