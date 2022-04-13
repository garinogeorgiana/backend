package clinicaDH.dto;

//en esta capa voy a poner todos los atributos que quiero
//mostrar en la capa visual
import clinicaDH.entidades.Turno;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

import java.util.Set;

@AllArgsConstructor
@NoArgsConstructor
@Getter
@Setter
public class OdontologoDto {

    //se agregan validaciones
    //ingresar datos de otras tablas
    private Integer id;
    private String nombre;
    private String apellido;
    private String matricula;
}
