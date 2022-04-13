package com.example.livcoding.service;

import com.example.livcoding.dominio.Usuario;

public class UsuarioService {

    public Usuario crearUsuario(){
    Usuario usuario = new Usuario("Diego",25);
    return usuario;
    }
}
