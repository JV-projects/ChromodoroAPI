package fatec.jvprojects.chromodoroapi.controller;

import fatec.jvprojects.chromodoroapi.model.Tarefa;
import fatec.jvprojects.chromodoroapi.model.Usuario;
import fatec.jvprojects.chromodoroapi.repository.ITarefaRepository;
import fatec.jvprojects.chromodoroapi.service.TarefaServico;
import fatec.jvprojects.chromodoroapi.service.UsuarioServico;
import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;
import java.util.Optional;

@RestController
@RequestMapping("chromodoro/api/tarefas")
public class APITarefaController {
    Logger logger = LogManager.getLogger(this.getClass());

    private TarefaServico tarefaServico;

    private UsuarioServico usuarioServico;

    public APITarefaController(TarefaServico tarefaServico, UsuarioServico usuarioServico) {
        this.tarefaServico = tarefaServico;
        this.usuarioServico = usuarioServico;
    }

    @GetMapping(value = "tarefas", params = "email")
    public ResponseEntity<List<Tarefa>> consultarTarefasUsuario(@RequestParam String email) {
        logger.info("API --> Consultar tarefas do usuário: {}", email);

        Optional<Usuario> usuario = usuarioServico.encontrarPorEmail(email);

        return ResponseEntity.ok().body(tarefaServico.listarTarefasUsuario(usuario.get()));

    }

    @PostMapping("tarefas")
    public ResponseEntity<Optional<Tarefa>> salvarTarefa(@RequestBody Tarefa tarefa) {
        logger.info("API --> Salvar tarefa {}", tarefa.getTitulo());

        return ResponseEntity.ok().body(tarefaServico.salvarTarefa(tarefa));
    }

    @PatchMapping("tarefas")
    public ResponseEntity<Optional<Tarefa>> atualizarTarefa(@RequestBody Tarefa tarefa) {
        logger.info("API --> Atualizar tarefa {}", tarefa.getTitulo());

        return ResponseEntity.ok().body(tarefaServico.atualizarTarefa(tarefa));
    }

}
