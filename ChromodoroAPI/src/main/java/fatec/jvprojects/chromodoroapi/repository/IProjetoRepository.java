package fatec.jvprojects.chromodoroapi.repository;

import fatec.jvprojects.chromodoroapi.model.Projeto;
import fatec.jvprojects.chromodoroapi.model.Usuario;
import org.springframework.data.mongodb.repository.MongoRepository;

import java.util.List;

public interface IProjetoRepository extends MongoRepository<Projeto, String> {
    List<Projeto> findProjetosByIdUsuario(Usuario usuario);
}
