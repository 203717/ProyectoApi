package andyfranco.tipo.model;

public class TipoMascota  extends Tipo{

    private Mascota mascota;

    public TipoMascota() {
    }


    public TipoMascota(Mascota mascota) {
        this.mascota = mascota;
    }

    public TipoMascota(int tipoid, String caracteristica, String tipo, Mascota mascota) {
        super(tipoid, caracteristica, tipo);
        this.mascota = mascota;
    }

    public Mascota getMascota() {
        return mascota;
    }

    public void setMascota(Mascota mascota) {
        this.mascota = mascota;
    }
}
