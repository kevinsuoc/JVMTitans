package AlquilaTusVehiculos.JVMTITANS.controller;

import org.springframework.security.core.Authentication;
import org.springframework.security.core.GrantedAuthority;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;

import java.util.Set;
import java.util.stream.Collectors;

@Controller
public class HomeController {

    @GetMapping("/")
    public String index(Authentication auth, Model model) {
        if (auth != null && auth.isAuthenticated()) {
            String username = auth.getName();
            Set<String> roles = auth.getAuthorities()
                    .stream()
                    .map(GrantedAuthority::getAuthority)
                    .collect(Collectors.toSet());

            model.addAttribute("username", username);
            model.addAttribute("roles", roles);
        }
        return "index";
    }
}
