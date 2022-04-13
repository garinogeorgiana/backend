package clinicaDH.controller;

import clinicaDH.dto.OdontologoDto;
import clinicaDH.service.impl.OdontologoService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.rmi.ServerException;
import java.util.List;
import java.util.Set;

@RestController
@RequestMapping("api/odontologos")
public class OdontologoController {

    //trabajmos con la service y la inyectamos con los metodos
    @Autowired
    private OdontologoService odontologoService;

    //metodos

    //http://localhost:8080/api/odontologos
    //guardar
    @PostMapping
    public ResponseEntity<?>crearOdontologo(@RequestBody OdontologoDto odontologoDto){
        odontologoService.crear(odontologoDto);
        return new ResponseEntity<>("Se creó el odontologo: " + odontologoDto.getNombre() + " " + odontologoDto.getApellido(), HttpStatus.OK);
    }

    //http://localhost:8080/api/odontologos/1
    @GetMapping("/{id}")
    public ResponseEntity<?>buscarId(@PathVariable("id")Integer id){
        OdontologoDto odontologoDto = odontologoService.buscarID(id);
        return new ResponseEntity<>("Se encontro el odontologo: " + odontologoDto.getNombre() + " " + odontologoDto.getApellido(), HttpStatus.OK);
    }


    //http://localhost:8080/api/odontologos/listar
    //Listar todos
    @GetMapping("/listar")
    public ResponseEntity<?> listarTodos(){
        Set<OdontologoDto> odontologoDTO = odontologoService.listarTodos();
        return  ResponseEntity.ok(odontologoDTO);
    }

    //http://localhost:8080/api/odontologos/3
    @DeleteMapping("/{id}")
    public ResponseEntity eliminar(@PathVariable("id") Integer id){
        ResponseEntity response = null;
        //si lo encuentra
        if(odontologoService.buscarID(id) == null){
            response = new ResponseEntity(HttpStatus.NOT_FOUND);
        }else{
            odontologoService.eliminar(id);
            response = new ResponseEntity<>("Odontólogo eliminado con id: " + id, HttpStatus.OK);
        }
        return response;
    }

    //http://localhost:8080/api/odontologos/name?name=javier
    @GetMapping("/name")
    public ResponseEntity<OdontologoDto>findByName(@RequestParam String name){
        OdontologoDto odontologoDto=odontologoService.getOdontologoByName(name);
        return new ResponseEntity<>(odontologoDto, HttpStatus.OK);
    }
    //http://localhost:8080/api/odontologos/actualizar
    //{
    //    "id": 4,
    //    "nombre": "usuario",
    //    "apellido": "manuel actualizado",
    //    "matricula": "858477"
    //}
    @PutMapping("/actualizar")
    public ResponseEntity<?> modificar(@RequestBody OdontologoDto odontologoDTO){
        ResponseEntity<String> response = null;

        //si lo encuentra
        if(odontologoService.buscarID(odontologoDTO.getId()) == null){
            response = new ResponseEntity<>(HttpStatus.NOT_FOUND);
        }else{
            odontologoService.modificar(odontologoDTO);
            response = new ResponseEntity<>("Se modifico al odontologo con id: " + odontologoDTO.getId() , HttpStatus.OK);


        }
        return response;
    }





}
