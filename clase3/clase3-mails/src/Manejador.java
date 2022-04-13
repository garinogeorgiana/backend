public abstract class Manejador {
    protected Manejador siguenteManejador;

    //creamos el metodo que llama al diguiente manejador
    public Manejador getSiguenteManejador(){
        return this.siguenteManejador;
    }

    public void setSiguenteManejador(Manejador m){
        this.siguenteManejador = m;
    }

    public abstract void comprobar(Mail mail);
}
