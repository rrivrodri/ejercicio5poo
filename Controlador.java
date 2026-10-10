public class Controlador {
    private Vista vista;
    private CatalogoCartas catalogo;
    private Jugador jugador;

    public Controlador(Vista vista) {
        this.vista = vista;
        this.catalogo = new CatalogoCartas();
        this.jugador = new Jugador();
    }

    public void iniciar() {
        cargarCartasIniciales();
        boolean salir = false;

        while (!salir) {
            vista.mostrarMensaje("\n--- UVG CARD BATTLE ---");
            vista.mostrarMensaje("1. Listar todas las cartas");
            vista.mostrarMensaje("2. Buscar carta");
            vista.mostrarMensaje("3. Ordenar mazo por energía");
            vista.mostrarMensaje("4. Jugar Partida (Turno)");
            vista.mostrarMensaje("5. Salir");
            int opcion = vista.pedirInt("Seleccione una opción: ");

            switch (opcion) {
                case 1:
                    vista.mostrarCartas(catalogo.getMazo());
                    break;
                case 2:
                    buscarCarta();
                    break;
                case 3:
                    catalogo.ordenarPorEnergia();
                    vista.mostrarMensaje("Mazo ordenado por costo de energía.");
                    break;
                case 4:
                    jugarTurno();
                    break;
                case 5:
                    salir = true;
                    break;
                default:
                    vista.mostrarMensaje("Opción inválida.");
            }
        }
    }

    private void buscarCarta() {
        int criterio = vista.pedirInt("Buscar por (1) ID o (2) Nombre: ");
        String valor = vista.pedirString("Ingrese el valor a buscar: ");
        Carta encontrada = null;

        if (criterio == 1) encontrada = catalogo.buscarPorId(valor);
        else if (criterio == 2) encontrada = catalogo.buscarPorNombre(valor);

        if (encontrada != null) {
            vista.mostrarMensaje("¡Carta encontrada!");
            vista.mostrarMensaje(encontrada.toString());
        } else {
            vista.mostrarMensaje("No se encontró ninguna carta.");
        }
    }

    private void jugarTurno() {
        vista.mostrarMensaje("\n-- MODO PARTIDA --");
        vista.mostrarMensaje("Tu energía actual: " + jugador.getEnergia());
        vista.mostrarMensaje("1. Tomar carta");
        vista.mostrarMensaje("2. Usar carta de tu mano");
        vista.mostrarMensaje("3. Pasar turno (Ganas +2 de energía)");
        
        int accion = vista.pedirInt("¿Qué deseas hacer?: ");
        
        switch(accion) {
            case 1:
                Carta robada = catalogo.sacarCartaAleatoria();
                jugador.agregarCartaMano(robada);
                vista.mostrarMensaje("Has robado: " + robada.getNombre());
                break;
            case 2:
                if (jugador.getMano().isEmpty()) {
                    vista.mostrarMensaje("No tienes cartas en la mano.");
                } else {
                    vista.mostrarMensaje("Tu mano:");
                    for (int i=0; i<jugador.getMano().size(); i++) {
                        vista.mostrarMensaje(i + ". " + jugador.getMano().get(i).toString());
                    }
                    int indice = vista.pedirInt("Selecciona el número de carta a jugar: ");
                    if (indice >= 0 && indice < jugador.getMano().size()) {
                        Carta cartaSeleccionada = jugador.getMano().get(indice);
                        if (jugador.getEnergia() >= cartaSeleccionada.getCostoEnergia()) {
                            jugador.setEnergia(jugador.getEnergia() - cartaSeleccionada.getCostoEnergia());
                            vista.mostrarMensaje("Jugando carta...");
                            // AQUÍ ESTÁ EL POLIMORFISMO EN ACCIÓN
                            cartaSeleccionada.jugarCarta(); 
                            jugador.getMano().remove(indice);
                        } else {
                            vista.mostrarMensaje("No tienes suficiente energía para jugar esta carta.");
                        }
                    } else {
                        vista.mostrarMensaje("Índice inválido.");
                    }
                }
                break;
            case 3:
                jugador.setEnergia(jugador.getEnergia() + 2);
                vista.mostrarMensaje("Pasas el turno. Recuperas energía.");
                break;
            default:
                vista.mostrarMensaje("Acción inválida.");
        }
    }

    private void cargarCartasIniciales() {
        catalogo.agregarCarta(new CartaCatedratico("C01", "El Inquisidor", 4, "Hace preguntas difíciles.", "Ciencias de la Computación", 5, 2));
        catalogo.agregarCarta(new CartaCatedratico("C02", "El Exigente", 6, "Califica estricto.", "Matemática", 8, 3));
        catalogo.agregarCarta(new CartaCatedratico("C03", "El Relajado", 2, "Da prórrogas.", "Física", 1, 1));
        catalogo.agregarCarta(new CartaCurso("M01", "Programación Orientada a Objetos", 5, "Proyecto final intenso.", "Computación", 5, 8));
        catalogo.agregarCarta(new CartaCurso("M02", "Cálculo I", 4, "Muchos límites.", "Matemática", 5, 7));
        catalogo.agregarCarta(new CartaCurso("M03", "Física Básica", 3, "Vectores por todos lados.", "Física", 4, 6));
        catalogo.agregarCarta(new CartaCurso("M04", "Algoritmos", 6, "Listas, árboles y grafos.", "Computación", 6, 9));
        catalogo.agregarCarta(new CartaEvento("E01", "Semana de Parciales", 7, "Nadie duerme.", "Todos los jugadores pierden 3 de energía."));
        catalogo.agregarCarta(new CartaEvento("E02", "Feria de Clubes", 2, "Te inscribes a todo.", "Ganas 2 cartas extra."));
        catalogo.agregarCarta(new CartaEvento("E03", "Viernes Universitario", 1, "Fin de semana.", "Todos los jugadores ganan 2 de energía."));
    }
}