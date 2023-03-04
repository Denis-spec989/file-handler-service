package github.denisspec989.azsservice;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.cloud.netflix.eureka.EnableEurekaClient;

@SpringBootApplication
@EnableEurekaClient
public class FileHandlerServiceApplication {

	public static void main(String[] args) {
		SpringApplication.run(FileHandlerServiceApplication.class, args);
	}

}
