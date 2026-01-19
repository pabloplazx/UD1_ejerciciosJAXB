package com.dam2.main;

import java.util.ArrayList;
import java.util.List;
import java.io.File;

import com.dam2.modelo.InfoNutricional;
import com.dam2.modelo.Ingrediente;
import com.dam2.modelo.Receta;
import com.dam2.modelo.Recetario;

import jakarta.xml.bind.JAXBContext;
import jakarta.xml.bind.JAXBException;
import jakarta.xml.bind.Marshaller;

public class Main {

	public static void main(String[] args) {

		pruebaAnotaciones();

	}
	
	static void pruebaAnotaciones() {
		
		Ingrediente ing = new Ingrediente();
		ing.setCantidad(3.5);
		ing.setId("1");
		ing.setNombre("Azúcar");
		ing.setUnidad("litro");
		
		Ingrediente ing2 = new Ingrediente();
		ing2.setCantidad(3.5);
		ing2.setId("2");
		ing2.setNombre("Leche");
		ing2.setUnidad("gramo");
		
		Receta r1 = new Receta();
		r1.getIngredientes().add(ing2);
		r1.getIngredientes().add(ing);
		
		r1.setVegetariana(true);
		r1.setDificultad("media");
		r1.setNombre("bollo");
		
		InfoNutricional in = new InfoNutricional();
		in.setCalorias(1000);
		in.setProteinas(300.5);
		
		r1.setInfoNutricional(in);
		
		Recetario recet = new Recetario();
		recet.setAutor("raquel");
		List<Receta> recetas = new ArrayList<>();
		recetas.add(r1);
		recet.setRecetas(recetas);
		
		try {
			JAXBContext context 
				= JAXBContext.newInstance(Recetario.class);
			Marshaller marshall = context.createMarshaller();
			
			marshall.setProperty(Marshaller.JAXB_FORMATTED_OUTPUT, true);
			marshall.marshal(recet, new File("C:\\Users\\plaza\\Desktop\\datos\\recetario.xml"));
			
		} catch (JAXBException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		
		
		
	}

}
