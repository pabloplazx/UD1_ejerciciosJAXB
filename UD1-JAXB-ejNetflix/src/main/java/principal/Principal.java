package principal;

import java.util.ArrayList;
import java.util.List;

import java.io.File;

import jakarta.xml.bind.JAXBContext;
import jakarta.xml.bind.JAXBException;
import jakarta.xml.bind.Marshaller;
import logica.Capitulo;
import logica.Netflix;
import logica.Serie;
import logica.Temporada;

public class Principal {

	public static void main(String[] args) {
		cargarValores();
	}
	
	private static void cargarValores() {
		Netflix netflix = new Netflix();
		
		List<Serie> series = new ArrayList<>();
		
		Serie serie = new Serie();
		
		List<Temporada> temporadas = new ArrayList<>();
		
		Temporada temporada1 = new Temporada();
		
		List<Capitulo> capitulosTemp1 = new ArrayList<>();
		
		Capitulo cap1 = new Capitulo();
		cap1.setMinutos(45);
		cap1.setNombre("La desaparicion de Will");
		
		Capitulo cap2 = new Capitulo();
		cap2.setMinutos(50);
		cap2.setNombre("La loca de la calle Maple");
		
		capitulosTemp1.add(cap1);
		capitulosTemp1.add(cap2);
		
		temporada1.setNumero(1);
		temporada1.setCapitulos(capitulosTemp1);
		
		Temporada temporada2 = new Temporada();
		
		List<Capitulo> capitulosTemp2 = new ArrayList<>();
		
		Capitulo cap3 = new Capitulo();
		cap3.setMinutos(55);
		cap3.setNombre("MADMAX");
		
		capitulosTemp2.add(cap3);
		
		temporada2.setNumero(2);
		temporada2.setCapitulos(capitulosTemp2);
		
		temporadas.add(temporada1);
		temporadas.add(temporada2);
		
		serie.setTitulo("Stranger Things");
		serie.setGenero("Sci-fi");
		serie.setTemporadas(temporadas);
		
		series.add(serie);
		
		netflix.setEmpresa("Netflix España");
		netflix.setSeries(series);
		
		try {
			JAXBContext context 
				= JAXBContext.newInstance(Netflix.class);
			Marshaller marshall = context.createMarshaller();
			
			marshall.setProperty(Marshaller.JAXB_FORMATTED_OUTPUT, true);
			marshall.marshal(netflix, new File("C:\\Users\\plaza\\Desktop\\DATOS\\netflix.xml"));
		} catch (JAXBException e) {
			e.printStackTrace();
		}
		
	}
}
