package fatec.jvprojects.chromodoroapi.service;

import fatec.jvprojects.chromodoroapi.model.Projeto;

import java.util.List;
import java.util.Optional;

public interface IProjetoServico {
    Optional<Projeto> salvarProjeto(Projeto projeto, String email);

    List<Projeto> listarProjetosUsuario(String email);

    Optional<Projeto> atualizarProjeto(Projeto projeto);

    void deletarProjeto(String idProjeto);
}
