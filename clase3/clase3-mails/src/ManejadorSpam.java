public class ManejadorSpam extends Manejador{
    @Override
    public void comprobar(Mail mail) {
        System.out.println(" Marcado como spam");
    }
}
