package principal;

import java.util.ArrayList;
import java.util.List;

import java.io.File;

import jakarta.xml.bind.JAXBContext;
import jakarta.xml.bind.JAXBException;
import jakarta.xml.bind.Marshaller;
import logica.Arma;
import logica.GuaridaSecreta;
import logica.Villano;

public class Principal {

	public static void main(String[] args) {
		cargarValores();
	}
	
	private static void cargarValores() {
		GuaridaSecreta guarida = new GuaridaSecreta();
		
		guarida.setId("VOLCAN-01");
		guarida.setUbicacion("Isla Calavera");
		
		Villano villano = new Villano();
		villano.setAlias("Dr. Doom");
		villano.setNombre("Victor");
		villano.setNivel(9000);
		
		List<Arma> armas = new ArrayList<>();
		Arma arma1 = new Arma();
		arma1.setTipo("Laser");
		arma1.setPotencia("Mega");
		arma1.setNombre("Rayo de la Muerte");
		
		Arma arma2 = new Arma();
		arma2.setTipo("Explosivo");
		arma2.setPotencia("Alta");
		arma2.setNombre("Bomba de antimateria");
		
		Arma arma3 = new Arma();
		arma3.setTipo("Biologico");
		arma3.setPotencia("Alta");
		arma3.setNombre("Virus T");
		
		armas.add(arma1);
		armas.add(arma2);
		armas.add(arma3);
		
		guarida.setArmas(armas);
		guarida.setId("VOLCAN-01");
		guarida.setUbicacion("Isla Calavera");
		guarida.setVillano(villano);
		guarida.setPlanMaestro("Conquistar el mundo el martes");
		
		try {
			JAXBContext context 
				= JAXBContext.newInstance(GuaridaSecreta.class);
			Marshaller marshall = context.createMarshaller();
			
			marshall.setProperty(Marshaller.JAXB_FORMATTED_OUTPUT, true);
			marshall.marshal(guarida, new File("C:\\Users\\plaza\\Desktop\\DATOS\\guarida.xml"));
			
		} catch (JAXBException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		
	}
}
