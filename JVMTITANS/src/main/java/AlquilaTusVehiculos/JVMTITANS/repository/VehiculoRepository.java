package AlquilaTusVehiculos.JVMTITANS.repository;

import AlquilaTusVehiculos.JVMTITANS.model.Vehiculo;
import org.springframework.data.jpa.repository.JpaRepository;

public interface VehiculoRepository extends JpaRepository<Vehiculo, Long> {
}

