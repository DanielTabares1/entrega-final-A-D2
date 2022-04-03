package modelo;

public class Cliente extends Persona {

    private String fechaNacimineto;
    private String correoElectronico;
    private String telefono;
    private String direccion;
    private float ingresosMensuales;

    public Cliente(String nombre, String id, String fechaNacimineto, String correoElectronico, String telefono, String direccion, float ingresosMensuales) {
        this.nombre = nombre;
        this.id = id;
        this.fechaNacimineto = fechaNacimineto;
        this.correoElectronico = correoElectronico;
        this.telefono = telefono;
        this.direccion = direccion;
        this.ingresosMensuales = ingresosMensuales;
    }

    public String getFechaNacimineto() {
        return fechaNacimineto;
    }

    public String getCorreoElectronico() {
        return correoElectronico;
    }

    public String getTelefono() {
        return telefono;
    }

    public String getDireccion() {
        return direccion;
    }

    public float getIngresosMensuales() {
        return ingresosMensuales;
    }

    public void setCorreoElectronico(String correoElectronico) {
        this.correoElectronico = correoElectronico;
    }

    public void setTelefono(String telefono) {
        this.telefono = telefono;
    }

    public void setDireccion(String direccion) {
        this.direccion = direccion;
    }

    public void setIngresosMensuales(float ingresosMensuales) {
        this.ingresosMensuales = ingresosMensuales;
    }
}
