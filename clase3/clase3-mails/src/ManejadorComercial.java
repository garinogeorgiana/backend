public class ManejadorComercial extends Manejador{
    @Override
    public void comprobar(Mail mail) {
        if ((mail.getDestino().equalsIgnoreCase("comercial@colmena.com")) ||
                (mail.getTema().equalsIgnoreCase("Comercial")))
        {
            System.out.println("Enviando mail a sector comercial");
        }else{
            if (this.getSiguenteManejador() != null)
            {
                //llamamos al sig metodo
                this.getSiguenteManejador().comprobar(mail);
            }
        }
    }
}
