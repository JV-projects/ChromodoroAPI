package fatec.jvprojects.chromodoroapi.repository;

import fatec.jvprojects.chromodoroapi.model.Tarefa;
import fatec.jvprojects.chromodoroapi.model.Usuario;
import org.springframework.data.mongodb.repository.MongoRepository;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public interface ITarefaRepository extends MongoRepository<Tarefa, String> {
    List<Tarefa> findTarefasByIdUsuario(Usuario usuario);
}
