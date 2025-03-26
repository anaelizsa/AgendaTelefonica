import javax.sound.midi.Soundbank;

public class Contacto {
    //Atributos
    private String nombre;
    private String apellido;
    private String numeroTelefonico;

    //Constructor
    public Contacto(String nombre, String apellido, String numeroTelefonico) {
        if (nombre.trim().isEmpty()){
            throw new IllegalArgumentException("El nombre no puede estar vacío");
        }
        if (apellido.trim().isEmpty()){
            throw new IllegalArgumentException("El apellido no puede estar vacío"); // si no funciona, una excepcion
        }
        this.nombre = nombre.trim();
        this.apellido = apellido.trim();
        this.numeroTelefonico = numeroTelefonico.trim();
    }

    //Getter and setter

    public String getNombre() {
        return nombre;
    }

    public String getApellido() {
        return apellido;
    }

    public String getNumeroTelefonico() {
        return numeroTelefonico;
    }

    public void setNumeroTelefonico(String numeroTelefonico) {
        this.numeroTelefonico = numeroTelefonico;
    }

    //Overrides
    @Override
    public String toString() {
        return "Contacto{" +
                "numeroTelefonico='" + numeroTelefonico + '\'' +
                '}';
    }

    @Override
    public boolean equals(Object obj) {
        if (this == obj) return true;
        if (obj == null || getClass() != obj.getClass()) return false;
        Contacto contacto = (Contacto) obj;
        return nombre.equalsIgnoreCase(contacto.nombre) &&
                apellido.equalsIgnoreCase(contacto.apellido);
    }

}
