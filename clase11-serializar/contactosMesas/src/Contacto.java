import java.io.Serializable;

public class Contacto implements Serializable {
    private String nombre;
    private String mail;
    private int telefono;

    //constructor

    public Contacto(String nombre, String mail, int telefono) {
        this.nombre = nombre;
        this.mail = mail;
        this.telefono = telefono;
    }

    //getter y setter

    public String getNombre() {
        return nombre;
    }

    public void setNombre(String nombre) {
        this.nombre = nombre;
    }

    public String getMail() {
        return mail;
    }

    public void setMail(String mail) {
        this.mail = mail;
    }

    public int getTelefono() {
        return telefono;
    }

    public void setTelefono(int telefono) {
        this.telefono = telefono;
    }

    //tostring

    /**Creo el toString*/
    @Override
    public String toString() {
        return "==========================================================" +'\n' +
                "Nombre: " + nombre + '\n' +
                "Email: " + mail + '\n' +
                "Telefono: " + telefono+ '\n';
    }
}
