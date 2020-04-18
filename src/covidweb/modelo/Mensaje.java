package covidweb.modelo;
import java.io.Serializable;
public class Mensaje implements Serializable {
    private static final long serialVersionUID = 1L;
	
    private Integer id;
private String nombre;
private String email;
private String sitio;
private String mensaje;

public Mensaje() {
}

public Mensaje(String nombre, Integer id, String email, String sitio, String mensaje) {
    this.nombre = nombre;
    this.id=id;
    this.email = email;
    this.sitio = sitio;
    this.mensaje = mensaje;
}

public String getNombre() {
    return nombre;
}

public void setNombre(String nombre) {
    this.nombre = nombre;
}

public String getEmail() {
    return email;
}

public void setEmail(String email) {
    this.email = email;
}

public String getSitio() {
    return sitio;
}

public void setSitio(String sitio) {
    this.sitio = sitio;
}

public String getMensaje() {
    return mensaje;
}

public void setMensaje(String mensaje) {
    this.mensaje = mensaje;
}

public Integer getId() {
    return id;
}

public void setId(Integer id) {
    this.id = id;
}

    
}
