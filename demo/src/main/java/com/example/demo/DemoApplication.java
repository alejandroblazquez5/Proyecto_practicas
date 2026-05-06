package com.example.demo;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;

@SpringBootApplication
public class DemoApplication {

	public static void main(String[] args) {
		SpringApplication.run(DemoApplication.class, args);
	}

	/*
	Para iniciar la pagina web:
		1. Encender MYSQL desde docker, en el puerto 3306
		2. Abrir dberaver para comprobar que se conecta 
		  (en caso de no tener ninguna base de datos creada, dentro de la carpeta del proyecto hay un archivo sql para hacer la base de datos,
		   del archivo sql solo se ejecuta hasta la linea 206, el resto son solo para arreglar fallos si es necesario)
		3. Correr este programa, cuando el terminal diga: "Started DemoApplication" estara preparada 
		4. Hostear la pagina administracion.html desde visual studio code con la extension: "Live Server"
	Con esto la pagina web ya funcionaria completamente.
	
	Usuario y contraseña de la base de datos:
	 - Usuario: "root"
	 - Contraseña: "root"
	*/
}
