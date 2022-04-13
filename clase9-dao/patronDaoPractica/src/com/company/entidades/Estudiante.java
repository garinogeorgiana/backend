package com.company.entidades;

public class Estudiante {
    private String nombre;
    private String apellido;
    private Long id;

    //constructor

    public Estudiante(String nombre, String apellido, Long id) {
        this.nombre = nombre;
        this.apellido = apellido;
        this.id = id;
    }

    //getter y setter

    public String getNombre() {
        return nombre;
    }

    public void setNombre(String nombre) {
        this.nombre = nombre;
    }

    public String getApellido() {
        return apellido;
    }

    public void setApellido(String apellido) {
        this.apellido = apellido;
    }

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

}
