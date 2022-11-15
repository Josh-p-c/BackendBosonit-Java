package com.bosonit.block5commandlinerunner;

import lombok.extern.slf4j.Slf4j;
import org.springframework.boot.CommandLineRunner;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.annotation.Bean;

import javax.annotation.PostConstruct;

@SpringBootApplication
@Slf4j
public class Block5CommandLineRunnerApplication implements CommandLineRunner {


	//creamos la clase Main donde meteremos el metodo para arrancar la aplicacion spring
	public static void main(String[] args) {
		log.info("INCIO DE LA APLICACION");//nos muestra el log en nivel info posicionada al inicio del Spring Run
		SpringApplication.run(Block5CommandLineRunnerApplication.class, args);
	}

	@PostConstruct
	public void firstFunction() {
		System.out.println("Hola desde clase inicial");
	}

	@Override
	public void run(String... args) throws Exception {
		//Pasamos como parametro de la funcion thirdFunction
		thirdFunction();
	}

	@Bean
	CommandLineRunner secondFunction (){

		return message ->{
			System.out.println("Hola desde clase secundaria");
		};
	}

	@Bean
	CommandLineRunner thirdFunction (){

		return message ->{
			System.out.println("Hola desde la tercera clase");

		};
	}
}
