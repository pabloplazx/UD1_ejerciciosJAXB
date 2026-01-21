package logica;

import java.util.ArrayList;
import java.util.List;

public class GestionBestiario {

	public List<String> obtenerNombresCriaturasHostiles(Bestiario bestiario) {
		List<String> nombresCriaturas = new ArrayList<>();
		
		for (Criatura criatura : bestiario.getCriaturas()) {
			if (criatura.isHostil()) {
				nombresCriaturas.add(criatura.getNombre());
			}
		}
		
		if (nombresCriaturas.isEmpty()) {
			System.out.println("No hay ninguna criatura hostil");
		} 
		
		return nombresCriaturas;
	}
	
	public String buscarCriaturaDebilidad(Bestiario bestiario, String elementoDebilidad) {
		String criaturaDebil = "";
		for (Criatura criatura : bestiario.getCriaturas()) {
			Debilidad debilidad = criatura.getDebilidad();
			
			if (debilidad.getNombre().equalsIgnoreCase(elementoDebilidad)) {
				criaturaDebil = criatura.getNombre();
			}
		}
		
		return criaturaDebil;
	}
	
	public int contarItemsPosibles(Bestiario bestiario) {
		int contItems = 0;
		
		for (Criatura criatura : bestiario.getCriaturas()) {
			if (criatura.getItems().isEmpty()) {
		
				break;
			} else {
				contItems += criatura.getItems().size();
			}
		}
		
		return contItems;
	}
	
	public String obtenerCriaturaFragil(Bestiario bestiario) {
		
		String nombreCriatura = "";
		
		double multiplicador = Double.MIN_VALUE;
		
		for (Criatura criatura : bestiario.getCriaturas()) {
			Debilidad debilidad = criatura.getDebilidad();
			
			if (debilidad.getMultiplicador() > multiplicador) {
				multiplicador = debilidad.getMultiplicador();
			}
		}
		
		for (Criatura criatura : bestiario.getCriaturas()) {
			Debilidad debilidad = criatura.getDebilidad();
			
			if (debilidad.getMultiplicador() == multiplicador) {
				nombreCriatura = criatura.getNombre();
			}
		}
		
		return nombreCriatura;
	}
}
