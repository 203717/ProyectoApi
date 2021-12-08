package janethmorales.mascotas.model;

public class MascotaDueno extends Mascota{
    private Dueno dueno;

    public MascotaDueno() {
    }

    public MascotaDueno(Dueno dueno) {
        this.dueno = dueno;
    }

    public MascotaDueno(int mascotaId, String nombre, String razon, int tipo, String fecha, int duenoId, Dueno dueno) {
        super(mascotaId, nombre, razon, tipo, fecha, duenoId);
        this.dueno = dueno;
    }

    public Dueno getDueno() {
        return dueno;
    }

    public void setDueno(Dueno dueno) {
        this.dueno = dueno;
    }
}
