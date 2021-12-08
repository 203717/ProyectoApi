package andyfranco.tipo.model;

import javax.persistence.*;

@Entity
@Table(name = "tipo")
public class Tipo {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private int tipoid;

    @Column(name = "tipo")
    private String tipo;

    @Column(name = "caracteristica")
    private String caracteristica;


    public Tipo(){}

    public Tipo(int tipoid, String caracteristica, String tipo) {
        this.tipoid = tipoid;
        this.caracteristica = caracteristica;
        this.tipo = tipo;
    }

    public int getTipoid() {
        return tipoid;
    }

    public void setTipoid(int tipoid) {
        this.tipoid = tipoid;
    }

    public String getCaracteristica() {
        return caracteristica;
    }

    public void setCaracteristica(String caracteristica) {
        this.caracteristica = caracteristica;
    }

    public String getTipo() {
        return tipo;
    }

    public void setTipo(String tipo) {
        this.tipo = tipo;
    }

}
