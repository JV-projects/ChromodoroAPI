package fatec.jvprojects.chromodoroapi.service;

import fatec.jvprojects.chromodoroapi.model.Tarefa;
import fatec.jvprojects.chromodoroapi.model.Usuario;
import fatec.jvprojects.chromodoroapi.repository.ITarefaRepository;
import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;

import java.util.List;
import java.util.Optional;

public class TarefaServico implements ITarefaServico {

    Logger logger = LogManager.getLogger(this.getClass());

    ITarefaRepository tarefaRepository;

    public TarefaServico(ITarefaRepository tarefaRepository) {
        this.tarefaRepository = tarefaRepository;
    }

    @Override
    public Optional<Tarefa> salvarTarefa(Tarefa tarefa) {
        logger.info("|--- Serviço - Salvar tarefa ---|");

        return Optional.of(tarefaRepository.insert(tarefa));
    }

    @Override
    public List<Tarefa> listarTarefasUsuario(Usuario usuario) {
        logger.info("|--- Serviço - Listar tarefas do usuário ---|");

        return tarefaRepository.findTarefasByIdUsuario(usuario);
    }

    @Override
    public Optional<Tarefa> atualizarTarefa(Tarefa tarefa) {
        logger.info("|--- Serviço - Atualizar tarefa ---|");

        return Optional.of(tarefaRepository.save(tarefa));
    }

    @Override
    public void excluirTarefa(Tarefa tarefa) {
        logger.info("|--- Serviço - Excluir tarefa ---|");

        tarefaRepository.delete(tarefa);
    }
}
