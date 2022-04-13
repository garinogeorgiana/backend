package com.example.patient;

import entity.Company;
import entity.Empleado;

import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.FileOutputStream;
import java.io.ObjectOutputStream;
import java.util.ArrayList;
import java.util.List;
import java.util.StringTokenizer;

public class main {
    public static void main(String[] args) {

        Empleado empleado1 = new Empleado("juan", "simon","123", 1100.);
        Empleado empleado2 = new Empleado("juan", "simon","123", 1100.);
        Empleado empleado3 = new Empleado("juan", "simon","123", 1100.);
        Empleado empleado4 = new Empleado("juan", "simon","123", 1100.);
        List<Empleado>empleadoList=new ArrayList<>();

        empleadoList.add(empleado1);
        empleadoList.add(empleado2);
        empleadoList.add(empleado3);
        empleadoList.add(empleado4);


        //desafio 2
        StringTokenizer ST3 = new StringTokenizer(
                empleado1.toString(), ":", true
        );
        while (ST3.hasMoreTokens())
            System.out.println(ST3.nextToken());


        Company company=new Company("777","sa",empleadoList);

        try{
            FileOutputStream fileOut = new FileOutputStream("COMPANY.TXT");
            ObjectOutputStream fileOutput = new ObjectOutputStream(fileOut);
            fileOutput.writeObject(empleadoList);
        }catch (FileNotFoundException e){

        }

    }
}
