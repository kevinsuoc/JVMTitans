package AlquilaTusVehiculos.JVMTITANS.controller.api;

import AlquilaTusVehiculos.JVMTITANS.model.Vehiculo;
import AlquilaTusVehiculos.JVMTITANS.repository.VehiculoRepository;
import io.swagger.v3.oas.annotations.Operation;
import io.swagger.v3.oas.annotations.tags.Tag;
import io.swagger.v3.oas.annotations.responses.ApiResponse;
import io.swagger.v3.oas.annotations.responses.ApiResponses;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/api")
@Tag(name = "Vehículos", description = "Operaciones relacionadas con vehículos")
public class VehiculoApiController {

    private final VehiculoRepository vehiculoRepository;

    public VehiculoApiController(VehiculoRepository vehiculoRepository) {
        this.vehiculoRepository = vehiculoRepository;
    }

    @Operation(summary = "Obtener todos los vehículos", description = "Devuelve una lista completa de vehículos disponibles.")
    @ApiResponses(value = {
            @ApiResponse(responseCode = "200", description = "Listado de vehículos obtenido correctamente"),
            @ApiResponse(responseCode = "401", description = "No autorizado – token no válido o ausente"),
            @ApiResponse(responseCode = "403", description = "Prohibido – acceso denegado")
    })
    @GetMapping("/vehiculos")
    public List<Vehiculo> getVehiculos() {
        return vehiculoRepository.findAll();
    }
}
