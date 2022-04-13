package com.example.livcoding.controller;

import com.example.livcoding.dominio.Usuario;
import com.example.livcoding.service.UsuarioService;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;

@Controller
public class UsuarioController {
    private UsuarioService usuarioService = new UsuarioService();

    @GetMapping("/")
    ///endpoint
    public Usuario crearUsuario(){
        return usuarioService.crearUsuario();
    }
}
