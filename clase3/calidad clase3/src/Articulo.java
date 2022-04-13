public class Articulo {
    private String nombre;
    private int peso;
    private int lote;
    private String envase;

    //constructor
    public Articulo(String nombre, int peso, int lote, String envase) {
        this.nombre = nombre;
        this.peso = peso;
        this.lote = lote;
        this.envase = envase;
    }

    //getter y setter

    public String getNombre() {
        return nombre;
    }

    public void setNombre(String nombre) {
        this.nombre = nombre;
    }

    public int getPeso() {
        return peso;
    }

    public void setPeso(int peso) {
        this.peso = peso;
    }

    public int getLote() {
        return lote;
    }

    public void setLote(int lote) {
        this.lote = lote;
    }

    public String getEnvase() {
        return envase;
    }

    public void setEnvase(String envase) {
        this.envase = envase;
    }
}
