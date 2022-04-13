package clinicaDH.service.impl;

import clinicaDH.dto.DomicilioDto;
import clinicaDH.dto.OdontologoDto;
import clinicaDH.entidades.Domicilio;
import clinicaDH.entidades.Odontologo;
import clinicaDH.repositorio.IDomicilioRepositorio;
import clinicaDH.repositorio.IOdontologoRepositorio;
import clinicaDH.service.IDomicilioService;
import com.fasterxml.jackson.databind.ObjectMapper;
import org.apache.log4j.Logger;
import org.modelmapper.ModelMapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.HashSet;
import java.util.List;
import java.util.Optional;
import java.util.Set;

@Service
public class DomicilioService implements IDomicilioService {
    private static  final Logger logger = Logger.getLogger(DomicilioService.class);

    //tenemos que inyectar el repositorio
    @Autowired
    private IDomicilioRepositorio domicilioRepositorio;

    //inyectado del bean del main para mappear
    @Autowired
    private ModelMapper modelMapper;
    @Autowired
    private ObjectMapper objectMapper;

    //metodo guardar
    public void guardarDomicilio (DomicilioDto domicilioDto){
        //convertimos el dato a formato json
        Domicilio domicilio = objectMapper.convertValue(domicilioDto, Domicilio.class);
        domicilioRepositorio.save(domicilio);
    }

    //metodos que vienen por default al implementar

    @Override
    public void crear(DomicilioDto domicilioDto) {
        guardarDomicilio(domicilioDto);
        logger.info("Se creo el domicilio");
    }

    @Override
    public DomicilioDto buscarID(Integer id) {
        Domicilio domicilio = domicilioRepositorio.getById(id);
        return mapDto(domicilio);
    }

    @Override
    public void eliminar(Integer id) {
        domicilioRepositorio.deleteById(id);
        logger.info("Se borro el domicilio");
    }

    @Override
    public void modificar(DomicilioDto domicilioDto) {
        guardarDomicilio(domicilioDto);
        logger.info("Se modifico el usuario");
    }

    @Override
    public Set<DomicilioDto> listarTodos() {
        List<Domicilio>domicilios = domicilioRepositorio.findAll();

        //recorremos la lista
        Set<DomicilioDto>domiciliosDtos = new HashSet<>();

        for (Domicilio domicilio: domicilios){
            domiciliosDtos.add(objectMapper.convertValue(domicilio, DomicilioDto.class));
            logger.info(" Se encontro al domicilio" + domicilio.getCalle()+ " "+ domicilio.getLocalidad()+ " " + " fue encontrado");

        }
        return domiciliosDtos;
    }

    //------mapper------
    //se usa para castear del odontologo al dto
    //metodo mapper

    private DomicilioDto mapDto(Domicilio domicilio){
        DomicilioDto domicilioDto = modelMapper.map(domicilio, DomicilioDto.class);
        return domicilioDto;
    }

    //metodo mapper create
    private Domicilio mapEntity(DomicilioDto domicilioDto){
        Domicilio domicilio = modelMapper.map(domicilioDto, Domicilio.class);
        return domicilio;
    }
}
