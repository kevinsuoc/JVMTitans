package AlquilaTusVehiculos.JVMTITANS.controller.admin;

import AlquilaTusVehiculos.JVMTITANS.model.Vehiculo;
import AlquilaTusVehiculos.JVMTITANS.repository.VehiculoRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.*;

@Controller
@RequestMapping("/admin/vehiculo")
public class AdminVehiculoController {

    @Autowired
    private VehiculoRepository vehiculoRepository;

    @GetMapping
    public String listarVehiculos(Model model) {
        model.addAttribute("vehiculos", vehiculoRepository.findAll());
        return "admin/vehiculo/lista";
    }

    @GetMapping("/nuevo")
    public String nuevoVehiculo(Model model) {
        model.addAttribute("vehiculo", new Vehiculo());
        return "admin/vehiculo/formulario";
    }

    @PostMapping
    public String guardarVehiculo(@ModelAttribute Vehiculo vehiculo) {
        vehiculoRepository.save(vehiculo);
        return "redirect:/admin/vehiculo";
    }

    @GetMapping("/editar/{id}")
    public String editarVehiculo(@PathVariable Long id, Model model) {
        Vehiculo vehiculo = vehiculoRepository.findById(id).orElse(null);
        if (vehiculo == null) {
            return "redirect:/admin/vehiculo/formulario";
        }
        model.addAttribute("vehiculo", vehiculo);
        return "admin/vehiculo/formulario";
    }

    @PostMapping("/eliminar/{id}")
    public String eliminarVehiculo(@PathVariable Long id) {
        vehiculoRepository.deleteById(id);
        return "redirect:/admin/vehiculo";
    }
}
