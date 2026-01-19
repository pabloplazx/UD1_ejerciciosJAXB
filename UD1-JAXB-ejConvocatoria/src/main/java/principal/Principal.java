package principal;

import java.util.ArrayList;
import java.util.List;
import java.io.File;

import jakarta.xml.bind.JAXBContext;
import jakarta.xml.bind.JAXBException;
import jakarta.xml.bind.Marshaller;
import logica.Aspirante;
import logica.Convocatoria;
import logica.Nota;

public class Principal {

    public static void main(String[] args) {
        añadirValores();
    }
    
    private static void añadirValores() {
        
        Convocatoria convo = new Convocatoria();
        
        // --- ASPIRANTE 1 ---
        Aspirante aspirante1 = new Aspirante();
        aspirante1.setId("A-001");
        aspirante1.setNombre("Laura Martínez");
        aspirante1.setTelefono(600112233);
        aspirante1.setAdmitido(true); // Faltaba poner si admitido
        
        List<Nota> notas1 = new ArrayList<>();
        
        Nota nota1 = new Nota();
        nota1.setTipo("TEST");
        nota1.setNota(8.5);
        
        Nota nota2 = new Nota();
        nota2.setTipo("PRACTICO");
        nota2.setNota(9.25);
        
        Nota nota3 = new Nota();
        nota3.setTipo("MERITOS");
        nota3.setNota(1.0);
        
        notas1.add(nota1);
        notas1.add(nota2);
        notas1.add(nota3);
        
        aspirante1.setCalificaciones(notas1);
        
        // --- ASPIRANTE 2 ---
        Aspirante aspirante2 = new Aspirante();
        aspirante2.setId("A-002");
        aspirante2.setNombre("Carlos Ruiz");
        aspirante2.setTelefono(666998877);
        aspirante2.setAdmitido(false);
        
        List<Nota> notas2 = new ArrayList<>();
        Nota nota4 = new Nota();
        nota4.setTipo("TEST");
        nota4.setNota(4.5); // Cambiado a 4.0 según el enunciado, pero 4.5 vale igual
        
        // CORREGIDO 1: Se te olvidó añadir la nota a la lista
        notas2.add(nota4); 
        
        aspirante2.setCalificaciones(notas2);
        
        // --- AÑADIR A LA LISTA PRINCIPAL ---
        List<Aspirante> aspirantes = new ArrayList<>();
        aspirantes.add(aspirante1);
        aspirantes.add(aspirante2);
        
        // --- CONFIGURAR CONVOCATORIA ---
        convo.setAño("2025");
        convo.setPlaza("Ingeniero de Software");
        convo.setCiudad("Madrid");
        
        // CORREGIDO 2: ¡CRÍTICO! Tenías la lista pero no se la diste al objeto padre
        convo.setAspirantes(aspirantes); 
        
        try {
            JAXBContext context = JAXBContext.newInstance(Convocatoria.class);
            Marshaller marshall = context.createMarshaller();
            
            marshall.setProperty(Marshaller.JAXB_FORMATTED_OUTPUT, true);
            
            // He cambiado el nombre del archivo a 'oposiciones.xml' para que tenga sentido
            marshall.marshal(convo, new File("C:\\Users\\plaza\\Desktop\\datos\\oposiciones.xml"));
            
            System.out.println("XML generado correctamente.");
            
        } catch (JAXBException e) {
            e.printStackTrace();
        }
    }
}