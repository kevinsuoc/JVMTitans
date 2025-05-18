package AlquilaTusVehiculos.JVMTITANS.controller.admin;

import AlquilaTusVehiculos.JVMTITANS.model.Alquiler;
import AlquilaTusVehiculos.JVMTITANS.model.Cliente;
import AlquilaTusVehiculos.JVMTITANS.model.Vehiculo;
import AlquilaTusVehiculos.JVMTITANS.repository.AlquilerRepository;
import AlquilaTusVehiculos.JVMTITANS.repository.ClienteRepository;
import AlquilaTusVehiculos.JVMTITANS.repository.VehiculoRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.*;

@Controller
@RequestMapping("/admin/alquiler")
public class AlquilerAdminController {

    @Autowired
    private AlquilerRepository alquilerRepository;

    @Autowired
    private ClienteRepository clienteRepository;

    @Autowired
    private VehiculoRepository vehiculoRepository;

    @GetMapping("/lista")
    public String listarAlquileresAdmin(Model model) {
        model.addAttribute("alquileres", alquilerRepository.findAll());
        return "admin/alquiler/lista";
    }

    @GetMapping("/nuevo")
    public String nuevoAlquilerAdmin(Model model) {
        model.addAttribute("alquiler", new Alquiler());
        model.addAttribute("clientes", clienteRepository.findAll());
        model.addAttribute("vehiculos", vehiculoRepository.findAll());
        return "admin/alquiler/formulario";
    }

    @PostMapping
    public String guardarAlquilerAdmin(@ModelAttribute Alquiler alquiler) {
        Cliente cliente = clienteRepository.findById(alquiler.getCliente().getId()).orElse(null);
        Vehiculo vehiculo = vehiculoRepository.findById(alquiler.getVehiculo().getId()).orElse(null);

        alquiler.setCliente(cliente);
        alquiler.setVehiculo(vehiculo);

        alquilerRepository.save(alquiler);
        return "redirect:/admin/alquiler/lista";
    }

    @GetMapping("/editar/{id}")
    public String editarAlquilerAdmin(@PathVariable Long id, Model model) {
        model.addAttribute("alquiler", alquilerRepository.findById(id).orElse(null));
        model.addAttribute("clientes", clienteRepository.findAll());
        model.addAttribute("vehiculos", vehiculoRepository.findAll());
        return "admin/alquiler/formulario";
    }

    @PostMapping("/eliminar/{id}")
    public String eliminarAlquilerAdmin(@PathVariable Long id) {
        alquilerRepository.deleteById(id);
        return "redirect:/admin/alquiler/lista";
    }
}
