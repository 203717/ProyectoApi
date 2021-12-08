package janethmorales.mascotas.model;

import java.util.ArrayList;

public class MascotaCita extends  Mascota{
    private ArrayList<Cita> cita;

    public MascotaCita() {
    }

    public MascotaCita(ArrayList<Cita> cita) {
        this.cita = cita;
    }

    public MascotaCita(int mascotaId, String nombre, String razon, int tipo, String fecha, int duenoId,ArrayList<Cita> cita) {
        super(mascotaId, nombre, razon, tipo, fecha, duenoId);
        this.cita = cita;
    }

    public ArrayList<Cita>getCita() {
        return cita;
    }

    public void setCita(ArrayList<Cita> cita) {
        this.cita = cita;
    }
}
