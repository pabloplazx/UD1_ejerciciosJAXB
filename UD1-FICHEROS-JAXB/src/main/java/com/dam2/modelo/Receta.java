package com.dam2.modelo;

import java.util.ArrayList;
import java.util.LinkedList;
import java.util.List;

import jakarta.xml.bind.annotation.XmlAttribute;
import jakarta.xml.bind.annotation.XmlElement;
import jakarta.xml.bind.annotation.XmlElementWrapper;
import jakarta.xml.bind.annotation.XmlType;


@XmlType(propOrder = {"nombre", "vegetariana", "ingredientes", "infoNutricional"})
public class Receta {
	
	String dificultad;
	String nombre;
	List<Ingrediente> ingredientes = new LinkedList<>();
	InfoNutricional infoNutricional;
	boolean vegetariana;
	
	@XmlAttribute
	public String getDificultad() {
		return dificultad;
	}
	public void setDificultad(String dificultad) {
		this.dificultad = dificultad;
	}
	
	@XmlElement
	public String getNombre() {
		return nombre;
	}
	public void setNombre(String nombre) {
		this.nombre = nombre;
	}
	
	@XmlElementWrapper(name = "ingredientes")
	@XmlElement(name = "ingrediente")
	public List<Ingrediente> getIngredientes() {
		return ingredientes;
	}
	public void setIngredientes(List<Ingrediente> ingredientes) {
		this.ingredientes = ingredientes;
	}
	
	@XmlElement
	public InfoNutricional getInfoNutricional() {
		return infoNutricional;
	}
	public void setInfoNutricional(InfoNutricional infoNutricional) {
		this.infoNutricional = infoNutricional;
	}
	
	@XmlElement
	public boolean isVegetariana() {
		return vegetariana;
	}
	public void setVegetariana(boolean vegetariana) {
		this.vegetariana = vegetariana;
	}
	
	

}
