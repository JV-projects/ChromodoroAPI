package fatec.jvprojects.chromodoroapi.configuration.security;

import com.auth0.jwt.JWT;
import com.auth0.jwt.algorithms.Algorithm;
import com.auth0.jwt.exceptions.JWTCreationException;
import com.auth0.jwt.exceptions.JWTVerificationException;
import fatec.jvprojects.chromodoroapi.model.Usuario;
import org.springframework.stereotype.Service;

import java.time.Instant;
import java.time.LocalDateTime;
import java.time.ZoneOffset;

@Service
public class TokenService {
    private static final String SECRET = "CHROMODORO_API";

    private static final String ISSUER = "chromodoro-api";

    private static final Algorithm algorithm = Algorithm.HMAC256(SECRET);

    public String gerarToken(Usuario usuario) {
        try {
            return JWT.create()
                    .withIssuer(ISSUER)
                    .withSubject(usuario.getUsername())
                    .withExpiresAt(gerarDataExpiracao())
                    .sign(algorithm);
        } catch (JWTCreationException exception) {
            return exception.getMessage();
        }
    }

    public String validarToken(String token) {
        try {
            return JWT.require(algorithm)
                    .withIssuer(ISSUER)
                    .build()
                    .verify(token)
                    .getSubject();

        } catch (JWTVerificationException exception) {
            return exception.getMessage();
        }
    }


    private Instant gerarDataExpiracao() {
        return LocalDateTime.now().plusMonths(4).toInstant(ZoneOffset.of("-03:00"));
    }
}
