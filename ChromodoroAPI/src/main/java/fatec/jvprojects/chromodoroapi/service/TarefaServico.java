package fatec.jvprojects.chromodoroapi.service;

import fatec.jvprojects.chromodoroapi.model.Tarefa;
import fatec.jvprojects.chromodoroapi.model.Usuario;
import fatec.jvprojects.chromodoroapi.repository.ITarefaRepository;
import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@Service
public class TarefaServico implements ITarefaServico {

    Logger logger = LogManager.getLogger(this.getClass());

    private ITarefaRepository tarefaRepository;

    private UsuarioServico usuarioServico;

    public TarefaServico(ITarefaRepository tarefaRepository, UsuarioServico usuarioServico) {
        this.tarefaRepository = tarefaRepository;
        this.usuarioServico = usuarioServico;
    }

    @Override
    public Optional<Tarefa> salvarTarefa(Tarefa tarefa, String email) {
        logger.info("|--- Serviço - Salvar tarefa ---|");

        Usuario usuario = usuarioServico.encontrarPorEmail(email).orElseThrow();

        tarefa.setIdUsuario(usuario);

        return Optional.of(tarefaRepository.insert(tarefa));
    }

    @Override
    public List<Tarefa> listarTarefasUsuario(Usuario usuario) {
        logger.info("|--- Serviço - Listar tarefas do usuário ---|");

        return tarefaRepository.findTarefasByIdUsuario(usuario)
                .filter( tarefa -> tarefa.getIdProjeto() == null).toList();
    }

    @Override
    public Optional<Tarefa> atualizarTarefa(Tarefa newTarefa) {
        logger.info("|--- Serviço - Atualizar tarefa ---|");

        return tarefaRepository.findById(newTarefa.getId())
                .map( tarefa -> {
                    tarefa.setTitulo(newTarefa.getTitulo());
                    tarefa.setDescricao(newTarefa.getDescricao());
                    tarefa.setStatus(newTarefa.getStatus());
                    tarefa.setEstCiclos(newTarefa.getEstCiclos());
                    tarefa.setTotalCiclos(newTarefa.getTotalCiclos());
                    tarefa.setTotalTempo(newTarefa.getTotalTempo());
                    tarefa.setTotalPausa(newTarefa.getTotalPausa());
                    return tarefaRepository.save(tarefa);
                });
    }

    @Override
    public void excluirTarefa(String idTarefa) {
        logger.info("|--- Serviço - Excluir tarefa ---|");

        tarefaRepository.deleteById(idTarefa);
    }
}
