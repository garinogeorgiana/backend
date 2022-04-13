import org.apache.log4j.Logger;

import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;

public class ListaPromedio {
    //la primer linea creamos la instancia logger mediante logger.getlogger(es lo mismo para todos)
    private static final Logger logger = Logger.getLogger(ListaPromedio.class);
    //creamos lista de enterior
    private List<Integer>enteros = new ArrayList<>();

    public ListaPromedio(List<Integer>enteros) throws Exception{
        this.enteros = enteros;
        if (enteros.size()>5){
            logger.info("la longitud de la lista es mayor a 5");
            }
        if (enteros.size()>10){
            logger.info("la longitud de la info es mayor a 10");
        }
        if (enteros.size()==0){
            throw new Exception();
            }
        }
    //iteramos una lista y guardamos la sumatoria de todos los valores
        public int promedio() {
            int sum = 0;

            Integer entero;
            for (Iterator var2= this.enteros.iterator(); var2.hasNext(); sum += entero){
                //conversion de iterador a integer del objeto var2
                //next apunta al sig objeto y hasnext nos devuelve v si hay un sig objeto
                entero=(Integer)var2.next();
            }
            int promedio = sum/this.enteros.size();
            logger.info("el promedio de la lista es:" + promedio);
            return promedio;
        }

        public List<Integer>getEnteros(){
        return this.enteros;
        }

}
