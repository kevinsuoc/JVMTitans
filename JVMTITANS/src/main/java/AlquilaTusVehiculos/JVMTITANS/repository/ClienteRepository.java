package AlquilaTusVehiculos.JVMTITANS.repository;

import AlquilaTusVehiculos.JVMTITANS.model.Cliente;
import org.springframework.data.jpa.repository.JpaRepository;

public interface ClienteRepository extends JpaRepository<Cliente, Long> {
}

