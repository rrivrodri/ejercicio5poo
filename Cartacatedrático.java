public class CartaCatedratico extends Carta {
    private String departamento;
    private int puntosLlamadaAtencion;
    private int tiempoAtencion;

    public CartaCatedratico(String id, String nombre, int costoEnergia, String descripcion, String departamento, int puntos, int tiempo) {
        super(id, nombre, costoEnergia, descripcion);
        this.departamento = departamento;
        this.puntosLlamadaAtencion = puntos;
        this.tiempoAtencion = tiempo;
    }

    @Override
    public void jugarCarta() {
        System.out.println(">> [EFECTO] " + nombre + " entra al aula. Genera " + puntosLlamadaAtencion + " pts de atención por " + tiempoAtencion + " turnos.");
    }

    @Override
    public String toString() {
        return super.toString() + " | Depto: " + departamento;
    }
}