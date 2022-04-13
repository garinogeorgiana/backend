import java.util.HashMap;
import java.util.Map;

public class ComputerFactory {

    private static Map<String, Computadora> macLigeros = new HashMap<>();

    public Computadora getComputadora (int ram, int disco){
        //se concatena la key+ram+disco, si estan creados la key va con el hashmap a buscarlo
        String clave="key"+ ram + ":" + disco;
        System.out.println(clave);

        //si mac no tiene clave crea uno nuevo y pasalo por pantalla
        //cada objeto que se crea le va a dar una clave
        if(!macLigeros.containsKey(clave)){
            macLigeros.put(clave, new Computadora(ram,disco));

        }
        System.out.println("La pc esta creada");
        return macLigeros.get(clave);
    }
}
