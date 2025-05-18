package AlquilaTusVehiculos.JVMTITANS.controller.user;

import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;

import java.security.Principal;

@Controller
@RequestMapping("/user")
public class UserController {

    @GetMapping("/home")
    public String panelUsuario(Model model, Principal principal) {
        model.addAttribute("username", principal.getName());
        return "user/home"; // esto carga user-panel.html desde templates
    }
}
