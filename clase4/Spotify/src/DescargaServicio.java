public class DescargaServicio implements DescargaSpotify{
    @Override
    public void descarga(Usuario usuario, String cancion) {
        System.out.println("Usuario ID: "+usuario.getId()+", descargo: "+ cancion);
    }
}
