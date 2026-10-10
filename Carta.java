import java.util.Objects;

public abstract class Carta implements Comparable<Carta> {
    protected String id;
    protected String nombre;
    protected int costoEnergia;
    protected String descripcion;

    public Carta(String id, String nombre, int costoEnergia, String descripcion) {
        this.id = id;
        this.nombre = nombre;
        this.costoEnergia = costoEnergia;
        this.descripcion = descripcion;
    }

    // Método polimórfico
    public abstract void jugarCarta();

    public String getId() { return id; }
    public String getNombre() { return nombre; }
    public int getCostoEnergia() { return costoEnergia; }

    @Override
    public int compareTo(Carta otra) {
        // Ordenar de menor a mayor costo de energía
        return Integer.compare(this.costoEnergia, otra.costoEnergia);
    }

    @Override
    public boolean equals(Object obj) {
        if (this == obj) return true;
        if (obj == null || getClass() != obj.getClass()) return false;
        Carta carta = (Carta) obj;
        return id.equals(carta.id);
    }

    @Override
    public String toString() {
        return "[" + id + "] " + nombre + " (Energía: " + costoEnergia + ") - " + descripcion;
    }
}