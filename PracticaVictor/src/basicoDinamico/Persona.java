package basicoDinamico;

import java.util.Objects;



public class Persona {
    
    private String nombre;
    private String apellidos;
    private int edad;
    private String email;
	private int donacion;
    

    public Persona(String nombre, String apellidos, int edad,String email,int donacion) {
        this.nombre = nombre;
        this.apellidos = apellidos;
        this.edad = edad;
        this.email=email;
        this.donacion=donacion;
    }

    public String getNombre() {
        return nombre;
    }

    public void setNombre(String nombre) {
        this.nombre = nombre;
    }

    public String getApellidos() {
        return apellidos;
    }

    public void setApellidos(String apellidos) {
        this.apellidos = apellidos;
    }

    public int getEdad() {
        return edad;
    }

    public void setEdad(int edad) {
        this.edad = edad;
    }
    public String getEmail() {
  		return email;
  	}

  	public void setEmail(String email) {
  		this.email = email;
  	}

  	public int getDonacion() {
  		return donacion;
  	}

  	public void setDonacion(int donacion) {
  		this.donacion = donacion;
  	}
    @Override
    public int hashCode() {
        int hash = 3;
        return hash;
    }

    @Override
    public boolean equals(Object obj) {
        if (this == obj) {
            return true;
        }
        if (obj == null) {
            return false;
        }
        if (getClass() != obj.getClass()) {
            return false;
        }
        final Persona other = (Persona) obj;
        if (this.edad != other.edad) {
            return false;
        }
        if (!Objects.equals(this.nombre, other.nombre)) {
            return false;
        }
        if (!Objects.equals(this.apellidos, other.apellidos)) {
            return false;
        }
        if (!Objects.equals(this.email, other.email)) {
            return false;
        }
        if (!Objects.equals(this.donacion, other.donacion)) {
            return false;
        }
        return true;
    }

	
    
}