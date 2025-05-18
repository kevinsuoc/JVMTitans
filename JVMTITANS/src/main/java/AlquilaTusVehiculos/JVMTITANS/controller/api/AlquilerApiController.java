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

import AlquilaTusVehiculos.JVMTITANS.model.Alquiler;
import AlquilaTusVehiculos.JVMTITANS.repository.AlquilerRepository;

@RestController
@RequestMapping("/api")
@Tag(name = "Alquileres", description = "Operaciones relacionadas con alquileres de vehículos")
@SecurityRequirement(name = "bearerAuth")
public class AlquilerApiController {

    private final AlquilerRepository alquilerRepository;

    public AlquilerApiController(AlquilerRepository alquilerRepository) {
        this.alquilerRepository = alquilerRepository;
    }

    @Operation(summary = "Obtener todos los alquileres", description = "Devuelve una lista completa de alquileres registrados en el sistema.")
    @ApiResponses(value = {
            @ApiResponse(responseCode = "200", description = "Listado de alquileres obtenido correctamente"),
            @ApiResponse(responseCode = "401", description = "No autorizado – token no válido o ausente"),
            @ApiResponse(responseCode = "403", description = "Prohibido – acceso denegado")
    })
    @SecurityRequirement(name = "bearerAuth")
    @GetMapping("/alquileres")
    public List<Alquiler> getAlquileres() {
        return alquilerRepository.findAll();
    }
}

