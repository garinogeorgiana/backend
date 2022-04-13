import java.io.*;
import java.util.ArrayList;
import java.util.List;

public class Main {
    public static void main(String[] args) {

        //creamos la lista vacia
        List<Contacto>contactos = new ArrayList<>();

        //cremos los contactos
        Contacto c1 = new Contacto("felipe", "felipe@digitalhouse.com",123456);
        Contacto c2 = new Contacto("luis", "luis@digitalhouse.com",258369);
        Contacto c3 = new Contacto("georgi", "georgi@digitalhouse.com",147852);
        Contacto c4 = new Contacto("sebas", "sebas@digitalhouse.com",159357);
        Contacto c5 = new Contacto("zoe", "zoe@digitalhouse.com",154953);
        Contacto c6 = new Contacto("grego", "grego@digitalhouse.com",953564);

        //agregamos los contactos a una lista
        contactos.add(c1);
        contactos.add(c2);
        contactos.add(c3);
        contactos.add(c4);
        contactos.add(c5);
        contactos.add(c6);

        //creamos el objeto de entrada y le metemos el try catch

        try {
            //SERIALIZAR CREAMOS objeto de salida
            FileOutputStream fil = new FileOutputStream("contactos.txt");
            ObjectOutputStream archivo = new ObjectOutputStream(fil);
            //lo escribimos al archivo
            archivo.writeObject(contactos);
            archivo.close();

        } catch (FileNotFoundException e) {
            System.out.println(" error" +e.getMessage() );;
        } catch (IOException e) {
            System.out.println(" error" + e.getMessage());;
        }

        //DESSERIALIZAMOS CREAMOS OBJETO DE ENTRAD
        //archivo para leerlo
        try {
            FileInputStream filin = new FileInputStream("contactos.txt");
            ObjectInputStream archi = new ObjectInputStream(filin);
            ArrayList<Contacto>cont;
            cont = (ArrayList<Contacto>) archi.readObject();

        } catch (FileNotFoundException e) {
            e.printStackTrace();
        } catch (IOException e) {
            e.printStackTrace();
        } catch (ClassNotFoundException e) {
            e.printStackTrace();
        }
        //Creo un ForEach para imprimir cada contactos
        for (Contacto contacto : contactos) {
            System.out.println(contacto);
        }
    }
}
