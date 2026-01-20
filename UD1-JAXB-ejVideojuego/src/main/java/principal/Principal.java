package principal;

import java.util.ArrayList;
import java.util.Date;
import java.util.GregorianCalendar;
import java.util.List;

import java.io.File;

import jakarta.xml.bind.JAXBContext;
import jakarta.xml.bind.JAXBException;
import jakarta.xml.bind.Marshaller;
import logica.Estadisticas;
import logica.Item;
import logica.Jugador;
import logica.Mochila;
import logica.PartidaGuardada;

public class Principal {

	public static void main(String[] args) {
		cargarValores();
	}
	
	private static void cargarValores() {
		PartidaGuardada partida = new PartidaGuardada();
		Jugador jugador = new Jugador();
		
		Estadisticas est = new Estadisticas();
		est.setVitalidad(100);
		est.setFuerza(85);
		est.setMagia(10);
		
		Mochila mochila = new Mochila();
		
		
		List<Item> items = new ArrayList<>();
		Item i1 = new Item();
		
		i1.setEquipado(true);
		i1.setNombre("Hacha de guerra");
		i1.setPeso(5.5);
		
		Item i2 = new Item();
		i2.setEquipado(false);
		i2.setNombre("Pocion de vida");
		i2.setPeso(0.5);
		
		Item i3 = new Item();
		i3.setEquipado(false);
		i3.setNombre("Mapa antiguo");
		i3.setPeso(0.1);
		
		items.add(i1);
		items.add(i2);
		items.add(i3);
		
		mochila.setCapacidadMaxima(50);
		mochila.setItems(items);
		
		jugador.setClase("Guerrero");
		jugador.setNivel(15);
		jugador.setAlias("Thorin");
		jugador.setOro(1500.5);
		jugador.setMochila(mochila);
		
		Date fecha = new GregorianCalendar(2025, 0, 20).getTime();
		partida.setFecha(fecha);
		
		List<Jugador> jugadores = new ArrayList<>();
		jugadores.add(jugador);
		
		partida.setJugadores(jugadores);
		
		try {
			JAXBContext context 
				= JAXBContext.newInstance(PartidaGuardada.class);
			Marshaller marshall = context.createMarshaller();
			
			marshall.setProperty(Marshaller.JAXB_FORMATTED_OUTPUT, true);
			marshall.marshal(partida, new File("C:\\Users\\plaza\\Desktop\\DATOS\\partida.xml"));
			
		} catch (JAXBException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		
	}
}
