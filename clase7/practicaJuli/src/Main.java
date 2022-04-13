import org.apache.log4j.BasicConfigurator;
import org.apache.log4j.Logger;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.ResultSet;
import java.sql.Statement;


public class Main {
    private static final Logger logger = Logger.getLogger(Main.class);

    public static void main(String[] args){
        //BasicConfigurator.configure();

        try {
            Class.forName("org.h2.Driver").newInstance();
            //jdbc:h2:~/test
            Connection conexion = DriverManager.getConnection("jdbc:h2:"+
                    "~/test", "sa", "");
            Statement stmt = conexion.createStatement();

            //vamos a crear la tabla en la base de datos
            String creacionDeTable = "DROP TABLE IF EXISTS TEST;\n" +
                    "CREATE TABLE TEST(ID INT PRIMARY KEY, NAME VARCHAR(255), EDAD INT) ;\n";
            stmt.execute(creacionDeTable);

            //vamos a insertar datos
            String insertar="INSERT INTO TEST VALUES (1,'JUAN',23)";
            stmt.execute(insertar);

            //consulta bases de datos
            String consulta="SELECT * FROM TEST;";

            ResultSet tabla = stmt.executeQuery(consulta);



            while (tabla.next()){
                System.out.println(tabla.getString(2)instanceof String);
            }

            conexion.close();

        }catch (Exception e){
           logger.info("esto es un error: ", e);
        }


    }
}
