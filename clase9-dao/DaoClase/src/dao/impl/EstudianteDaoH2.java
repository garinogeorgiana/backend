package dao.impl;

import dao.IDao;
import model.Estudiante;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.util.List;

public class EstudianteDaoH2 implements IDao<Estudiante>{
    private final static String DB_JDBC_DRIVER = "org.h2";
    private final static String DB_URL = "";
    private final static String DB_USER = "";
    private final static String DB_PASSWORD = "";


    @Override
    public Estudiante guardar(Estudiante estudiante) {
        Connection connection = null;
        PreparedStatement preparedStatement = null;
    }

    @Override
    public void eliminar(Long id) {

    }

    @Override
    public Estudiante buscar(Long id) {
        return null;
    }

    @Override
    public List<Estudiante> buscarTodos() {
        return null;
    }
}
