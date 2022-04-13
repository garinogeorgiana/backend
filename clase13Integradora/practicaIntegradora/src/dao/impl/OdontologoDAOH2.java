package dao.impl;

import dao.IDao;
import entidades.Odontologo;
import org.apache.log4j.Logger;
import org.apache.log4j.PropertyConfigurator;

import java.io.File;
import java.sql.*;
import java.util.ArrayList;
import java.util.List;

public class OdontologoDAOH2 implements IDao<Odontologo> {
    //metodo logger
    private static final Logger logger = Logger.getLogger(OdontologoDAOH2.class);

    //coneccion
    private final static String DB_JDBC_DRIVER = "org.h2.Driver";
    private final static String DB_URL = "jdbc:h2:~/test";
    private final static String DB_USER = "sa";
    private final static String DB_PASSWORD = "";

    //CONSTRUCTOR VACIO
    public OdontologoDAOH2() {

    }

    //metodos
    @Override
    public Odontologo guardar(Odontologo odontologo) throws Exception {
        Connection connection = null;
        PreparedStatement preparedStatement = null;

        try {
            //levantar driver
            Class.forName(DB_JDBC_DRIVER);
            connection = DriverManager.getConnection(DB_URL, DB_USER, DB_PASSWORD);

            //crear sentencia
            preparedStatement = connection.prepareStatement("INSERT INTO odontologo (numero_matricula, nombre, apellido) VALUES (?,?,?)", Statement.RETURN_GENERATED_KEYS);
            //No le vamos a pasar el ID ya que hicimos que fuera autoincremental en la base de datos
            preparedStatement.setInt(1, odontologo.getNumeroMatricula());
            preparedStatement.setString(2, odontologo.getNombre());
            preparedStatement.setString(3, odontologo.getApellido());

            //ejecutar sentencia SQL
            preparedStatement.executeUpdate();
            ResultSet keys = preparedStatement.getGeneratedKeys();
            if (keys.next())
                odontologo.setId(keys.getLong(1));
            logger.info("Se creó el odontólogo " + odontologo.getId() + ". Sus datos son: * matrícula n° * " + odontologo.getNumeroMatricula() + ", * nombre * " + odontologo.getNombre() + " y * apellido * " + odontologo.getApellido());

            //cerramos
            preparedStatement.close();
        } catch (SQLException | ClassNotFoundException trowables) {
            trowables.printStackTrace();
            logger.error(trowables);
        }
        return odontologo;
    }

    @Override
    public void eliminar(Long id) {
        Connection connection = null;
        PreparedStatement preparedStatement = null;
        try {
            //Conexion to the DB
            Class.forName(DB_JDBC_DRIVER);
            connection = DriverManager.getConnection(DB_URL, DB_USER, DB_PASSWORD);

            //Create sentence
            preparedStatement = connection.prepareStatement("DELETE FROM odontologo WHERE id = ?");
            preparedStatement.setLong(1, id);

            //Execute a SQL sentence
            preparedStatement.executeUpdate();
            logger.info("Se eliminó el odontólogo con id " + id + " satisfactoriamente");

            preparedStatement.close();
        } catch (SQLException | ClassNotFoundException throwables) {
            throwables.printStackTrace();
            logger.error(throwables);
        } catch (Exception e) {
            e.printStackTrace();
        }
    }


    @Override
    public Odontologo buscarUno(Long id) {
        Connection connection = null;
        PreparedStatement preparedStatement = null;
        Odontologo odontologo1 = null;

        try {
            //levantar driver
            Class.forName(DB_JDBC_DRIVER);
            connection = DriverManager.getConnection(DB_URL, DB_USER, DB_PASSWORD);

            //crear sentencia
            preparedStatement = connection.prepareStatement("SELECT * FROM odontologo WHERE ID = ?");

            //seteamos
            preparedStatement.setLong(1, id);

            //ejecutamos
            ResultSet resultado = preparedStatement.executeQuery();

            //evaluamos resultados
            while (resultado.next()) {
                Long idOdontologo = resultado.getLong("id");
                int matricula = resultado.getInt("numero_matricula");
                String nombre = resultado.getString("nombre");
                String apellido = resultado.getString("apellido");
                //Long id = resultado.getLong("id");
                odontologo1 = new Odontologo(matricula, nombre, apellido);

                logger.info("se busco al odontologo: " + nombre + " " + apellido + " con el numero de matricula " + matricula + " de id" + id);
            }
            preparedStatement.close();
        } catch (SQLException | ClassNotFoundException e) {
            e.printStackTrace();
            logger.error(e);
        } catch (Exception e) {
            e.printStackTrace();
        }
        return odontologo1;
    }

    @Override
    public List<Odontologo> buscarTodos() {
        Connection connection = null;
        PreparedStatement preparedStatement = null;
        List<Odontologo> odontologos = new ArrayList<>();

        try {
            //conectamos driver
            Class.forName(DB_JDBC_DRIVER);
            connection = DriverManager.getConnection(DB_URL, DB_USER, DB_PASSWORD);
            //CREAMOS SENTENCIA
            preparedStatement = connection.prepareStatement("SELECT * FROM odontologo");
            //EJECUTAMOS CON QUERY
            ResultSet resultado = preparedStatement.executeQuery();

            //evaluamos resultado
            while (resultado.next()) {
                Long id = resultado.getLong("id");
                int matricula = resultado.getInt("numero_matricula");
                String nombre = resultado.getString("nombre");
                String apellido = resultado.getString("apellido");

                Odontologo odontologo = new Odontologo(matricula, nombre, apellido);

                odontologos.add(odontologo);
                logger.info("* Odontólogo * con id " + id + "// nombre: " + nombre + " - apellido: " + apellido + " - matrícula n°: " + matricula);

            }
            preparedStatement.close();
        } catch (SQLException | ClassNotFoundException trowables) {
            trowables.printStackTrace();
            logger.error(trowables);
        } catch (Exception e) {
            e.printStackTrace();

        }
        return odontologos;
    }
}
