package clinicaDH.controller;

import clinicaDH.dto.OdontologoDto;
import clinicaDH.dto.PacienteDto;
import clinicaDH.dto.TurnoDto;
import clinicaDH.service.impl.OdontologoService;
import clinicaDH.service.impl.PacienteService;
import clinicaDH.service.impl.TurnoService;
import lombok.AllArgsConstructor;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;
import java.util.Set;

@AllArgsConstructor
@RequestMapping("/turnos")
@RestController
public class TurnoController {

    @Autowired
    private TurnoService turnoService;



    //Guardar turno
    @PostMapping()
    public ResponseEntity<?> guardarTurno(@RequestBody TurnoDto turnoDTO) {
        turnoService.guardarTurno(turnoDTO);

        return new ResponseEntity<>(turnoDTO, HttpStatus.OK);
    }

    //Mostrar todos
    @GetMapping()
    public ResponseEntity<?> mostrarTurnos() {
        Set<TurnoDto> turnoDTO = turnoService.listarTodos();
        return new ResponseEntity<>(turnoDTO, HttpStatus.OK);
    }

    //Listar 1
    @GetMapping("/{id}")
    public ResponseEntity<?> buscarId(@PathVariable Integer id) {
        TurnoDto turnoDTO = turnoService.buscarID(id);
        return new ResponseEntity<>(turnoDTO, HttpStatus.OK);
    }

    //Actualizar
    @PutMapping("/actualizar")
    public ResponseEntity<?> actualizar(@RequestBody TurnoDto turnoDTO) {
        ResponseEntity response = null;
        if (turnoService.buscarID(turnoDTO.getId()) == null) {
            response = new ResponseEntity<>(turnoDTO, HttpStatus.NOT_FOUND);
        } else {
            turnoService.modificar(turnoDTO);
            response = new ResponseEntity<>("Turno modificado con id: " + turnoDTO.getId() + " " + turnoDTO.getOdontologo() + " " + turnoDTO.getPaciente(), HttpStatus.OK);

        }
        return response;
    }

    @DeleteMapping("/{id}")
    public ResponseEntity<?> eliminar(@PathVariable Integer id) {
        ResponseEntity response = null;
        if (turnoService.buscarID(id) == null) {
            response = new ResponseEntity(HttpStatus.NOT_FOUND);
        } else {
            turnoService.eliminar(id);
            response = new ResponseEntity<>("Turno  eliminado", HttpStatus.OK);
        }
        return  response;
    }
}
