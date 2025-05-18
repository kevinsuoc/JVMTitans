package AlquilaTusVehiculos.JVMTITANS.controller.user;

import AlquilaTusVehiculos.JVMTITANS.model.Alquiler;
import AlquilaTusVehiculos.JVMTITANS.model.Cliente;
import AlquilaTusVehiculos.JVMTITANS.model.Vehiculo;
import AlquilaTusVehiculos.JVMTITANS.repository.AlquilerRepository;
import AlquilaTusVehiculos.JVMTITANS.repository.ClienteRepository;
import AlquilaTusVehiculos.JVMTITANS.repository.VehiculoRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;

@Controller
@RequestMapping("/user/alquiler")
public class AlquilerUserController {

    @Autowired
    private AlquilerRepository alquilerRepository;

    @Autowired
    private ClienteRepository clienteRepository;

    @Autowired
    private VehiculoRepository vehiculoRepository;

    @GetMapping("/lista")
    public String listarAlquileresUser(Model model) {
        model.addAttribute("alquileres", alquilerRepository.findAll());
        return "user/alquiler/lista";
    }

    @GetMapping("/nuevo")
    public String nuevoAlquiler(Model model) {
        model.addAttribute("alquiler", new Alquiler());
        model.addAttribute("clientes", clienteRepository.findAll());
        model.addAttribute("vehiculos", vehiculoRepository.findAll());
        return "user/alquiler/formulario";
    }

    @PostMapping
    public String guardarAlquilerUsuario(@ModelAttribute Alquiler alquiler) {
        Cliente cliente = clienteRepository.findById(alquiler.getCliente().getId()).orElse(null);
        Vehiculo vehiculo = vehiculoRepository.findById(alquiler.getVehiculo().getId()).orElse(null);

        alquiler.setCliente(cliente);
        alquiler.setVehiculo(vehiculo);

        alquilerRepository.save(alquiler);
        return "redirect:/user/alquiler/lista";
    }
}
