package com.example;

import com.example.service.EquipoService;
import com.example.service.JugadorService;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.ConfigurableApplicationContext;

@SpringBootApplication
public class BaloncestoApplication {

	public static void main(String[] args) {

		// contexto que representa la aplicacion

		ConfigurableApplicationContext context= SpringApplication.run(BaloncestoApplication.class,args);
		context.getBean(JugadorService.class).testJugador();


		//context.getBean(EquipoService.class).

		//	JugadorService jugadorService=context.getBean(JugadorService.class);

		//EquipoService personaService =context.getBean(EquipoService.class);

		//JugadorService.testJugador();
	}
}