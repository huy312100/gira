package cybersoft.javabackend.gira;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;

//@EnableAutoConfiguration(exclude={DataSourceAutoConfiguration.class})
@SpringBootApplication
public class GiraApplication {

	public static void main(String[] args) {
		SpringApplication.run(GiraApplication.class, args);
	}

}
