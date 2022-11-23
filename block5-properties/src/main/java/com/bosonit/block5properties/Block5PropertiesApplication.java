package com.bosonit.block5properties;

import org.springframework.beans.factory.annotation.Value;
import org.springframework.boot.CommandLineRunner;
import org.springframework.boot.SpringApplication;
import org.springframework.stereotype.Component;


	/*Declaramos @Value y asi cargar los valores desde el fichero application.properties
	que se encuentra en la carpeta resources --> Este fichero si está en conjunto con YML prevalece dando unos resultados en
	escala.
	VALORES DE PROPERTIES:
	greeting=Hello world!
	my.number=100*/

@Component //
public class Block5PropertiesApplication implements CommandLineRunner {


	public static void main(String[] args) {
		SpringApplication.run(Block5PropertiesApplication.class, args);

	}

	//Llamamos al primer valor del fichero
	@Value("${greeting}")
	private String Hello;

	//Llamamos al segundo valor del fichero
	@Value("${my.number}")
	private String oneString;

	//Llamamos a la variable que NO Existe en application.properties Sin Asignarle un valor
	/* @Value("${new.property}")
	private String newString; */

	//En este paso, declaramos el valor de variable sin existir en el fichero//
	@Value("${new.property:new.property no tiene valor}")
	private String newPropertyString;

	//Imprimimos por consola los resultados de los String
	@Override
	public void run(String... args) throws Exception {
		System.out.println("El valor de greeting es: " + Hello);

		System.out.println("El valor de my.number es: " + oneString);

//		System.out.println(newString);// En este caso imprime por consola ${new.property} tras ser llamada sin existir en el archivo

		System.out.println("El valor de new.property: " + newPropertyString);
	}

	/*NOTA IMPORTANTE: Para hacer la segunda parte del ejercicio, he tenido que dejar comentado el archivo application.properties
	 por lo que he adaptado los valores dentro de YML para que sean llamados a consola e imprima los datos correctamente
	 */
}