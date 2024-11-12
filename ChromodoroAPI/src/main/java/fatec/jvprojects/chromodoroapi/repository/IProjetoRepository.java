package fatec.jvprojects.chromodoroapi.repository;

import fatec.jvprojects.chromodoroapi.model.Projeto;
import org.springframework.data.mongodb.repository.MongoRepository;

public interface IProjetoRepository extends MongoRepository<Projeto, String> {

}
