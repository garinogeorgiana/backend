package servicios;

import dao.IDao;
import dao.impl.OdontologoDAOH2;
import entidades.Odontologo;
import org.junit.runner.RunWith;
import org.junit.runners.JUnit4;



import java.util.List;

public class OdontologoService {

    private IDao<Odontologo>odontologoIDao;

    //constructor vacio
    public OdontologoService(){

    }

    public OdontologoService(IDao<Odontologo>odontologoIDao){
        this.odontologoIDao = odontologoIDao;
    }

    public void setOdontologoIDao(IDao<Odontologo>odontologoIDao){
        this.odontologoIDao = odontologoIDao;
    }


    //metodos

    public Odontologo guardarOdontologo(Odontologo odontologo)throws Exception {
        odontologoIDao.guardar(odontologo);
        return odontologo;
    }

    public void eliminarOdontologo(Long id){
        odontologoIDao.eliminar(id);
    }
    public Odontologo buscarUno(Long id){
        return odontologoIDao.buscarUno(id);
    }
    public List<Odontologo>buscarTodos(){
        return odontologoIDao.buscarTodos();
    }

}
