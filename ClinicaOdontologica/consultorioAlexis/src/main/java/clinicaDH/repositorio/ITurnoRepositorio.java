package clinicaDH.repositorio;

import clinicaDH.entidades.Turno;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface ITurnoRepositorio extends JpaRepository<Turno, Integer> {
}
