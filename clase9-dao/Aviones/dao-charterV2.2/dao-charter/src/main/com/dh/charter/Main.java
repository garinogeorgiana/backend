package main.com.dh.charter;

import main.com.dh.charter.dao.impl.AvionDaoH2;
import main.com.dh.charter.model.Avion;
import main.com.dh.charter.service.AvionService;

import java.util.Date;
import java.util.List;

public class Main {

    public static void main(String[] args) {
        Avion avioncito=new Avion(1, "Marca", "Modelo", "AFE433", new Date());
        Avion avioncito2=new Avion(2, "Marca2", "Modelo2", "fdsa345", new Date());

        AvionService avionService=new AvionService(new AvionDaoH2());
        avionService.registrarAvion(avioncito);
        Avion avionEncontrado = avionService.buscarAvion(3);
        System.out.println(avionEncontrado.toString());

        List<Avion> avioncitos=avionService.buscarTodos();

        System.out.println(avioncitos.get(3));





    }
}
