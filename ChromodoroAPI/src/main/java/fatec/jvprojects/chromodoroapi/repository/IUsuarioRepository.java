package fatec.jvprojects.chromodoroapi.repository;

import fatec.jvprojects.chromodoroapi.model.Usuario;
import org.springframework.data.mongodb.repository.MongoRepository;

public interface IUsuarioRepository extends MongoRepository<Usuario, String> {

}
