package AlquilaTusVehiculos.JVMTITANS.controller;

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
@RequestMapping("/alquileres")
public class AlquilerController {

    @Autowired
    private AlquilerRepository alquilerRepository;

    @Autowired
    private ClienteRepository clienteRepository;

    @Autowired
    private VehiculoRepository vehiculoRepository;

    @GetMapping
    public String listarAlquileres(Model model) {
        model.addAttribute("alquileres", alquilerRepository.findAll());
        return "alquiler/lista";
    }

    @GetMapping("/nuevo")
    public String nuevoAlquiler(Model model) {
        model.addAttribute("alquiler", new Alquiler());
        model.addAttribute("clientes", clienteRepository.findAll());
        model.addAttribute("vehiculos", vehiculoRepository.findAll());
        return "alquiler/formulario";
    }

    @PostMapping
    public String guardarAlquiler(@ModelAttribute Alquiler alquiler) {
        Cliente cliente = clienteRepository.findById(alquiler.getCliente().getId()).orElse(null);
        Vehiculo vehiculo = vehiculoRepository.findById(alquiler.getVehiculo().getId()).orElse(null);

        alquiler.setCliente(cliente);
        alquiler.setVehiculo(vehiculo);

        alquilerRepository.save(alquiler);
        return "redirect:/alquileres";
    }

    @GetMapping("/editar/{id}")
    public String editarAlquiler(@PathVariable Long id, Model model) {
        model.addAttribute("alquiler", alquilerRepository.findById(id).orElse(null));
        model.addAttribute("clientes", clienteRepository.findAll());
        model.addAttribute("vehiculos", vehiculoRepository.findAll());
        return "alquiler/formulario";
    }

    @PostMapping("/eliminar/{id}")
    public String eliminarAlquiler(@PathVariable Long id) {
        alquilerRepository.deleteById(id);
        return "redirect:/alquileres";
    }
}
