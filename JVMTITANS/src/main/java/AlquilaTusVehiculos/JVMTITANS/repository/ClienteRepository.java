package AlquilaTusVehiculos.JVMTITANS.repository;

import AlquilaTusVehiculos.JVMTITANS.model.Cliente;
import AlquilaTusVehiculos.JVMTITANS.model.Usuario;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.Optional;

public interface ClienteRepository extends JpaRepository<Cliente, Long> {
    interface UsuarioRepository extends JpaRepository<Usuario, Long> {
        Optional<Usuario> findByUsername(String username);
    }
}

