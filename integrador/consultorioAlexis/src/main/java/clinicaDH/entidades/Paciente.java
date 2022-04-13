package clinicaDH.entidades;

import com.fasterxml.jackson.annotation.JsonIgnore;
import lombok.*;

import javax.persistence.*;
import java.util.Date;
import java.util.HashSet;
import java.util.Objects;
import java.util.Set;

//anotacion

@Setter
@Getter
@ToString
@NoArgsConstructor
@AllArgsConstructor
@Entity
//tabla
@Table(name = "Pacientes")
//notaciones

public class Paciente {
    //id
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Integer id;
    //atributos
    @Column
    private String nombre;
    @Column
    private String apellido;
    @Column
    private String email;
    @Column
    private int dni;
    @Column
    private String numeroIdentidad;
    @Column
    private Date fechaAdmision;

    //relaciones entre tablas
    //relacion con domicilios UNIDIRECCIONAL
    //en paciente vamos a ver los domicilios pero en dmicilios no vamos a poder tener la info de ususario
    //la carga es eager, ansiosa, cuando llamamos a paciente nos va a traer el domicilio
    //si es lazy solo lo va a traer cuando se lo pidamos


    //paciente con domicilio
    @OneToOne(cascade = CascadeType.ALL)
    //en el join tenemos que aclarar 2 cosas
    //como se llama la columna en la tabla paciente (id_domicilio) tabla foranea
    // mientras que la segunda es el lugar donde vamos a matchear)
    @JoinColumn(name = "id_domicilio", referencedColumnName = "id")
    private Domicilio domicilio;

    //relacion con turnos
    //sin fetch y sin cascade te trae el array de turnos
    @OneToMany(mappedBy = "paciente", fetch = FetchType.LAZY, cascade = CascadeType.MERGE)
    //para que no se haga un bucle infinito porque es una lista, sin json ignore trae array
    @JsonIgnore
    private Set<Turno> turnos = new HashSet<>();


    //toString
    @Override
    public String toString() {
        return "Paciente{" +
                "id=" + id +
                ", nombre='" + nombre + '\'' +
                ", apellido='" + apellido + '\'' +
                ", email='" + email + '\'' +
                ", numeroIdentidad='" + numeroIdentidad + '\'' +
                ", fechaAdmision=" + fechaAdmision +
                '}';
    }

    //hashcode y equals

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        Paciente paciente = (Paciente) o;
        return Objects.equals(id, paciente.id);
    }

    @Override
    public int hashCode() {
        return Objects.hash(id);
    }




}
