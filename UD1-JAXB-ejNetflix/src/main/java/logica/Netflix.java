package logica;

import java.util.ArrayList;
import java.util.List;

import jakarta.xml.bind.annotation.XmlAttribute;
import jakarta.xml.bind.annotation.XmlElement;
import jakarta.xml.bind.annotation.XmlElementWrapper;
import jakarta.xml.bind.annotation.XmlRootElement;

@XmlRootElement
public class Netflix {

	private String empresa;
	private List<Serie> series = new ArrayList<>();
	public Netflix() {
		super();
	}
	
	@XmlAttribute(name = "empresa")
	public String getEmpresa() {
		return empresa;
	}
	public void setEmpresa(String empresa) {
		this.empresa = empresa;
	}
	
	@XmlElementWrapper(name = "catalogo")
	@XmlElement(name = "serie")
	public List<Serie> getSeries() {
		return series;
	}
	public void setSeries(List<Serie> series) {
		this.series = series;
	}
	
	
	
}
