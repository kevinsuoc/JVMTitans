package AlquilaTusVehiculos.JVMTITANS.controller.admin;

import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;

import java.security.Principal;

@Controller
@RequestMapping("/admin")
public class AdminController {

    @GetMapping("/home")
    public String panelAdmin(Model model, Principal principal) {
        model.addAttribute("username", principal.getName());
        return "admin/home"; // esto carga admin-panel.html desde templates
    }
}
