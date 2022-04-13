public class Ejecutable {
    private static final String SQL_CREATE_TABLE = "DROP TABLE IF EXISTS ODONTOLOGO; CREATE TABLE ODONTOLOGO "
            + "("
            + " ID INT PRIMARY KEY,"
            + " NOMBRE varchar(100) NOT NULL, "
            + " APELLIDO varchar(100) NOT NULL,"
            + " MATRICULA varchar(100) NOT NULL,"
            + " )";

    private static final String SQL_INSERT =  "INSERT INTO ODONTOLOGO (ID, NOMBRE, APELLIDO, MATRICULA) VALUES (?,?,?,?)";
    private static final String SQL_UPDATE =  "UPDATE ODONTOLOGO SET matricula =? WHERE ID=?";

    //
    public static void main(String[] args) throws Exception{
    //creo usuario

        Odontologo odontolo = new Odontologo("georgiana","garino","12542552");

    }
}
