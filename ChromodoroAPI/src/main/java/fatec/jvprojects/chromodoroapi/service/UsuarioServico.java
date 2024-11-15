package fatec.jvprojects.chromodoroapi.service;

import fatec.jvprojects.chromodoroapi.model.Usuario;
import fatec.jvprojects.chromodoroapi.repository.IUsuarioRepository;
import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@Service
public class UsuarioServico implements IUsuarioServico {

    Logger logger = LogManager.getLogger(this.getClass());

    private IUsuarioRepository usuarioRepository;

    public UsuarioServico(IUsuarioRepository usuarioRepository) {
        this.usuarioRepository = usuarioRepository;
    }


    @Override
    public Optional<Usuario> salvarUsuario(Usuario usuario) {
        logger.info("|--- Serviço - Salvar usuário ---|");

        return Optional.of(usuarioRepository.insert(usuario));
    }

    @Override
    public List<Usuario> listarUsuarios() {
        logger.info("|--- Serviço - Listar usuários ---|");

        return usuarioRepository.findAll();
    }

    @Override
    public Optional<Usuario> encontrarPorEmail(String email) {
        logger.info("|--- Serviço - Encontrar usuário por email ---|");

        return usuarioRepository.findUsuarioByEmail(email);
    }


    @Override
    public Optional<Usuario> atualizarUsuario(Usuario usuario) {
        logger.info("|--- Serviço - Atualizar usuário ---|");

        return Optional.of(usuarioRepository.save(usuario));
    }

    @Override
    public void deletarUsuario(Usuario usuario) {
        logger.info("|--- Serviço - Deletar usuário ---|");
    }
}
