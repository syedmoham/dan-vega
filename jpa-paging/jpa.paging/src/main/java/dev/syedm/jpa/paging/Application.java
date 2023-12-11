package dev.syedm.jpa.paging;

import com.github.javafaker.Faker;
import org.springframework.boot.CommandLineRunner;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.annotation.Bean;

// note @SpringBootAppliction is a @Configuration class which will scan for @Beans
// so if we
@SpringBootApplication
public class Application {

	public static void main(String[] args) {
		SpringApplication.run(Application.class, args);
	}

	// Bean in application context. Spring is managing this for us.
	@Bean
	Faker faker()  {
		return new Faker();
	}

	/*
	@Bean
	CommandLineRunner commandLineRunner() {
		return args -> {
			System.out.println("Command Line Runner");
		};
	}
	 */

}
