package janethmorales.mascotas.model;

import javax.persistence.*;

@Entity
public class Dueno {

    @Id
    private int duenoId;

    @Column(name = "nombre")
    private String nombre;

    @Column(name = "direccion")
    private String direccion;

    @Column(name = "telefono")
    private int telefono;

    public Dueno(){}

    public Dueno(int duenoId, String direccion, String nombre, int telefono) {
        this.duenoId = duenoId;
        this.direccion = direccion;
        this.nombre = nombre;
        this.telefono = telefono;
    }

    public int getDuenoId() {
        return duenoId;
    }

    public void setDuenoId(int duenoId) {
        this.duenoId = duenoId;
    }

    public String getDireccion() {
        return direccion;
    }

    public void setDireccion(String direccion) {
        this.direccion = direccion;
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
}
