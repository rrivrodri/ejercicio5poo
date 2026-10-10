public class CartaEvento extends Carta {
    private String efectoTablero;

    public CartaEvento(String id, String nombre, int costoEnergia, String descripcion, String efectoTablero) {
        super(id, nombre, costoEnergia, descripcion);
        this.efectoTablero = efectoTablero;
    }

    @Override
    public void jugarCarta() {
        System.out.println(">> [EFECTO GLOBAL] " + nombre + " altera el tablero: " + efectoTablero);
    }
}