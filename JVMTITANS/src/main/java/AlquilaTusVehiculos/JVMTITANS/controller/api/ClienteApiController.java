package AlquilaTusVehiculos.JVMTITANS.controller.api;

import io.swagger.v3.oas.annotations.Operation;
import io.swagger.v3.oas.annotations.security.SecurityRequirement;
import io.swagger.v3.oas.annotations.tags.Tag;
import io.swagger.v3.oas.annotations.responses.ApiResponse;
import io.swagger.v3.oas.annotations.responses.ApiResponses;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;
import java.util.List;

import AlquilaTusVehiculos.JVMTITANS.model.Cliente;
import AlquilaTusVehiculos.JVMTITANS.repository.ClienteRepository;

@RestController
@RequestMapping("/api")
@Tag(name = "Clientes", description = "Operaciones relacionadas con clientes")
@SecurityRequirement(name = "bearerAuth")
public class ClienteApiController {

    private final ClienteRepository clienteRepository;

    public ClienteApiController(ClienteRepository clienteRepository) {
        this.clienteRepository = clienteRepository;
    }

    @Operation(summary = "Obtener todos los clientes", description = "Devuelve una lista completa de clientes registrados en el sistema.")
    @ApiResponses(value = {
            @ApiResponse(responseCode = "200", description = "Listado de clientes obtenido correctamente"),
            @ApiResponse(responseCode = "401", description = "No autorizado – token no válido o ausente"),
            @ApiResponse(responseCode = "403", description = "Prohibido – acceso denegado")
    })
    @SecurityRequirement(name = "bearerAuth")
    @GetMapping("/clientes")
    public List<Cliente> getClientes() {
        return clienteRepository.findAll();
    }
}
