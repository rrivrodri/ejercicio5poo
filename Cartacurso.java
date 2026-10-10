public class CartaCurso extends Carta {
    private String materia;
    private int creditos;
    private int nivelDificultad;

    public CartaCurso(String id, String nombre, int costoEnergia, String descripcion, String materia, int creditos, int nivelDificultad) {
        super(id, nombre, costoEnergia, descripcion);
        this.materia = materia;
        this.creditos = creditos;
        this.nivelDificultad = nivelDificultad;
    }

    @Override
    public void jugarCarta() {
        System.out.println(">> [EFECTO] Estudiando " + materia + ". Dificultad nivel " + nivelDificultad + ". ¡Te dará " + creditos + " créditos si apruebas!");
    }
    
    @Override
    public String toString() {
        return super.toString() + " | Créditos: " + creditos + " | Dif: " + nivelDificultad;
    }
}