package dao;

import entidades.Odontologo;

import java.util.List;

public interface IDao <T>{
    public T guardar (T t) throws Exception;
    public void eliminar (Long id);
    public T buscarUno (Long id);
    public List<T>buscarTodos();
}
