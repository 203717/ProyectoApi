package raulalvarez.duenoService.model;

import java.util.ArrayList;

public class DuenoMascota extends Dueno {
    private ArrayList<Mascota> mascotas;

    public DuenoMascota() {
    }

    public DuenoMascota(ArrayList<Mascota> mascotas) {
        this.mascotas = mascotas;
    }

    public DuenoMascota(int duenoId, String direccion, String nombre, int telefono, ArrayList<Mascota> mascotas) {
        super(duenoId, direccion, nombre, telefono);
        this.mascotas = mascotas;
    }

    public ArrayList<Mascota> getMascotas() {
        return mascotas;
    }

    public void setMascotas(ArrayList<Mascota> mascotas) {
        this.mascotas = mascotas;
    }
}
