package logica;

import java.time.LocalDate;
import jakarta.xml.bind.annotation.adapters.XmlAdapter;

public class DateAdapter extends XmlAdapter<String, LocalDate> {

    // ESTE MÉTODO TRADUCE DE XML (String) A JAVA (LocalDate)
    @Override
    public LocalDate unmarshal(String v) throws Exception {
        return LocalDate.parse(v);
    }

    // ESTE MÉTODO TRADUCE DE JAVA (LocalDate) A XML (String)
    @Override
    public String marshal(LocalDate v) throws Exception {
        return v.toString();
    }
}