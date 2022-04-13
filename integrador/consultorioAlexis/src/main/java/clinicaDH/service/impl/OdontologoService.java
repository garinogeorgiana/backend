package clinicaDH.service.impl;

//es un paquete para trabajar con las implementaciones de forma global
//capa de logica service

import clinicaDH.dto.OdontologoDto;
import clinicaDH.entidades.Odontologo;
import clinicaDH.repositorio.IOdontologoRepositorio;
import clinicaDH.service.IOdontologoService;
import com.fasterxml.jackson.databind.ObjectMapper;
import org.apache.log4j.Logger;
import org.modelmapper.ModelMapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.HashSet;
import java.util.Optional;
import java.util.Set;
import java.util.List;
import java.util.stream.Collectors;

@Service
public class OdontologoService implements IOdontologoService {

    private static  final Logger logger = Logger.getLogger(OdontologoService.class);

    //PARA ACCEDER A CAPA DATOS NECEsiTO REPOSITORY
    //tenemos que inyectar el repositorio
    @Autowired
    private IOdontologoRepositorio odontologoRepositorio;

    //inyectado del bean del main para mappear
    //como uso dtos necesitamos mapper

    @Autowired
    ObjectMapper objectMapper;

    @Autowired
    ModelMapper modelMapper;

    //CREAMOS EL METODOD GUARADAR
    public void guardarOdontologo(OdontologoDto odontologoDto){
        //convertimos en json al dato
        Odontologo odontologo = objectMapper.convertValue(odontologoDto, Odontologo.class);
        odontologoRepositorio.save(odontologo);
    }


    //metodos que vienen por default al implementar
    //no lleva id el create, el update si
    @Override
    public void crear(OdontologoDto odontologoDto) {

        guardarOdontologo(odontologoDto);
        logger.info("Se guardo al odontologo"+ odontologoDto.getNombre()+" "+ odontologoDto.getApellido() + "de id" + odontologoDto.getId());

        //tenemos dto que recibimos por parametro
        //dto convertir a entidad
        //Odontologo odontologo = mapEntity(odontologoDto);
        //entidad guardamos en la base de datos
        //Odontologo newOdontologoSave = odontologoRepositorio.save(odontologo);
        //entidad guardada se retorna como dto
        //return mapDto(newOdontologoSave);

    }

    @Override
    public OdontologoDto buscarID(Integer id) {
        //le da la oportunidad de preguntar si el odontologo no es nulo
        Optional<Odontologo>odontologo = odontologoRepositorio.findById(id);
        OdontologoDto odontologoDto = null;

        //si lo encuentra y es diferente a nulo va a estar presente
        if (odontologo.isPresent()){
            odontologoDto = objectMapper.convertValue(odontologo, OdontologoDto.class);
        }
        logger.info("Se encontro al odontologo"+odontologoDto.getNombre()+ " "+ odontologoDto.getApellido() );
        return  odontologoDto;
    }

    //mandamos id
    //si el id existe el metodo save lo updatea
    @Override
    public void modificar(OdontologoDto odontologoDto) {
        guardarOdontologo(odontologoDto);
        logger.info("Se modifico al odontologo"+odontologoDto.getNombre()+ " "+ odontologoDto.getApellido() );
        //el mismo que create
        //dto convertir a entidad
        //Odontologo odontologo = mapEntity(odontologoDto);
        //entidad guardamos en la base de datos
        //Odontologo newOdontologoSave = odontologoRepositorio.save(odontologo);
        //entidad guardada se retorna como dto
        //return mapDto(newOdontologoSave);
    }

    @Override
    public void eliminar(Integer id) {
        //1-buscar entidad
        Odontologo odontologo = odontologoRepositorio.getById(id);
        //2-verificar que se encontro
        odontologoRepositorio.delete(odontologo);
        //3-si se encuentra eliminarla
    }
    @Override
    public Set<OdontologoDto> listarTodos() {
        List<Odontologo> odontologoList = odontologoRepositorio.findAll();
        //recorremos lista para agregar
        Set<OdontologoDto> odontologoDtoList = new HashSet<>();

        for (Odontologo odontologo : odontologoList){
            odontologoDtoList.add(objectMapper.convertValue(odontologo, OdontologoDto.class));
            logger.info("Se encontro al odontologo"+ odontologo.getNombre()+odontologo.getApellido()+ " fue encontrado");
        }
        return odontologoDtoList;
    }

    @Override
    public OdontologoDto getOdontologoByName(String name) {
        Odontologo odontologo=odontologoRepositorio.getOdontologoByName(name);
        return mapDto(odontologo);
    }

    //------mapper------
    //se usa para castear del odontologo al dto
    //metodo mapper

    private OdontologoDto mapDto(Odontologo odontologo){
        OdontologoDto odontologoDto = modelMapper.map(odontologo, OdontologoDto.class);
        return odontologoDto;
    }

    //metodo mapper create
    private Odontologo mapEntity(OdontologoDto odontologoDto){
        Odontologo odontologo = modelMapper.map(odontologoDto, Odontologo.class);
        return odontologo;
    }


}
