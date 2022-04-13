import java.io.File;
import java.io.FileOutputStream;
import java.io.IOException;
import java.io.ObjectOutputStream;
import java.util.ArrayList;
import java.util.List;

public class Main {
    public static void main(String[] args) {

        /**creo la lista de contactos VACIA EN UNA LISTA*/
        List<Contacto> contactos = new ArrayList<>();

        //creo los contactos UNO POR UNO
        Contacto contacto1 = new Contacto("");

        //agrego los contactos a la lista CREADA
        contactos.add(contacto1);

        //creamos el OBjeto de entrada Y LUEGO EL DE SALIDA
        //me paro en el fileoutputstream y creo en try catch
        try {
            FileOutputStream fil(NOMBRE QUE QUIERO) = new FileOutputStream("contacto.txt");
            ObjectOutputStream archivo = new ObjectOutputStream(fil);
            //writeobjetc no graba la lista de contactos
            archivo.writeObject(contactos);

        } catch (FileOutputStream e) {
            e.print
        } catch (IOException e) {
            e.printStackTrace();
        }

        /** deserializar: crear el objeto de salida*/
        try{
            FileOutputStream filin = new FileOutputStream()
        }catch (){

        }
    }
}
