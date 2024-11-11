package fatec.jvprojects.chromodoroapi.configuration;

import fatec.jvprojects.chromodoroapi.model.Tarefa;
import fatec.jvprojects.chromodoroapi.model.Usuario;
import fatec.jvprojects.chromodoroapi.repository.ITarefaRepository;
import fatec.jvprojects.chromodoroapi.repository.IUsuarioRepository;
import org.springframework.boot.CommandLineRunner;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

@Configuration
public class LoadDatabase {

    @Bean
    CommandLineRunner initDb(ITarefaRepository tarefaRepository, IUsuarioRepository usuarioRepository) {
        return args -> {
            Usuario usuario = new Usuario("Clodowaldo", "clodowaldo@teste.com", "1234");

            usuarioRepository.save(usuario);



        };
    }
}
