package clinicaDH.repositorio;

import clinicaDH.entidades.Odontologo;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;
import org.springframework.stereotype.Repository;

@Repository
public interface IOdontologoRepositorio extends JpaRepository<Odontologo, Integer> {
//podes hacer consultas fuera de jpa con hibernate
//hace el mapeo con los dintitos

    //hql lenguaje de hibernate para facilitar la consulta a hql
    //hql es mysql orientado a java para facilitar las consultas a la nase de datp
    //on case sensitive
    //con la query hacemos una consulta

    //OJO QUE LAS CLASES SON CASE SENSITIVE CARAJO
    @Query("FROM Odontologo o WHERE o.nombre = :name")
    Odontologo getOdontologoByName(@Param("name")String name);

    //find+nombre de la clase+by+atributo
    //public Odontologo findOdontologoByName(String nombre);
}
