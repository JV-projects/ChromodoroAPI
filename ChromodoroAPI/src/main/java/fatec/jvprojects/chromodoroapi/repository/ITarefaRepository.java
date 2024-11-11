package fatec.jvprojects.chromodoroapi.repository;

import fatec.jvprojects.chromodoroapi.model.Tarefa;
import org.springframework.data.mongodb.repository.MongoRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface ITarefaRepository extends MongoRepository<Tarefa, String> {

}
