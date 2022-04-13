public class ManejadorLote extends Manejador{
    @Override
    public void comprobar(Articulo art) {
        if ((art.getLote()<1000)||(art.getLote()>2000))
        {
            System.out.println("rechazado por lote");
        }
        else
        {
            if (this.getSiguienteManejador() != null)
            {
                //llamamos al metodo en el sig objeto
                this.getSiguienteManejador().comprobar(art);
            }
        }
    }
}
