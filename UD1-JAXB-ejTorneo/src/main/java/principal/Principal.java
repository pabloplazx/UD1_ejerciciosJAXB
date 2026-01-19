package principal;

import java.util.ArrayList;
import java.util.List;
import java.io.File;

import jakarta.xml.bind.JAXBContext;
import jakarta.xml.bind.JAXBException;
import jakarta.xml.bind.Marshaller;
import logica.Entrenador;
import logica.Equipo;
import logica.Monstruo;
import logica.Torneo;

public class Principal {

	public static void main(String[] args) {
		añadirValores();
	}
	
	private static void añadirValores() {
		Torneo torneo = new Torneo();
		
		List<Entrenador> entrenadores = new ArrayList<>();
		
		Entrenador entrenador1 = new Entrenador();
		
		Equipo equipo1 = new Equipo();
		
		List<Monstruo> monstruosEntrenador1 = new ArrayList<>();
		
		Monstruo monstruo1 = new Monstruo();
		monstruo1.setNivel(50);
		monstruo1.setNombre("Pikachu");
		
		Monstruo monstruo2 = new Monstruo();
		monstruo2.setNivel(55);
		monstruo2.setNombre("Charizard");
		
		monstruosEntrenador1.add(monstruo1);
		monstruosEntrenador1.add(monstruo2);
		
		equipo1.setMonstruos(monstruosEntrenador1);
		
		entrenador1.setIdLicencia("A-123");
		entrenador1.setNombre("Ash");
		entrenador1.setCiudad("Pueblo Paleta");
		entrenador1.setEquipo(equipo1);
		

		
		Entrenador entrenador2 = new Entrenador();
		
		Equipo equipo2 = new Equipo();
		
		List<Monstruo> monstruosEntrenador2 = new ArrayList<>();
		
		Monstruo monstruo3 = new Monstruo();
		monstruo3.setNivel(20);
		monstruo3.setNombre("Staryu");
		
		monstruosEntrenador2.add(monstruo3);
		
		equipo2.setMonstruos(monstruosEntrenador2);
		
		entrenador2.setIdLicencia("B-999");
		entrenador2.setNombre("Misty");
		entrenador2.setCiudad("Celeste");
		entrenador2.setEquipo(equipo2);
		
		entrenadores.add(entrenador1);
		entrenadores.add(entrenador2);
		
		torneo.setEntrenadores(entrenadores);
		
		try {
			JAXBContext context 
				= JAXBContext.newInstance(Torneo.class);
			Marshaller marshall = context.createMarshaller();
			
			marshall.setProperty(Marshaller.JAXB_FORMATTED_OUTPUT, true);
			marshall.marshal(torneo, new File("C:\\Users\\plaza\\Desktop\\datos\\torneo.xml"));
			
		} catch (JAXBException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		
		
	}
}
