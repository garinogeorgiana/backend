public class CompruebaMail {
    Manejador inicial;

    public CompruebaMail(){
        this.inicial=new ManejadorGerencia();
        Manejador comercial =new ManejadorComercial();
        Manejador tecnico =new ManejadorTecnico();
        Manejador spam =new ManejadorSpam();

        inicial.setSiguenteManejador( comercial);
        comercial.setSiguenteManejador(tecnico);
        tecnico.setSiguenteManejador(spam);
    }

    public void comprobar(Mail mail){
        inicial.comprobar( mail);
    }
}
