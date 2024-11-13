package fatec.jvprojects.chromodoroapi.configuration;

import fatec.jvprojects.chromodoroapi.model.Projeto;
import fatec.jvprojects.chromodoroapi.model.Tarefa;
import fatec.jvprojects.chromodoroapi.model.Usuario;
import fatec.jvprojects.chromodoroapi.model.enumeracoes.Status;
import fatec.jvprojects.chromodoroapi.repository.IProjetoRepository;
import fatec.jvprojects.chromodoroapi.repository.ITarefaRepository;
import fatec.jvprojects.chromodoroapi.repository.IUsuarioRepository;
import org.springframework.boot.CommandLineRunner;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

import java.time.LocalTime;
import java.util.ArrayList;
import java.util.List;

@Configuration
public class LoadDatabase {

    @Bean
    CommandLineRunner initDb(ITarefaRepository tarefaRepository, IUsuarioRepository usuarioRepository, IProjetoRepository projetoRepository) {
        return args -> {
            Usuario usuario = new Usuario("Clodowaldo", "clodowaldo@teste.com", "1234");

            usuarioRepository.save(usuario);

            Projeto projeto = new Projeto(usuario, "Projeto teste", "testando projeto", Status.ANDAMENTO.getStatusNome());

            projetoRepository.save(projeto);

            Tarefa tarefa = new Tarefa(usuario, "tarefa", "testando tarefa", Status.ANDAMENTO.getStatusNome(), 5, 5, LocalTime.now(), LocalTime.now());

            tarefaRepository.save(tarefa);

            Tarefa tarefa1 = new Tarefa(usuario, "tarefa", "testando tarefa", Status.ANDAMENTO.getStatusNome(), projeto, 5, 5, LocalTime.now(), LocalTime.now());

            tarefaRepository.save(tarefa1);



            Projeto projeto1 = new Projeto(usuario, "varias", "Projeto com varias tarefas", Status.ANDAMENTO.getStatusNome());

            Tarefa tarefa2 = new Tarefa(usuario, "tarefa", "testando tarefa", Status.ANDAMENTO.getStatusNome(), projeto, 5, 5, LocalTime.now(), LocalTime.now());

            Tarefa tarefa3 = new Tarefa(usuario, "tarefa", "testando tarefa", Status.ANDAMENTO.getStatusNome(), projeto, 5, 5, LocalTime.now(), LocalTime.now());

            Tarefa tarefa4 = new Tarefa(usuario, "tarefa", "testando tarefa", Status.ANDAMENTO.getStatusNome(), projeto, 5, 5, LocalTime.now(), LocalTime.now());

            List<Tarefa> list = List.of(tarefa2, tarefa3, tarefa4);

            projeto1.setTarefas(list);

            projetoRepository.save(projeto1);





        };
    }
}