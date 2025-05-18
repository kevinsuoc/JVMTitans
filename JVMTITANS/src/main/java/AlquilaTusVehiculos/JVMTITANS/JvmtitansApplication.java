package AlquilaTusVehiculos.JVMTITANS;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;

@SpringBootApplication

public class JvmtitansApplication {

	public static void main(String[] args) {
		// Llama a Spring Boot normalmente
		SpringApplication.run(JvmtitansApplication.class, args);

		// Genera los hashes
		BCryptPasswordEncoder encoder = new BCryptPasswordEncoder();
		System.out.println("Hash admin123: " + encoder.encode("admin123"));
		System.out.println("Hash user123: " + encoder.encode("user123"));
		System.out.println("es la version correcta");
	}
}
