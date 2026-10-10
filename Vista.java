import java.util.Scanner;
import java.util.List;

public class Vista {
    private Scanner scanner;

    public Vista() {
        this.scanner = new Scanner(System.in);
    }

    public void mostrarMensaje(String msg) {
        System.out.println(msg);
    }

    public void mostrarCartas(List<Carta> cartas) {
        for (Carta c : cartas) {
            System.out.println(c.toString());
        }
    }

    public int pedirInt(String mensaje) {
        System.out.print(mensaje);
        while (!scanner.hasNextInt()) {
            System.out.println("Entrada inválida. Ingrese un número.");
            scanner.next();
        }
        int valor = scanner.nextInt();
        scanner.nextLine();
        return valor;
    }

    public String pedirString(String mensaje) {
        System.out.print(mensaje);
        return scanner.nextLine();
    }
}