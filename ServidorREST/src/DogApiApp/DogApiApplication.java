package DogApiApp;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.annotation.ComponentScan;

@SpringBootApplication
@ComponentScan(basePackages = {"controller", "DogService", "DogApiApp"})
public class DogApiApplication {
    public static void main(String[] args) {
        SpringApplication.run(DogApiApplication.class, args);
    }
}