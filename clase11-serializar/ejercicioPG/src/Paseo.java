import java.io.*;
import java.util.ArrayList;

public class Paseo {
    public static void main(String[] args) {


        //creo los perros
        Perro p1 = new Perro("pipo", "doberman", 1, "alem 1048");
        Perro p2 = new Perro("juan", "ovejero", 2, "rivadavia 14");
        Perro p3 = new Perro("lui", "pekines", 3, "yapeyu 123");
        Perro p4 = new Perro("smith", "salchicha", 4, "juarez 3454");

        //hago una lista para cada dia de la semana
        ArrayList<Perro> lunes = new ArrayList<Perro>();
        ArrayList<Perro> martes = new ArrayList<Perro>();
        ArrayList<Perro> miercoles = new ArrayList<Perro>();
        ArrayList<Perro> jueves = new ArrayList<Perro>();
        ArrayList<Perro> viernes = new ArrayList<Perro>();

        lunes.add(p1);
        miercoles.add(p1);
        viernes.add(p1);

        lunes.add(p2);
        martes.add(p2);
        miercoles.add(p2);
        jueves.add(p2);

        miercoles.add(p3);
        jueves.add(p3);
        viernes.add(p3);

        lunes.add(p4);
        martes.add(p4);
        miercoles.add(p4);
        jueves.add(p4);
        viernes.add(p4);

        //grabatodo el array list de perros en un archivo para leer e imprimir en un fil
        //lo ponemos dentro del try catch con la advertencia
        try {
            FileOutputStream fil = new FileOutputStream("perros.dat");
            //salida de los objetos y agregamos la excepcion al catch
            ObjectOutputStream archi = new ObjectOutputStream(fil);
            //hacemos un write object en este caso el lunes
            archi.writeObject(lunes);
            archi.writeObject(martes);
            archi.writeObject(miercoles);
            archi.writeObject(jueves);
            archi.writeObject(viernes);

            //una vez que grabe hacemos un close
            archi.close();


            //una vez que lo escribimos, serializamos y cerramos lo quiero abrir para leerlo
            //lo hacemos asi volviendo abrirlo asi lo puedo listar

            FileInputStream filin = new FileInputStream("perros.dat");
            ObjectInputStream archilin = new ObjectInputStream(filin);

            //voy a leer el archivo creamos un array list
            ArrayList<Perro> dia;

            //vamos a hacer un for
            for (int i=0; i<5 ; i++){
                System.out.println(" Dia: "+ i+1);
                System.out.println(" ============== ");
                dia = (ArrayList<Perro>) archilin.readObject();
                for (Perro p: dia
                     ) {
                    System.out.println(p);
                }
            }
            archilin.close();


        } catch (FileNotFoundException e) {
            e.printStackTrace();
        } catch (IOException e) {
            e.printStackTrace();
        } catch (ClassNotFoundException e) {
            e.printStackTrace();
        }


    }
}
