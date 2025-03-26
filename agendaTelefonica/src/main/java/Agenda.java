import java.util.ArrayList;
import java.util.Collections;
import java.util.Comparator;
import java.util.List;

public class Agenda {
    private List<Contacto> contactos;
    private int capacidad = 10;

    public Agenda(int capacidad) {
        this.capacidad = capacidad;
        this.contactos = new ArrayList<>();
    }

    public Agenda() {
        this(10); // Tamaño por defecto
    }

    /**Añade un contacto a la agenda**/
    public void anadirContacto(Contacto c) {
        if (contactos.size() >= capacidad){
            System.out.println("Agenda llena");
            return;
        }
        if (existeContacto(c)){
            System.out.println("Contacto ya existente");
            return;
        }
        contactos.add(c);
        System.out.println("Contacto añadido con éxito.");
    }

    /**Verifica si un contacto ya existe en la agenda.**/
    public boolean existeContacto(Contacto c) {
        return contactos.contains(c);

    }

    /**Muestra todos los contactos de la agenda en el siguiente formato: Nombre Apellido - Teléfono.**/
    public void listarContactos() {
        if (contactos.isEmpty()){
            System.out.println("La agenda esta vacia");
        }
        Collections.sort(contactos, Comparator.comparing(Contacto::getNombre).thenComparing(Contacto::getApellido));
        for (Contacto contacto : contactos){
            System.out.println(contacto.getNombre() + " " + contacto.getApellido() + " - " + contacto.getNumeroTelefonico());
        }
    }

    /**Permite buscar un contacto por nombre y apellido.**/
    public void buscarContacto(String nombre, String apellido) {
        for (Contacto contacto : contactos){
            if (contacto.getNombre().equalsIgnoreCase(nombre) && contacto.getApellido().equals(apellido)){
                System.out.println(" El numero telefonico de " + nombre + " " + apellido + " " + "es: " + contacto.getNumeroTelefonico());
                return;
            }
        }
        System.out.println("No existe el contacto");
    }

    /**Elimina un contacto de la agenda**/
    public void eliminarContacto(String nombre, String apellido) {
        Contacto contactoAEliminar = null;
        for (Contacto contacto : contactos) {
            if (contacto.getNombre().equalsIgnoreCase(nombre) && contacto.getApellido().equalsIgnoreCase(apellido)) {
                contactoAEliminar = contacto;
                break;
            }
        }
        if (contactoAEliminar != null) {
            contactos.remove(contactoAEliminar);
            System.out.println("Contacto eliminado.");
        } else {
            System.out.println("Contacto no encontrado.");
        }
    }

    /**Permite modificar el teléfono de un contacto existente.**/
    public void modificarTelefono(String nombre, String apellido, String nuevoTelefono) {
        for (Contacto contacto : contactos) {
            if (contacto.getNombre().equalsIgnoreCase(nombre) && contacto.getApellido().equalsIgnoreCase(apellido)) {
                contacto.setNumeroTelefonico(nuevoTelefono);
                return;
            }
        }
        System.out.println("El contacto no existe");
    }

    /**Indica si la agenda está llena.**/
    public void agendaLlena() {
        if (contactos.size() == capacidad){
            System.out.println("La agenda esta en su capacidad máxima");
            return;
        }
        System.out.println("La agenda aun tiene espacio");
    }

    /**Muestra cuántos contactos más se pueden agregar a la agenda.**/
    public int espaciosDisponiblesEnAgenda() {
        int espacios = capacidad - contactos.size();
        return  espacios;
    }
}
