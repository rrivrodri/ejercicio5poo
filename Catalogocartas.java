import java.util.ArrayList;
import java.util.Collections;
import java.util.List;

public class CatalogoCartas {
    private List<Carta> mazo;

    public CatalogoCartas() {
        this.mazo = new ArrayList<>();
    }

    public void agregarCarta(Carta carta) {
        mazo.add(carta);
    }

    public List<Carta> getMazo() {
        return mazo;
    }

    public void ordenarPorEnergia() {
        Collections.sort(mazo);
    }

    public Carta buscarPorId(String id) {
        for (Carta c : mazo) {
            if (c.getId().equalsIgnoreCase(id)) return c;
        }
        return null;
    }

    public Carta buscarPorNombre(String nombre) {
        for (Carta c : mazo) {
            if (c.getNombre().toLowerCase().contains(nombre.toLowerCase())) return c;
        }
        return null;
    }
    
    public Carta sacarCartaAleatoria() {
        if(mazo.isEmpty()) return null;
        int index = (int)(Math.random() * mazo.size());
        return mazo.get(index);
    }
}
