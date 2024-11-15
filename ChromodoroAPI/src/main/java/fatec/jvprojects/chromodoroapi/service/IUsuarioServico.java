package fatec.jvprojects.chromodoroapi.service;

import fatec.jvprojects.chromodoroapi.model.Usuario;

import java.util.List;
import java.util.Optional;

public interface IUsuarioServico {
    Optional<Usuario> salvarUsuario(Usuario usuario);

    List<Usuario> listarUsuarios();

    Optional<Usuario> encontrarPorEmail(String email);

    Optional<Usuario> atualizarUsuario(Usuario usuario);

    void deletarUsuario(Usuario usuario);
}
