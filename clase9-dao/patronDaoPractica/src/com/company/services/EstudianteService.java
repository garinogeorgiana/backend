package com.company.services;

import com.company.daos.IDao;
import com.company.entidades.Estudiante;

import java.util.List;

public class EstudianteService {
    private IDao<Estudiante>estudianteIDao;

    //getter y setter
    public IDao<Estudiante> getEstudianteIDao() {
        return estudianteIDao;
    }

    public void setEstudianteIDao(IDao<Estudiante> estudianteIDao) {
        this.estudianteIDao = estudianteIDao;
    }

    //metodos
    public Estudiante guardarEstudiante(Estudiante e){
        //delegamos la resp de guardar al dao
        return estudianteIDao.guardar(e);
    }

    //metodo
    public void eliminarEstudiante(Long id){
        estudianteIDao.eliminar(id);
    }

    public Estudiante buscarEstudiante(Long id){
        return estudianteIDao.buscar(id);
    }

    public List<Estudiante>buscarTodos(){
        return estudianteIDao.buscarTodos();
    }
}
