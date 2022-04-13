package clinicaDH.dto;

import clinicaDH.entidades.Odontologo;
import clinicaDH.entidades.Paciente;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

import java.sql.Time;
import java.time.LocalDate;
import java.util.Date;

//anotaciones
@AllArgsConstructor
@NoArgsConstructor
@Setter
@Getter

public class TurnoDto {
    private Integer id;
    private Date fecha;
    private Time hora;
    private Odontologo odontologo;
    private Paciente paciente;

}
