package AlquilaTusVehiculos.JVMTITANS.controller.api;

import AlquilaTusVehiculos.JVMTITANS.model.Usuario;
import AlquilaTusVehiculos.JVMTITANS.model.Rol;
import AlquilaTusVehiculos.JVMTITANS.repository.UsuarioRepository;
import io.swagger.v3.oas.annotations.Operation;
import io.swagger.v3.oas.annotations.tags.Tag;
import io.swagger.v3.oas.annotations.responses.ApiResponse;
import io.swagger.v3.oas.annotations.responses.ApiResponses;
import org.springframework.web.bind.annotation.*;

import java.util.List;
import java.util.Set;

@RestController
@RequestMapping("/api")
@Tag(name = "Usuarios", description = "Operaciones relacionadas con los usuarios del sistema")
public class UsuarioApiController {

    private final UsuarioRepository usuarioRepository;

    public UsuarioApiController(UsuarioRepository usuarioRepository) {
        this.usuarioRepository = usuarioRepository;
    }

    @Operation(summary = "Obtener todos los usuarios", description = "Devuelve todos los usuarios con sus roles (ADMIN/USER)")
    @ApiResponses(value = {
            @ApiResponse(responseCode = "200", description = "Listado de usuarios obtenido correctamente"),
            @ApiResponse(responseCode = "401", description = "No autorizado – token no válido o ausente"),
            @ApiResponse(responseCode = "403", description = "Prohibido – acceso denegado")
    })
    @GetMapping("/usuarios")
    public List<UsuarioDTO> getUsuarios() {
        return usuarioRepository.findAll().stream()
                .map(usuario -> new UsuarioDTO(
                        usuario.getId(),
                        usuario.getUsername(),
                        usuario.getEmail(),
                        usuario.getRoles()
                ))
                .toList();
    }

    public static class UsuarioDTO {
        private Long id;
        private String username;
        private String email;
        private Set<Rol> roles;

        public UsuarioDTO(Long id, String username, String email, Set<Rol> roles) {
            this.id = id;
            this.username = username;
            this.email = email;
            this.roles = roles;
        }

        public Long getId() { return id; }
        public String getUsername() { return username; }
        public String getEmail() { return email; }
        public Set<Rol> getRoles() { return roles; }
    }
}
