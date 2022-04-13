package com.example.nuestroPrimerProyecto;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;

@SpringBootApplication
@RestController

public class NuestroPrimerProyectoApplication {

	public static void main(String[] args) {
		SpringApplication.run(NuestroPrimerProyectoApplication.class, args);
	}
	@GetMapping
	public String HolaMundo(){
		return "Hola Mundo";
	}

}
