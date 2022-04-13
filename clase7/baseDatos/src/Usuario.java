public class Usuario {
    private Long id;
    private String nombre;

    //constructor

    public Usuario(Long id, String nombre) {
        this.id = id;
        this.nombre = nombre;
    }

    //getter y setter

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public String getNombre() {
        return nombre;
    }

    public void setNombre(String nombre) {
        this.nombre = nombre;
    }
}
