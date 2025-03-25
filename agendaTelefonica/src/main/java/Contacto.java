public class Contacto {
    //
    private String nombre;
    private String apellido;
    private String numeroTelefonico;

    //Constructor
    public Contacto(String nombre, String apellido, String numeroTelefonico) {
        this.nombre = nombre;
        this.apellido = apellido;
        this.numeroTelefonico = numeroTelefonico;
    }

    //Getter and setter
    public String getNumeroTelefonico() {
        return numeroTelefonico;
    }

    public void setNumeroTelefonico(String numeroTelefonico) {
        this.numeroTelefonico = numeroTelefonico;
    }

    @Override
    public String toString() {
        return "Contacto{" +
                "numeroTelefonico='" + numeroTelefonico + '\'' +
                '}';
    }
}
