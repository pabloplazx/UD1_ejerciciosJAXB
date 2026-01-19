package logica;
import jakarta.xml.bind.annotation.XmlAttribute;
import jakarta.xml.bind.annotation.XmlValue; // Importa esto

public class Nota {
    private String tipo;
    private double nota;

    public Nota() {}

    @XmlAttribute
    public String getTipo() { return tipo; }
    public void setTipo(String tipo) { this.tipo = tipo; }

    @XmlValue  // <--- IMPORTANTE
    public double getNota() { return nota; }
    public void setNota(double nota) { this.nota = nota; }
}