package AlquilaTusVehiculos.JVMTITANS.controller.admin;

import AlquilaTusVehiculos.JVMTITANS.model.Cliente;
import AlquilaTusVehiculos.JVMTITANS.repository.ClienteRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.*;

@Controller
@RequestMapping("/admin/cliente")
public class ClienteAdminController {

    @Autowired
    private ClienteRepository clienteRepository;

    @GetMapping
    public String listarClientes(Model model) {
        model.addAttribute("cliente", clienteRepository.findAll());
        return "admin/cliente/lista";
    }

    @GetMapping("/nuevo")
    public String nuevoCliente(Model model) {
        model.addAttribute("cliente", new Cliente());
        return "admin/cliente/formulario";
    }

    @PostMapping
    public String guardarCliente(@ModelAttribute Cliente cliente) {
        clienteRepository.save(cliente);
        return "redirect:/admin/cliente";
    }

    @GetMapping("/editar/{id}")
    public String editarCliente(@PathVariable Long id, Model model) {
        model.addAttribute("cliente", clienteRepository.findById(id).orElse(null));
        return "admin/cliente/formulario";
    }

    @PostMapping("/eliminar/{id}")
    public String eliminarCliente(@PathVariable Long id) {
        clienteRepository.deleteById(id);
        return "redirect:/admin/cliente";
    }
}
