package clinicaDH.controller;

import clinicaDH.dto.OdontologoDto;
import clinicaDH.dto.PacienteDto;
import clinicaDH.service.impl.OdontologoService;
import clinicaDH.service.impl.PacienteService;
import lombok.NoArgsConstructor;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;
import java.util.Set;

@NoArgsConstructor
@RestController
@RequestMapping("/paciente")

public class PacienteController {


    //trabajmos con la service y la inyectamos con los metodos
    @Autowired
    private PacienteService pacienteService;

    //guardar
    @PostMapping()
    public ResponseEntity<?> registrarPaciente (@RequestBody PacienteDto pacienteDTO){
        pacienteService.crear(pacienteDTO);
        return  new ResponseEntity<>(pacienteDTO,HttpStatus.OK);
    }
    //buscar por id
    @GetMapping("/{id}")
    public ResponseEntity<?> buscarId(@PathVariable Integer id){
        PacienteDto pacienteDTO = pacienteService.buscarID(id);
        return new ResponseEntity<>(pacienteDTO,HttpStatus.OK);
    }
    //buscarEmail
    @GetMapping("/email")
    public ResponseEntity<?> buscarEmail(@RequestParam String email) {
        PacienteDto pacienteDTO = pacienteService.findOneByEmail(email);
        return new ResponseEntity<>(pacienteDTO,HttpStatus.OK);
    }
    //Todos
    @GetMapping()
    public ResponseEntity<?> listarTodos(){
        Set<PacienteDto> pacienteDTO = pacienteService.listarTodos();
        return  new ResponseEntity<>(pacienteDTO,HttpStatus.OK);
    }
    //Eliminar
    @DeleteMapping("/{id}")
    public ResponseEntity eliminar(@PathVariable Integer id){
        ResponseEntity response = null;
        if(pacienteService.buscarID(id) ==null){
            response = new ResponseEntity(HttpStatus.NOT_FOUND);
        }else {
            pacienteService.eliminar(id);
            response = new ResponseEntity<>("Paciente eliminado con id: " + id, HttpStatus.OK);
        }
        return response;
    }
    //Modificar
    @PutMapping("/actualizar")
    public ResponseEntity<?> modificar(@RequestBody PacienteDto pacienteDTO){
        ResponseEntity<?> response = null;

        if(pacienteService.buscarID(pacienteDTO.getId()) ==null){
            response = new ResponseEntity(HttpStatus.NOT_FOUND);
        }else{
            pacienteService.modificar(pacienteDTO);
            response = new ResponseEntity<>("Paciente modificado con id: " + pacienteDTO.getId(), HttpStatus.OK);
        }
        return response;
    }
}

