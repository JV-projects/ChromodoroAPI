package fatec.jvprojects.chromodoroapi.controller;

import fatec.jvprojects.chromodoroapi.model.Projeto;
import fatec.jvprojects.chromodoroapi.service.ProjetoServico;
import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;
import java.util.Optional;

@RestController
@RequestMapping("chromodoro/api")
public class APIProjetoController {
    Logger logger = LogManager.getLogger(this.getClass());

    private ProjetoServico projetoServico;

    public APIProjetoController(ProjetoServico projetoServico) {
        this.projetoServico = projetoServico;
    }

    @GetMapping("projetos")
    public ResponseEntity<List<Projeto>> listarProjetosUsuario(@RequestParam String email) {
        logger.info("API --> Listando projetos do usuário com email: {}", email);

        return ResponseEntity.ok().body(projetoServico.listarProjetosUsuario(email));
    }

    @PostMapping("projetos")
    public ResponseEntity<Optional<Projeto>> salvarProjeto(@RequestBody Projeto projeto, @RequestParam String email) {
        logger.info("API --> Salvando projeto {}", projeto.getTitulo());

        return ResponseEntity.ok().body(projetoServico.salvarProjeto(projeto, email));
    }

    @PatchMapping("projetos")
    public ResponseEntity<Optional<Projeto>> atualizarProjeto(@RequestBody Projeto projeto) {
        logger.info("API --> Atualizar projeto {}", projeto.getTitulo());

        return ResponseEntity.ok().body(projetoServico.atualizarProjeto(projeto));
    }

    @DeleteMapping("projetos")
    public ResponseEntity<String> deletarProjeto(@RequestParam String id) {
        logger.info("API --> Deletar projeto com id: {}", id);

        projetoServico.deletarProjeto(id);

        return ResponseEntity.ok().body("Projeto com id " + id + " deletado com sucesso");
    }
}
