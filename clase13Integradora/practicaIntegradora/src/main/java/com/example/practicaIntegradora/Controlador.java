package com.example.practicaIntegradora;
import org.springframework.ui.Model;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import Model.Odontologo.java;
@RequestMapping("/index")
@Controller
public class Controlador {

    @GetMapping("index")
    public String bienvenida(Model model){
        private Model.odontologo

        model.addAttribute("nombre","Carlos");
        model.addAttribute("edad",32);
        return "index";
    }

}
