package raulalvarez.duenoService.model;

import javax.persistence.*;

@Entity
public class Mascota {

    @Id
    private int mascotaId;

    @Column(name = "nombre")
    private String nombre;

    @Column(name = "razon")
    private String razon;

    @Column(name = "tipo")
    private int tipo;

    @Column(name = "fecha")
    private String fecha;

    @Column(name= "duenoId")
    private int duenoId;

    public Mascota() {}

    public Mascota(int mascotaId, String nombre, String razon, int tipo, String fecha, int duenoId) {
        this.mascotaId = mascotaId;
        this.nombre = nombre;
        this.razon = razon;
        this.tipo = tipo;
        this.fecha = fecha;
        this.duenoId = duenoId;
    }

    public int getMascotaId() {
        return mascotaId;
    }

    public void setMascotaId(int mascotaId) {
        this.mascotaId = mascotaId;
    }

    public String getNombre() {
        return nombre;
    }

    public void setNombre(String nombre) {
        this.nombre = nombre;
    }

    public String getRazon() {
        return razon;
    }

    public void setRazon(String razon) {
        this.razon = razon;
    }

    public int getTipo() {
        return tipo;
    }

    public void setTipo(int tipo) {
        this.tipo = tipo;
    }

    public String getFecha() {
        return fecha;
    }

    public void setFecha(String fecha) {
        this.fecha = fecha;
    }

    public int getDuenoId(){return duenoId;}

    public void setDuenoId(Integer duenoId){this.duenoId= duenoId;}
}
