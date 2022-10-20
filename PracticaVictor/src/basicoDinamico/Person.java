package basicoDinamico;

import javafx.beans.property.SimpleIntegerProperty;
import javafx.beans.property.SimpleStringProperty;

/**
 * 
 * Clase auxiliar que se empleará para el modelo de datos del TableView
 * 
 * @author SBF
 * 
 */
public class Person {
    private final SimpleStringProperty Nombre;
    private final SimpleStringProperty Apellido;
    private final SimpleStringProperty email;
    private final SimpleIntegerProperty Edad;
 
    public Person(String fNombre, String fApellido, String femail, Integer Edad) {
        this.Nombre = new SimpleStringProperty(fNombre);
        this.Apellido = new SimpleStringProperty(fApellido);
        this.email = new SimpleStringProperty(femail);
        this.Edad = new SimpleIntegerProperty(Edad);
    }
 
    public String getNombre() {
        return Nombre.get();
    }
    
    public void setNombre(String fNombre) {
        Nombre.set(fNombre);
    }
        
    public String getApellido() {
        return Apellido.get();
    }
    public void setApellido(String fApellido) {
        Apellido.set(fApellido);
    }
    
    public String getEmail() {
        return email.get();
    }
    public void setEmail(String femail) {
        email.set(femail);
    }

	public Integer getEdad() {
		return Edad.get();
	}
	public void setEdad(Integer fEdad) {
		Edad.set(fEdad);
    }        
        
}