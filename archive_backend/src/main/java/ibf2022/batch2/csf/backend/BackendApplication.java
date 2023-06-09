package ibf2022.batch2.csf.backend;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.annotation.Bean;
import org.springframework.web.servlet.config.annotation.WebMvcConfigurer;

// import ibf2022.batch2.csf.backend.configs.EnableCORS;

@SpringBootApplication
public class BackendApplication {

	public static void main(String[] args) {
		SpringApplication.run(BackendApplication.class, args);
	}

// 	@Bean
// 	public WebMvcConfigurer corsConfigurer() {
// 		return new EnableCORS("/api/*", "*");
// }

}
