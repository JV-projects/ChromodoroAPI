package fatec.jvprojects.chromodoroapi.service;

import fatec.jvprojects.chromodoroapi.exception.RegisterException;
import fatec.jvprojects.chromodoroapi.model.Usuario;
import fatec.jvprojects.chromodoroapi.model.dto.UsuarioDTO;

import java.util.List;
import java.util.Optional;

public interface IUsuarioServico {
    Optional<Usuario> salvarUsuario(UsuarioDTO usuario) throws RegisterException;

    List<Usuario> listarUsuarios();

    Optional<Usuario> encontrarPorEmail(String email);

    Optional<Usuario> atualizarUsuario(Usuario usuario);

    void deletarUsuario(Usuario usuario);
}
