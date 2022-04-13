package clinicaDH.entidades;

import lombok.*;

import javax.persistence.*;
import java.sql.Time;
import java.util.Date;

//anotacion
@Getter
@Setter
@ToString
@NoArgsConstructor
@AllArgsConstructor
@Entity
@Table(name = "Turnos")
//tabla
public class Turno {
    //atributos
    //id
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Integer id;
    private Date fecha;
    private Time hora;

    //relaciones CON LAS OTRAS ENTIDADES
    //SIN LOS DOS EAGER TRAE ARRAY TURNOS

    @ManyToOne(fetch = FetchType.EAGER, cascade = CascadeType.MERGE)
    @JoinColumn(name = "id_odontologo", nullable = false)
    private Odontologo odontologo;

    @ManyToOne(fetch = FetchType.EAGER, cascade = CascadeType.MERGE)
    //es com la forenky
    @JoinColumn(name = "id_paciente", referencedColumnName = "id", nullable = false)
    private Paciente paciente;


    //to String
    @Override
    public String toString() {
        return "Turno{" +
                "id=" + id +
                ", fecha=" + fecha +
                ", hora=" + hora +
                ", odontologo=" + odontologo +
                ", paciente=" + paciente +
                '}';
    }
}
