package tpComercio;

public class Contacto {
    private String email;
    private String celular;
    private String Ubicacion;

    public Contacto(String email, String celular, String Ubicacion) {
        this.email = email;
        this.celular = celular;
        this.Ubicacion = Ubicacion;
    }

    public String getEmail() {
        return email;
    }

    public void setEmail(String email) {
        this.email = email;
    }

    public String getCelular() {
        return celular;
    }

    public void setCelular(String celular) {
        this.celular = celular;
    }

    public String getUbicacion() {
        return Ubicacion;
    }

    public void setUbicacion(String Ubicacion) {
        this.Ubicacion = Ubicacion;
    }
    
}