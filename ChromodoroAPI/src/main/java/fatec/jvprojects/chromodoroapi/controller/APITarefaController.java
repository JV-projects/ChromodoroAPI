package fatec.jvprojects.chromodoroapi.controller;

import fatec.jvprojects.chromodoroapi.model.Tarefa;
import fatec.jvprojects.chromodoroapi.repository.ITarefaRepository;
import fatec.jvprojects.chromodoroapi.service.TarefaServico;
import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;

@RestController
@RequestMapping("chromodoro/api/tarefas")
public class APITarefaController {
    Logger logger = LogManager.getLogger(this.getClass());

    private TarefaServico tarefaServico;

    public APITarefaController(TarefaServico tarefaServico) {
        this.tarefaServico = tarefaServico;
    }

    @GetMapping("tarefas")
    public ResponseEntity<List<Tarefa>> consultarTarefas() {
        // TODO
        return null;
    }

    @GetMapping(value = "tarefas", params = "email")
    public ResponseEntity<List<Tarefa>> consultarTarefasUsuario(@RequestParam String email) {
        logger.info("API --> Consultar tarefas do usuario " + email);
        // TODO
        return null;
    }

}
