package service;

import dao.IDao;
import model.Estudiante;

import java.util.List;

public class EstudianteService {
    private IDao<Estudiante> estudianteDao;

    //constructor
    public EstudianteService(IDao<Estudiante> estudianteDao) {
        this.estudianteDao = estudianteDao;
    }

    //getter y setter
    public IDao<Estudiante> getEstudianteDao() {
        return estudianteDao;
    }

    public void setEstudianteDao(IDao<Estudiante> estudianteDao) {
        this.estudianteDao = estudianteDao;
    }

    //metodos y todos con el estudiantedao en los service
    public Estudiante guardarEstudiante(Estudiante estudiante){
        estudianteDao.guardar(estudiante);
        return estudiante;
    }

    public void eliminarEstudiante(Long id){
        estudianteDao.eliminar(id);
    }

    public Estudiante buscar (Long id){
        return estudianteDao.buscar(id);
    }

    public Estudiante buscarTodos(List){
        return estudianteDao.buscarTodos();
    }

    //constructor vacio
    public EstudianteService(){

    }
}
