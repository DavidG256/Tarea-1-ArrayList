import java.util.Scanner;

public class Main {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        TelefonoMovil miTelefono = new TelefonoMovil("123456789");
        boolean salir = false;

        while (!salir) {
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
            int opcion = scanner.nextInt();
            scanner.nextLine();

            switch (opcion) {
                case 1:
                    miTelefono.printContacts();
                    break;
                case 2:
                    System.out.println("Ingrese nombre:");
                    String nombre = scanner.nextLine();
                    System.out.println("Ingrese teléfono:");
                    String telefono = scanner.nextLine();
                    Contacto nuevo = Contacto.CreateContact(nombre, telefono);
                    if (miTelefono.addNewContact(nuevo)) {
                        System.out.println("Contacto agregado.");
                    } else {
                        System.out.println("El contacto ya existe.");
                    }
                    break;
                case 3:
                    System.out.println("Ingrese nombre a actualizar:");
                    String oldName = scanner.nextLine();
                    Contacto oldContact = miTelefono.queryContact(oldName);
                    if (oldContact == null) {
                        System.out.println("Contacto no encontrado.");
                        break;
                    }
                    System.out.println("Ingrese nuevo nombre:");
                    String newName = scanner.nextLine();
                    System.out.println("Ingrese nuevo teléfono:");
                    String newPhone = scanner.nextLine();
                    Contacto updatedContact = Contacto.CreateContact(newName, newPhone);
                    if (miTelefono.updateContact(oldContact, updatedContact)) {
                        System.out.println("Contacto actualizado.");
                    } else {
                        System.out.println("Error al actualizar.");
                    }
                    break;
                case 4:
                    System.out.println("Ingrese nombre a eliminar:");
                    String removeName = scanner.nextLine();
                    Contacto removeContact = miTelefono.queryContact(removeName);
                    if (removeContact != null && miTelefono.removeContact(removeContact)) {
                        System.out.println("Contacto eliminado.");
                    } else {
                        System.out.println("No encontrado.");
                    }
                    break;
                case 5:
                    System.out.println("Ingrese nombre a buscar:");
                    String searchName = scanner.nextLine();
                    Contacto foundContact = miTelefono.queryContact(searchName);
                    System.out.println(foundContact != null ? foundContact.getName() + " -> " + foundContact.getPhoneNumber() : "No encontrado.");
                    break;
                case 6:
                    System.out.println("Ingrese teléfono a buscar:");
                    String searchPhone = scanner.nextLine();
                    Contacto phoneContact = miTelefono.searchByPhone(searchPhone);
                    System.out.println(phoneContact != null ? phoneContact.getName() + " -> " + phoneContact.getPhoneNumber() : "No encontrado.");
                    break;
                case 7:
                    miTelefono.sortContacts();
                    System.out.println("Contactos ordenados.");
                    break;
                case 8:
                    miTelefono.removeAllContacts();
                    System.out.println("Todos los contactos eliminados.");
                    break;
                case 9:
                    System.out.println("Número de contactos: " + miTelefono.getNumberOfContacts());
                    break;
                case 0:
                    salir = true;
                    break;
                default:
                    System.out.println("Opción inválida.");
            }
        }
        scanner.close();
    }
}