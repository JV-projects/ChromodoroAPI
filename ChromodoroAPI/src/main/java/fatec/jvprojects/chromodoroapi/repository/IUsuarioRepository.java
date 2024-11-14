package fatec.jvprojects.chromodoroapi.repository;

import fatec.jvprojects.chromodoroapi.model.Usuario;
import org.springframework.data.mongodb.repository.MongoRepository;

import java.util.Optional;

public interface IUsuarioRepository extends MongoRepository<Usuario, String> {
    Optional<Usuario> findUsuarioByEmail(String email);
}
