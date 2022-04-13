package com.company.daos;

import com.company.entidades.Estudiante;

import java.sql.Connection;
import java.sql.DriverManager;
import java.util.List;

public class EstudianteDaoH2 implements IDao<Estudiante>{

    private final static String DB_JDBC_DRIVER = "org.h2.Driver";
    private final static String DB_URL = "jdbc:h2:~/test";
    private final static String DB_USER = "sa";
    private final static String DB_PASSWORD = "";
    @Override
    public Estudiante guardar(Estudiante estudiante) {
        return null;
    }
    Connection connection = null;

    //LEVABTAR EL DRIVER Y CONECTARNOS
    Class.forName(DB_JDBC_DRIVER);
    connection = DriverManager.getConnection

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
