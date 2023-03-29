package bg.exam.laliga;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.scheduling.annotation.EnableScheduling;

@SpringBootApplication
@EnableScheduling
public class LaligaApplication {

	public static void main(String[] args) {
		SpringApplication.run(LaligaApplication.class, args);
	}

}
