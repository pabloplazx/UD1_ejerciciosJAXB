package principal;

import java.util.ArrayList;
import java.util.List;
import java.io.File;

import jakarta.xml.bind.JAXBContext;
import jakarta.xml.bind.JAXBException;
import jakarta.xml.bind.Marshaller;
import logica.Departamento;
import logica.Equipo;
import logica.Programador;

public class Principal {

	public static void main(String[] args) {
		
		añadirValores();
		
	}
	
	private static void añadirValores() {
		Departamento departamento = new Departamento();
		
		Equipo equipo = new Equipo();
		
		List<Programador> programadores = new ArrayList<>();
		
		Programador programador1 = new Programador();
		List<String> lenguajesProgamador1 = new ArrayList<>();
		
		lenguajesProgamador1.add("Java");
		lenguajesProgamador1.add("Python");
		
		programador1.setId("1");
		programador1.setAlias("Neo");
		programador1.setNivel("SENIOR");
		programador1.setLenguajes(lenguajesProgamador1);
		
		Programador programador2 = new Programador();
		List<String> lenguajesProgramador2 = new ArrayList<>();
		
		lenguajesProgramador2.add("C++");
		
		programador2.setId("2");
		programador2.setAlias("Trinity");
		programador2.setNivel("JUNIOR");
		programador2.setLenguajes(lenguajesProgramador2);
		
		programadores.add(programador1);
		programadores.add(programador2);
		
		equipo.setProgramadores(programadores);
		equipo.setModo("remoto");
		
		departamento.setCodigo("DEP-99");
		departamento.setSede("Madrid");
		departamento.setEquipo(equipo);
		
		try {
			JAXBContext context 
				= JAXBContext.newInstance(Departamento.class);
			Marshaller marshall = context.createMarshaller();
			
			marshall.setProperty(Marshaller.JAXB_FORMATTED_OUTPUT, true);
			marshall.marshal(departamento, new File("C:\\Users\\plaza\\Desktop\\datos\\departamento.xml"));
			
		} catch (JAXBException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		
		
	
	}
}


