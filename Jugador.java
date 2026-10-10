import java.util.ArrayList;
import java.util.List;

public class Jugador {
    private int energia;
    private List<Carta> mano;

    public Jugador() {
        this.energia = 5; // Energía inicial
        this.mano = new ArrayList<>();
    }

    public int getEnergia() { return energia; }
    public void setEnergia(int energia) { this.energia = energia; }
    public List<Carta> getMano() { return mano; }

    public void agregarCartaMano(Carta c) {
        if(c != null) mano.add(c);
    }
}