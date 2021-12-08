package janethmorales.mascotas.model;

import javax.persistence.*;

@Entity
public class Cita {

    @Id
    private int citaId;

    @Column(name = "hora")
    private String  hora;

    @Column(name = "servicio")
    private String servicio;

    @Column(name = "fecha")
    private String fecha;

    @Column(name = "mascotaId")
    private int mascotaId;


    public Cita(){}

    public Cita(int citaId, String servicio, String fecha, String hora, int mascotaId) {
        this.hora = hora;
        this.citaId = citaId;
        this.servicio = servicio;
        this.fecha = fecha;
        this.mascotaId = mascotaId;
    }

    public int getCitaId() {
        return citaId;
    }
    public void setCitaId(int citaId) {
        this.citaId = citaId;
    }

    public String getHora() {
        return hora;
    }
    public void setHora(String hora) {
        this.hora = hora;
    }

    public String getServicio() {
        return servicio;
    }
    public void setServicio(String servicio) {
        this.servicio = servicio;
    }

    public String getFecha() {
        return fecha;
    }
    public void setFecha(String fecha) {
        this.fecha = fecha;
    }

    public int getMascotaId() {
        return mascotaId;
    }
    public void setMascotaId(int mascotaId) {
        this.mascotaId = mascotaId;
    }
}