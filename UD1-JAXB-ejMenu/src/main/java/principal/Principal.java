package principal;

import java.io.File;

import consola.Leer;
import jakarta.xml.bind.JAXBContext;
import jakarta.xml.bind.JAXBException;
import logica.Menu;
import logica.Plato;

public class Principal {
	
	public static void main(String[] args) {
		
		System.out.println("--GESTION DE UN MENU DE UN RESTAURANTE--");
		
		int op = 0;
		Menu menu = new Menu();
		do {
			mostrarMenu();
			
			System.out.print("Introduzca opcion: ");
			op = Leer.entero();
			
			switch (op) {
			case 1:
				menu = leerDatos();
				break;
			case 2:
				mostrarDatos(menu);
				break;
			case 3:
				mostrarPlatos(menu);
				break;
			case 4:
				System.out.println("La suma total es: "+sumaTotal(menu));
				break;
			case 5:
				System.out.println("Saliendo...");
				break;
			default:
				System.out.println("Opcion no valida, intentelo de nuevo");
			}
		} while(op != 5);
	}
	
	private static void mostrarMenu() {
		System.out.println("1. Leer datos");
		System.out.println("2. Mostrar nombre del restaurante");
		System.out.println("3. Muestre los platos del menu");
		System.out.println("4. Calcula y muestra la suma total del precio de los platos");
		System.out.println("5. Salir");
	}
	
	public static Menu leerDatos() {
		
		Menu datosMenu = new Menu();
		try {
			JAXBContext context = JAXBContext.newInstance(Menu.class);
			
			jakarta.xml.bind.Unmarshaller unmarshaller = context.createUnmarshaller();
			
			File archivo = new File("C:\\Users\\plaza\\Desktop\\datos\\menu.xml");
			
			Menu menu = (Menu) unmarshaller.unmarshal(archivo);
			
			datosMenu = menu;
		} catch (JAXBException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		return datosMenu;
		
	}
	
	private static void mostrarDatos(Menu menu) {
		System.out.println("Nombre restaurante: "+menu.getNombreRestaurante());
		System.out.println("¿Esta abierto?: "+menu.isAbierto());
	}
	
	private static void mostrarPlatos(Menu menu) {
		int numeroPlato = 1;
		for (Plato plato : menu.getPlatos()) {
			System.out.println("Plato "+numeroPlato);
			System.out.println("Id: "+plato.getId());
			System.out.println("Nombre: "+plato.getNombre());
			System.out.println("Precio: "+plato.getPrecios());
			System.out.println("Calorias: "+plato.getCalorias());
			
			for (String ingrediente : plato.getIngredients()) {
				System.out.println("Ingrediente: "+ingrediente);
			}
			
			numeroPlato++;
		}
	}
	
	private static double sumaTotal(Menu menu) {
		
		double sumaTotal = 0;
		
		for (Plato plato : menu.getPlatos()) {
			sumaTotal += plato.getPrecios();
		}
		
		return sumaTotal;
	}
	
	

}
