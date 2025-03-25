import java.util.Scanner;

public class Main {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        Agenda agenda = new Agenda(10); 

        while (true) {
            System.out.println("\n=== AGENDA TELEFÓNICA ===");
            System.out.println("1. Añadir contacto");
            System.out.println("2. Buscar contacto");
            System.out.println("3. Eliminar contacto");
            System.out.println("4. Listar contactos");
            System.out.println("5. Mostrar espacios libres");
            System.out.println("6. Salir");
            System.out.print("Seleccione una opción: ");

            try {
                int opcion = Integer.parseInt(scanner.nextLine());

                switch (opcion) {
                    case 1: { // Añadir contacto
                        System.out.print("Nombre: ");
                        String nombre = scanner.nextLine();
                        System.out.print("Apellido: ");
                        String apellido = scanner.nextLine();
                        System.out.print("Teléfono: ");
                        String telefono = scanner.nextLine();
                        agenda.añadirContacto(new Contacto(nombre, apellido, telefono));
                        break;
                    }
                    case 2: { // Buscar contacto
                        System.out.print("Nombre: ");
                        String nombreBuscar = scanner.nextLine();
                        System.out.print("Apellido: ");
                        String apellidoBuscar = scanner.nextLine();
                        agenda.buscarContacto(nombreBuscar, apellidoBuscar);
                        break;
                    }
                    case 3: { // Eliminar contacto
                        System.out.print("Nombre: ");
                        String nombreEliminar = scanner.nextLine();
                        System.out.print("Apellido: ");
                        String apellidoEliminar = scanner.nextLine();
                        agenda.eliminarContacto(nombreEliminar, apellidoEliminar);
                        break;
                    }
                    case 4:
                        agenda.listarContactos();
                        break;
                    case 5:
                        System.out.println("Espacios libres: " + agenda.espaciosLibres());
                        break;
                    case 6: { // Salir
                        System.out.println("Saliendo del programa...");
                        scanner.close();
                        System.exit(0);
                    }
                    default:
                        System.out.println("❌ Opción no válida");
                } 
            } catch (NumberFormatException e) {
                System.out.println("❌ Error: Ingrese un número del 1 al 6");
            } catch (IllegalArgumentException e) {
                System.out.println("❌ Error: " + e.getMessage());
            }
        } 
    }
}
