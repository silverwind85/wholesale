package pl.internal.hs.wholesale;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.scheduling.annotation.EnableAsync;

@SpringBootApplication
public class WholesaleApplication {

	public static void main(String[] args) {
		SpringApplication.run(WholesaleApplication.class, args);
	}

}
