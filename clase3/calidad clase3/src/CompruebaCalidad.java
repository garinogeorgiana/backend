public class CompruebaCalidad {
    Manejador inicial;

    public CompruebaCalidad(){
        this.inicial=new ManejadorLote();
        Manejador peso = new ManejadorPeso();
        Manejador envase = new ManejadorEnvase();
        Manejador acepta = new ManejadorAceptar();

        inicial.setSiguienteManejador(peso);
        peso.setSiguienteManejador(envase);
        envase.setSiguienteManejador(acepta);
    }

    public void comprobar(Articulo art){
        inicial.comprobar(art);
    }
}
