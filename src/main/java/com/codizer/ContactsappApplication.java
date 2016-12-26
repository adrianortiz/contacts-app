package com.codizer;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.scheduling.annotation.EnableScheduling;

// TODO: Auto-generated Javadoc
/**
 * The Class ContactsappApplication.
 */
@SpringBootApplication
@EnableScheduling // Habilitar tarea repetitiva
public class ContactsappApplication {

	/**
	 * The main method.
	 *
	 * @param args the arguments
	 */
	public static void main(String[] args) {
		SpringApplication.run(ContactsappApplication.class, args);
	}
}
