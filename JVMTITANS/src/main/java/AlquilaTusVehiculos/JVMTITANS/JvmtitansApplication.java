package AlquilaTusVehiculos.JVMTITANS;

import AlquilaTusVehiculos.JVMTITANS.model.Vehiculo;
import AlquilaTusVehiculos.JVMTITANS.repository.VehiculoRepository;
import org.springframework.boot.CommandLineRunner;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.annotation.Bean;

import java.util.Optional;

@SpringBootApplication
public class JvmtitansApplication {

	public static void main(String[] args) {SpringApplication.run(JvmtitansApplication.class, args);
	}

	// Test de conectividad de DDBB
	/*@Bean
	CommandLineRunner runner(VehiculoRepository repository) {
		return args -> {

			Vehiculo person = new Vehiculo();
			person.setColor("John");

			repository.save(person);
			Vehiculo saved = repository.findById(person.getId()).orElseThrow(RuntimeException::new);;
			throw new RuntimeException("Found !");
		};
	}*/
}