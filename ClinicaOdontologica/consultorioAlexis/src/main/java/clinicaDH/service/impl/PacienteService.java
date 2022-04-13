package clinicaDH.service.impl;

import clinicaDH.dto.PacienteDto;
import clinicaDH.entidades.Paciente;
import clinicaDH.repositorio.IOdontologoRepositorio;
import clinicaDH.repositorio.IPacienteRepositorio;
import clinicaDH.service.IPacienteService;
import com.fasterxml.jackson.databind.ObjectMapper;
import com.sun.istack.NotNull;
import lombok.AllArgsConstructor;
import lombok.NoArgsConstructor;
import org.apache.log4j.Logger;
import org.modelmapper.ModelMapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import java.util.Optional;
import java.util.List;
import java.util.Set;
import java.util.stream.Collectors;

@Service
@AllArgsConstructor
@NoArgsConstructor
public class PacienteService implements IPacienteService {
    private static  final Logger logger = Logger.getLogger(PacienteService.class);

    //tenemos que inyectar el repositorio
    @Autowired
    private IPacienteRepositorio pacienteRepositorio;

    //inyectado del bean del main para mappear
    @Autowired
    private ModelMapper modelMapper;
    @Autowired
    private ObjectMapper objectMapper;

    //creamos metodo guardar
    public void guardarPaciente(PacienteDto pacienteDto){
        Paciente paciente = objectMapper.convertValue(pacienteDto, Paciente.class);
        pacienteRepositorio.save(paciente);
    }

    public void crear (PacienteDto pacienteDto){

        guardarPaciente(pacienteDto);
        logger.info("Se creo al paciente"+ pacienteDto.getApellido()+ " "+ pacienteDto.getNombre() );
    }

    @Override
    public PacienteDto buscarID(@NotNull  Integer id) {
        Optional<Paciente>paciente = pacienteRepositorio.findById(id);
        PacienteDto pacienteDto=null;

        if (paciente.isPresent()){
            pacienteDto = objectMapper.convertValue(paciente, PacienteDto.class);
            logger.info(" Se encontro al paciente"+ pacienteDto.getNombre()+ " "+ pacienteDto.getApellido() );
        }
        return pacienteDto;
    }
    //public Patient findByEmail(String email){
         //  return patientIDao.finByEmail(email);
       //}

    @Override
    public Set<PacienteDto> listarTodos() {
        //1. Creo una lista de todos los pacientes que hay
    List<Paciente> pacienteList = pacienteRepositorio.findAll();
        //2. Los paso a DTO para retornarlos
    Set<PacienteDto>pacienteDtoList = pacienteList.stream().map(p -> mapDTO(p)).collect(Collectors.toSet());
    return pacienteDtoList;
    }

    @Override
    public void eliminar (@NotNull Integer id) {
    //BUSCAR LA ENTIDAD
        Paciente paciente = pacienteRepositorio.getById(id);
        //verificar que se encontro
        //si encontro eliminarla
        pacienteRepositorio.delete(paciente);
    }

    @Override
    public void modificar(PacienteDto pacienteDto) {
        //1. Casteo el pacienteDTO a paciente
        Paciente paciente = mapEntity(pacienteDto);

        //2. Lo guardo al nuevo paciente
        Paciente nuevoPaciente = pacienteRepositorio.save(paciente);

    }



    //----------------- MAPPER------------------//
    private PacienteDto mapDTO(Paciente paciente){
        PacienteDto pacienteDto = modelMapper.map(paciente, PacienteDto.class); //Recibo un paciente y lo paso a DTO
        return pacienteDto;
    }

    private Paciente mapEntity(PacienteDto pacienteDto){
        Paciente paciente = modelMapper.map(pacienteDto, Paciente.class); //Recibo un DTO y lo paso a paciente
        return paciente;
    }

    @Override
    public PacienteDto findOneByEmail(String email) {
        return null;
    }
}
