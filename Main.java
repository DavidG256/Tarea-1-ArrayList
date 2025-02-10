import java.util.Scanner;

public class Main {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        TelefonoMovil telefono = new TelefonoMovil("19");
        boolean exit = false;

        while (!exit) {
            System.out.println("Menú:");
            System.out.println("1. Imprimir contactos");
            System.out.println("2. Agregar contacto");
            System.out.println("3. Actualizar contacto");
            System.out.println("4. Eliminar contacto");
            System.out.println("5. Buscar por nombre");
            System.out.println("6. Buscar por teléfono");
            System.out.println("7. Ordenar contactos por nombre");
            System.out.println("8. Borrar todos los contactos");
            System.out.println("9. Mostrar número de contactos");
            System.out.println("0. Salir");
            System.out.print("Opción: ");

            int option = scanner.nextInt();
            scanner.nextLine();

            switch (option) {
                case 1 -> telefono.printContacts();
                case 2 -> {
                    System.out.print("Nombre: ");
                    String name = scanner.nextLine();
                    System.out.print("Teléfono: ");
                    String phone = scanner.nextLine();
                    if (telefono.addNewContact(Contacto.createContact(name, phone))) {
                        System.out.println("Contacto agregado.");
                    } else {
                        System.out.println("No se pudo agregar el contacto.");
                    }
                }
                case 3 -> {
                    System.out.print("Nombre del contacto a actualizar: ");
                    String name = scanner.nextLine();
                    Contacto existingContact = telefono.queryContact(name);
                    if (existingContact == null) {
                        System.out.println("Contacto no encontrado.");
                    } else {
                        System.out.print("Nuevo nombre: ");
                        String newName = scanner.nextLine();
                        System.out.print("Nuevo teléfono: ");
                        String newPhone = scanner.nextLine();
                        if (telefono.updateContact(existingContact, Contacto.createContact(newName, newPhone))) {
                            System.out.println("Contacto actualizado.");
                        } else {
                            System.out.println("No se pudo actualizar el contacto.");
                        }
                    }
                }
                case 0 -> exit = true;
                default -> System.out.println("Opción inválida.");
            }
        }
        scanner.close();
    }
}
