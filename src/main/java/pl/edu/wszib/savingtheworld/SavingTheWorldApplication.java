package pl.edu.wszib.savingtheworld;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.boot.web.servlet.support.SpringBootServletInitializer;
import org.springframework.web.SpringServletContainerInitializer;

@SpringBootApplication
public class SavingTheWorldApplication extends SpringBootServletInitializer {

	public static void main(String[] args) {
		SpringApplication.run(SavingTheWorldApplication.class, args);
	}

}
