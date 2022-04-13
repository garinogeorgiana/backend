import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.ResultSet;
import java.sql.Statement;

public class Main {

    static Empleado Georgiana = new Empleado(1L," Georgiana ",27," Digital House", " 02-06-2021");
    static Empleado Alan = new Empleado(2L," Alan ",35," Google", " 18-02-1993");
    static Empleado Luis = new Empleado(3L," Luis ",32," Facebook", " 01-04-1986");

    public static void main(String[] args) throws Exception {
        Class.forName("org.h2.Driver").newInstance();
        //jdbc:h2:~/test
        Connection con = DriverManager.getConnection("jdbc:h2:"+
                "~/test", "sa", "");
        Statement stmt = con.createStatement();

        //Código para crear una tabla. Elimina la tabla si esta ya existe y la
        //vuelve a crear
        String createSql = "DROP TABLE IF EXISTS TEST;\n" +
                "CREATE TABLE TEST(ID INT PRIMARY KEY, NAME VARCHAR(255), EDAD INT, EMPRESA VARCHAR(255), FECHA_INGRESO VARCHAR(255));\n" +
                "INSERT INTO TEST VALUES("+Georgiana.getId()+", '"+ Georgiana.getNombre()+"', "+ Georgiana.getEdad()+", '"+ Georgiana.getEmpresa()+"', '"+ Georgiana.getFechaInicio()+"');\n" +
                "INSERT INTO TEST VALUES("+Alan.getId()+", '"+ Alan.getNombre()+"', "+ Alan.getEdad()+", '"+ Alan.getEmpresa()+"', '"+ Alan.getFechaInicio()+"');\n" +
                "INSERT INTO TEST VALUES("+Luis.getId()+", '"+ Luis.getNombre()+"', "+ Luis.getEdad()+", '"+ Luis.getEmpresa()+"', '"+ Luis.getFechaInicio()+"')\n";

        stmt.execute(createSql);

        //Codigo para consultar todos los registros de la tabla TEST
        String sql = "select * from TEST";
        ResultSet rd = stmt.executeQuery(sql);

        //Código para recorrer el resultado de la consulta
        while(rd.next()) {
            System.out.println(rd.getInt(1) + rd.getString(2) + rd.getInt(3) +rd.getString(4)+rd.getString(5));
        }
    }
}