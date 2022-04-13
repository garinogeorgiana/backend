public class ManejadorTecnico extends Manejador{
    @Override
    public void comprobar(Mail mail) {
        if ((mail.getDestino().equalsIgnoreCase("tecnica@colmena.com")) ||
                (mail.getTema().equalsIgnoreCase("Tecnica")))
        {
            System.out.println("Enviando mail a sector tecnico");
        }else{
            if (this.getSiguenteManejador() != null)
            {
                //llamamos al sig metodo
                this.getSiguenteManejador().comprobar(mail);
            }
        }
    }
}
