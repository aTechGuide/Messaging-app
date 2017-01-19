package in.kamran;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.annotation.ComponentScan;


@SpringBootApplication
@ComponentScan("in.kamran")
public class MessagingApplication {

	public static void main(String[] args) throws InterruptedException {
		SpringApplication.run(MessagingApplication.class, args);
	}
	
}
