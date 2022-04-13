package clinicaDH.service;


import clinicaDH.dto.OdontologoDto;
import clinicaDH.entidades.Odontologo;

//es la interfaz de la entidad mas especifico
//el crud recibe un tipo odontologo para trabajar con dto
//esta interfaz hererda la del padre
public interface IOdontologoService extends ICRUDService<OdontologoDto>{
    OdontologoDto getOdontologoByName(String name);
    //podriamos poder metodos propios de la clase odontologos

}
