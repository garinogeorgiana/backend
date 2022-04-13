public class ManejadorPeso extends Manejador{
    @Override
    public void comprobar(Articulo art) {
        if ((art.getPeso()<1200)||(art.getPeso()>1300))
        {
            System.out.println("rechazado por peso");
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
