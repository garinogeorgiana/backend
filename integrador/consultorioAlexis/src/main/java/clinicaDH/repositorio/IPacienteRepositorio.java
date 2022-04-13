package clinicaDH.repositorio;

import clinicaDH.entidades.Paciente;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;
import org.springframework.stereotype.Repository;

import java.util.Optional;

@Repository
public interface IPacienteRepositorio extends JpaRepository<Paciente, Integer> {

    @Query("select p from Paciente p where p.email like %:email%")
    Optional<Paciente> findOnePatientByEmail(@Param("email")String email);
}
