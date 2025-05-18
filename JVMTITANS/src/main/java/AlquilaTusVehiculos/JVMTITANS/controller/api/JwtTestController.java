package AlquilaTusVehiculos.JVMTITANS.controller.api;

import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping("/api/test")
public class JwtTestController {

    @GetMapping
    public ResponseEntity<String> securedTest() {
        return ResponseEntity.ok(" Acceso autorizado con token JWT");
    }
}
