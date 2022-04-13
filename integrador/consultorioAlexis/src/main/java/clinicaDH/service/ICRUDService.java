package clinicaDH.service;

import clinicaDH.dto.OdontologoDto;

import java.util.Set;

//es una interfaz general tipo padre
//va a recibir un tipo
public interface ICRUDService<T> {
    public void crear(T t);
    public T buscarID(Integer id);
    Set<T> listarTodos();
    public void modificar(T t);
    public void eliminar(Integer id);
}
