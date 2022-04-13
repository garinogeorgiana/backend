import java.io.*;
import java.util.ArrayList;
import java.util.List;

public class Main {
    public static void main(String[] args){
        /*
        //Contacto contacto1 = new Contacto("Juli", "juli@documentacio","666" );
        Empleado empleado1 = new Empleado("wilmar","puerta", "1234", 2000.0);
        Empleado empleado2 = new Empleado ("tomi", "romero", "4567", 5000.0);
        Empleado empleado3 = new Empleado ("alejandro", "ceballo", "7890", 3000.0);

        List<Empleado> empleados = new ArrayList<>();

        empleados.add(empleado1);
        empleados.add(empleado2);
        empleados.add(empleado3);

        Empresa empresa = new Empresa("1234567890", "Hakuna Matata", empleados);


        //Guardamos el objeto en un archivo
        try{
            FileOutputStream fo = new FileOutputStream("OutputFile.txt");
            ObjectOutputStream oos = new ObjectOutputStream(fo);
            oos.writeObject(empresa);
            oos.close();

        }catch (Exception e){
            System.out.println(e.getMessage());
        }
        */
        /*Recuperamos el objeto en un archivo*/
        Empresa empresa1 = null;

        try{
            FileInputStream fi = new FileInputStream("OutputFile.txt");
            ObjectInputStream ois = new ObjectInputStream(fi);
            empresa1 = (Empresa) ois.readObject();
            System.out.println(empresa1.toString());

        }catch (Exception e) {
            System.out.println(e.getMessage());

        }

        //Guardar en archivo empleado txt

        FileWriter fileWriter = null;
        try{
            fileWriter = new FileWriter("./empleados.txt");
            String fileContent = empresa1.toStringEmpleados();
            fileWriter.write(fileContent);
            fileWriter.close();

        } catch (Exception e) {
            System.out.println(e.getMessage());
        }
    }
}
