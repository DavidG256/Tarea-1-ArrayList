import java.util.Scanner;

public class Main {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        TelefonoMovil movil = new TelefonoMovil("11111111");
        boolean running = true;

        while (running) {
            System.out.println("Menú de opciones:");
            System.out.println("0. Salir");
            System.out.println("1. Imprimir contactos");
            System.out.println("2. Agregar un nuevo contacto");
            int elegir = scanner.nextInt();
            scanner.nextLine();

        }

        switch (){
            case 0:
                System.out.println();
                break;
            case 1:
                break;
            default:
                System.out.println();
        }

    }
}