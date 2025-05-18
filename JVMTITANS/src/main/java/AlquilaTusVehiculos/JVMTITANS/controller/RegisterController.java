package AlquilaTusVehiculos.JVMTITANS.controller;

import AlquilaTusVehiculos.JVMTITANS.model.Rol;
import AlquilaTusVehiculos.JVMTITANS.model.Usuario;
import AlquilaTusVehiculos.JVMTITANS.repository.RolRepository;
import AlquilaTusVehiculos.JVMTITANS.repository.UsuarioRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PostMapping;

import java.util.Collections;

@Controller
public class RegisterController {

    @Autowired
    private UsuarioRepository usuarioRepository;

    @Autowired
    private RolRepository rolRepository;

    @Autowired
    private PasswordEncoder passwordEncoder;

    @GetMapping("/register")
    public String mostrarFormularioRegistro(Model model) {
        model.addAttribute("usuario", new Usuario());
        return "register";
    }

    @PostMapping("/register")
    public String registrarUsuario(@ModelAttribute Usuario usuario) {
        usuario.setPassword(passwordEncoder.encode(usuario.getPassword()));
        Rol rolUser = rolRepository.findByNombre("USER")
                .orElseThrow(() -> new RuntimeException("Rol USER no encontrado"));
        usuario.setRoles(Collections.singleton(rolUser));
        usuarioRepository.save(usuario);
        return "redirect:/login";
    }
}
