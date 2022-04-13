import dao.impl.OdontologoDAOH2;
import entidades.Odontologo;
import servicios.OdontologoService;

import java.util.List;


public class Main {
    public static void main(String[] args) throws Exception {
        Odontologo odontologo1 = new Odontologo(123456789,"Georgiana","garino");
        Odontologo odontologo2 = new Odontologo(987654321,"Luis","de la puente");
        Odontologo odontologo3 = new Odontologo(654987321,"Martha","gallo");
        Odontologo odontologo4 = new Odontologo(123789456,"luis alberto","de la Puente JR");

        OdontologoService odontologoService = new OdontologoService();

        odontologoService.setOdontologoIDao(new OdontologoDAOH2());
        odontologoService.guardarOdontologo(odontologo1);
        odontologoService.guardarOdontologo(odontologo2);
        odontologoService.guardarOdontologo(odontologo3);
        odontologoService.guardarOdontologo(odontologo4);

        //odontologoService.eliminarOdontologo(4L);
        odontologoService.buscarUno(1L);
        odontologoService.buscarTodos();
    }

}
