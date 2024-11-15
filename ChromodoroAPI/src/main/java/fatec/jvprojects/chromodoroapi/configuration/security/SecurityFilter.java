package fatec.jvprojects.chromodoroapi.configuration.security;

import com.auth0.jwt.interfaces.Header;
import fatec.jvprojects.chromodoroapi.model.Usuario;
import fatec.jvprojects.chromodoroapi.repository.IUsuarioRepository;
import fatec.jvprojects.chromodoroapi.service.AutorizacaoServico;
import fatec.jvprojects.chromodoroapi.service.UsuarioServico;
import jakarta.servlet.FilterChain;
import jakarta.servlet.ServletException;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;
import org.springframework.security.authentication.UsernamePasswordAuthenticationToken;
import org.springframework.security.core.Authentication;
import org.springframework.security.core.context.SecurityContextHolder;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.stereotype.Service;
import org.springframework.web.filter.OncePerRequestFilter;
import org.springframework.web.servlet.function.ServerRequest;

import java.io.IOException;

@Service
public class SecurityFilter extends OncePerRequestFilter {

    private TokenService tokenService;

    private UsuarioServico usuarioServico;

    private AutorizacaoServico autorizacaoServico;

    public SecurityFilter(TokenService tokenService, UsuarioServico usuarioServico, AutorizacaoServico autorizacaoServico) {
        this.tokenService = tokenService;
        this.usuarioServico = usuarioServico;
        this.autorizacaoServico = autorizacaoServico;
    }

    @Override
    protected void doFilterInternal(HttpServletRequest request,
                                    HttpServletResponse response,
                                    FilterChain filterChain) throws ServletException, IOException {
        String token = recuperarToken(request);

        if (token != null) {
            String validarToken = tokenService.validarToken(token);

            UserDetails userDetails = usuarioServico.encontrarPorEmail(validarToken).get();

            Authentication authentication =
                    new UsernamePasswordAuthenticationToken(userDetails, null, userDetails.getAuthorities());

            SecurityContextHolder.getContext().setAuthentication(authentication);
        }

        filterChain.doFilter(request, response);
    }

    private String recuperarToken(HttpServletRequest request) {
        String authReader = request.getHeader("Authorization");

        if (authReader != null) {
            return authReader.replace("Bearer ", "");
        }

        return null;
    }
}
