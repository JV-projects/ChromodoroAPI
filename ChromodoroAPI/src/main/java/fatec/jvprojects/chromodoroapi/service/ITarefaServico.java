package fatec.jvprojects.chromodoroapi.service;

import fatec.jvprojects.chromodoroapi.model.Tarefa;
import fatec.jvprojects.chromodoroapi.model.Usuario;

import java.util.List;
import java.util.Optional;

public interface ITarefaServico {
    Optional<Tarefa> salvarTarefa(Tarefa tarefa);

    List<Tarefa> listarTarefasUsuario(Usuario usuario);

    Optional<Tarefa> atualizarTarefa(Tarefa tarefa);

    void excluirTarefa(Tarefa tarefa);

}
