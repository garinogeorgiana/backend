public abstract class Manejador {
    protected Manejador siguienteManejador;

    //creamos el metodo que llama a sig manejador
    public Manejador getSiguienteManejador(){
        return this.siguienteManejador;
    }

    public void setSiguienteManejador(Manejador m){
        this.siguienteManejador = m;
    }
    public abstract void comprobar(Articulo art);
}
