public class CheckFacade {
    private AvionAPI  avionAPI;
    private HotelAPI hotelAPI;

    //constructor
    public CheckFacade(){
        avionAPI=new AvionAPI();
        hotelAPI=new HotelAPI();
    }

    //metodo que utiliza los objetos y que relacione los resultados de ambos y los llame
    public void buscar(String fechaIda, String fechaVuelta, String origen, String destino){
        avionAPI.buscarVuelos(fechaIda,fechaVuelta,origen,destino);
        hotelAPI.buscarHoteles(fechaIda,fechaVuelta,destino);
    }
}
