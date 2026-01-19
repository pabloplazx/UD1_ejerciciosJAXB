package logica;

import java.util.ArrayList;
import java.util.List;

import jakarta.xml.bind.annotation.XmlAttribute;
import jakarta.xml.bind.annotation.XmlElement;
import jakarta.xml.bind.annotation.XmlElementWrapper;
import jakarta.xml.bind.annotation.XmlType;

@XmlType(propOrder = {"nombre", "telefono", "calificaciones", "admitido"})
public class Aspirante {

	private String id;
	private String nombre;
	private int telefono;
	private List<Nota> calificaciones = new ArrayList<>();
	private Boolean admitido;
	

	public Aspirante() {
		super();
	}
	
	@XmlAttribute
	public String getId() {
		return id;
	}
	public void setId(String id) {
		this.id = id;
	}
	public Boolean getAdmitido() {
		return admitido;
	}

	public void setAdmitido(Boolean admitido) {
		this.admitido = admitido;
	}
	
	public String getNombre() {
		return nombre;
	}
	public void setNombre(String nombre) {
		this.nombre = nombre;
	}
	public int getTelefono() {
		return telefono;
	}
	public void setTelefono(int telefono) {
		this.telefono = telefono;
	}
	@XmlElementWrapper(name = "calificaciones") // <--- IMPORTANTE
    @XmlElement(name = "nota")                  // <--- IMPORTANTE
    public List<Nota> getCalificaciones() {
        return calificaciones;
    }
	public void setCalificaciones(List<Nota> calificaciones) {
		this.calificaciones = calificaciones;
	}
	
	
	
	
}
