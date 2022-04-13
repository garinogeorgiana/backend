public class ManejadorGerencia extends Manejador{

    @Override
    public void comprobar(Mail mail) {
        if ((mail.getDestino().equalsIgnoreCase("gerencia@colmena.com")) ||
                (mail.getTema().equalsIgnoreCase("gerencial")))
        {
            System.out.println("Enviando mail a gerencia");
        }else{
            if (this.getSiguenteManejador() != null)
            {
                //llamamos al sig metodo
                this.getSiguenteManejador().comprobar(mail);
            }
        }
    }
}
