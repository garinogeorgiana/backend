package clinicaDH.service.impl;

import clinicaDH.dto.TurnoDto;
import clinicaDH.entidades.Turno;
import clinicaDH.repositorio.ITurnoRepositorio;
import clinicaDH.service.ITurnoService;
import com.fasterxml.jackson.databind.ObjectMapper;
import lombok.AllArgsConstructor;
import lombok.NoArgsConstructor;
import org.apache.log4j.Logger;
import org.modelmapper.ModelMapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;
import java.util.Set;
import java.util.stream.Collectors;

@Service
@NoArgsConstructor
@AllArgsConstructor
public class TurnoService implements ITurnoService {

    private static  final Logger logger = Logger.getLogger(PacienteService.class);

    @Autowired
    private ITurnoRepositorio turnoRepositorio;

    @Autowired
    private ModelMapper modelMapper;

    @Autowired
    private ObjectMapper objectMapper;


    //hacemos este metodo
    public void guardarTurno(TurnoDto turnoDto){
        Turno turno = objectMapper.convertValue(turnoDto, Turno.class);
        turnoRepositorio.save(turno);
    }

    @Override
    public void crear (TurnoDto turnoDto) {
        guardarTurno(turnoDto);
    }

    @Override
    public TurnoDto buscarID(Integer id) {
        Optional<Turno>turno = turnoRepositorio.findById(id);
        TurnoDto turnoDto = null;

        if (turno.isPresent()){
            turnoDto = objectMapper.convertValue(turno, TurnoDto.class);

        }
        return turnoDto;
    }

    @Override
    public void eliminar(Integer id) {
        Turno turno = turnoRepositorio.getById(id);
        turnoRepositorio.delete(turno);

    }

    @Override
    public void modificar(TurnoDto turnoDto) {
        guardarTurno(turnoDto);
    }

    @Override
    public Set<TurnoDto> listarTodos() {
        List<Turno>turnoList = turnoRepositorio.findAll();
        Set<TurnoDto>turnoDtoList=turnoList.stream().map(a -> mapDTO(a)).collect(Collectors.toSet());
        return turnoDtoList;
    }
    //------ MAPPER----
    private TurnoDto mapDTO(Turno turno){
        TurnoDto turnoDto = modelMapper.map(turno, TurnoDto.class); //Recibo un turno y lo paso a DTO
        return turnoDto;
    }

    private Turno mapEntity(TurnoDto turnoDto){
        Turno turno = modelMapper.map(turnoDto, Turno.class); //Recibo un DTO y lo paso a turno
        return turno;
    }

}
