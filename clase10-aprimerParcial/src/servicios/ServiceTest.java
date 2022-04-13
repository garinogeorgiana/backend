package servicios;

import dao.IDao;
import dao.impl.OdontologoDAOH2;
import entidades.Odontologo;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

public class ServiceTest {
    private IDao<Odontologo>odontologoTest1 = new OdontologoDAOH2();
    private OdontologoService odontologoServiceTest1 = new OdontologoService();

    @BeforeEach
    void setUp()throws Exception {
        Odontologo odontologo1 = new Odontologo(123456789, "Georgiana", "garino");
        Odontologo odontologo2 = new Odontologo(458763215, "Macarena", "de la puente");
        Odontologo odontologo3 = new Odontologo(445876215, "juliana", "garcia");
        Odontologo odontologo4 = new Odontologo(123789456, "luis alberto", "de la Puente JR");

        odontologoServiceTest1.setOdontologoIDao(odontologoTest1);

        //odontologoServiceTest1.guardarOdontologo(odontologo1);
       // odontologoServiceTest1.guardarOdontologo(odontologo2);
        //odontologoServiceTest1.guardarOdontologo(odontologo3);
        //odontologoServiceTest1.guardarOdontologo(odontologo4);
    }

    @Test
    void listarTodos() {
        odontologoServiceTest1.buscarTodos();
    }
}




