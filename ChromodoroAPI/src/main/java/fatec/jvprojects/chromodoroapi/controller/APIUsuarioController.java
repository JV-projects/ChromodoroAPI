package fatec.jvprojects.chromodoroapi.controller;

import fatec.jvprojects.chromodoroapi.configuration.security.TokenService;
import fatec.jvprojects.chromodoroapi.exception.RegisterException;
import fatec.jvprojects.chromodoroapi.model.Usuario;
import fatec.jvprojects.chromodoroapi.model.dto.CredenciaisDTO;
import fatec.jvprojects.chromodoroapi.model.dto.ResponseAuthDTO;
import fatec.jvprojects.chromodoroapi.model.dto.UsuarioDTO;
import fatec.jvprojects.chromodoroapi.service.UsuarioServico;
import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;
import org.springframework.http.ResponseEntity;
import org.springframework.security.authentication.AuthenticationManager;
import org.springframework.security.authentication.UsernamePasswordAuthenticationToken;
import org.springframework.security.core.Authentication;
import org.springframework.web.bind.annotation.*;

import java.util.Objects;
import java.util.Optional;


@RestController
@RequestMapping("chromodoro/api/usuario")
public class APIUsuarioController {
    Logger logger = LogManager.getLogger(this.getClass());

    private AuthenticationManager authManager;

    private UsuarioServico usuarioServico;

    private TokenService tokenService;

    public APIUsuarioController(AuthenticationManager authManager, UsuarioServico usuarioServico, TokenService tokenService) {
        this.authManager = authManager;
        this.usuarioServico = usuarioServico;
        this.tokenService = tokenService;
    }

    @PostMapping("/login")
    public ResponseEntity<Object> login(@RequestBody CredenciaisDTO credenciais) {
        logger.info("API --> Logar com as credenciais: username: {}, senha: {}",
                credenciais.username(), credenciais.senha());

        UsernamePasswordAuthenticationToken userSenha =
                new UsernamePasswordAuthenticationToken(credenciais.username(), credenciais.senha());

        Authentication auth = authManager.authenticate(userSenha);

        String token = tokenService.gerarToken((Usuario) auth.getPrincipal());

        Usuario usuario = usuarioServico.encontrarPorEmail(credenciais.username()).get();

        ResponseAuthDTO responseAuthDTO = new ResponseAuthDTO(usuario.getNome(), usuario.getUsername(), token);

        return ResponseEntity.ok().body(responseAuthDTO);
    }

    @PostMapping("/registrar")
    public ResponseEntity<Object> registrar(@RequestBody UsuarioDTO usuario) {
        try {
            return ResponseEntity.ok().body(usuarioServico.salvarUsuario(usuario));
        } catch (RegisterException registerException) {
            return ResponseEntity.badRequest().body(registerException.getMessage());
        }
    }

}
