package AlquilaTusVehiculos.JVMTITANS.repository;


import AlquilaTusVehiculos.JVMTITANS.model.Vehiculo;
import org.springframework.data.repository.Repository;
import java.util.Optional;

public interface VehiculoRepository extends Repository<Vehiculo, Long> {
    Vehiculo save(Vehiculo vehiculo);
    Optional<Vehiculo> findById(long id);
}
