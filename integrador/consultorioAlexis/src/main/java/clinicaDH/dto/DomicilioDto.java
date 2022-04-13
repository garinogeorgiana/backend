package clinicaDH.dto;

import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

import javax.persistence.Column;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;

//notaciones
@Getter
@Setter
@NoArgsConstructor
@AllArgsConstructor
public class DomicilioDto {
    //validaciones
    //atributos
    private Integer id;
    private String calle;
    private String numero;
    private String localidad;
    private String provincia;
}
