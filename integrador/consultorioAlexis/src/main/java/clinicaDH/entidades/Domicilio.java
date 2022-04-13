package clinicaDH.entidades;

import lombok.*;

import javax.persistence.*;
import java.util.Objects;

//anotacion
@Getter
@Setter
@ToString
@NoArgsConstructor
@AllArgsConstructor
@Entity
//tablas siempre en plural
@Table(name = "Domicilios")

public class Domicilio {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Integer id;
    @Column
    private String calle;
    @Column
    private String numero;
    @Column
    private String localidad;
    @Column
    private String provincia;


    //tostring
    @Override
    public String toString() {
        return "Domicilio{" +
                "id=" + id +
                ", calle='" + calle + '\'' +
                ", numero='" + numero + '\'' +
                ", localidad='" + localidad + '\'' +
                ", provincia='" + provincia + '\'' +
                '}';
    }

    //hashcode y equals
    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        Domicilio domicilio = (Domicilio) o;
        return Objects.equals(id, domicilio.id);
    }

    @Override
    public int hashCode() {
        return Objects.hash(id);
    }
}
