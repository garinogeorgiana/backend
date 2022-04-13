package clinicaDH.dto;

import clinicaDH.entidades.Domicilio;
import clinicaDH.entidades.Turno;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

import java.time.LocalDate;
import java.util.Date;
import java.util.Set;

@Getter
@Setter
@NoArgsConstructor
@AllArgsConstructor
public class PacienteDto {
    private Integer id;
    private String nombre;
    private String apellido;
    private String email;
    private String dni;
    private Date fechaAdmision;
    private Domicilio domicilio;
}
