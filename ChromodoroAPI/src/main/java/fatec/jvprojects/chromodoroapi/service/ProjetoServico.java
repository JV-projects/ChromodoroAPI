package fatec.jvprojects.chromodoroapi.service;

import fatec.jvprojects.chromodoroapi.model.Projeto;
import fatec.jvprojects.chromodoroapi.model.Usuario;
import fatec.jvprojects.chromodoroapi.repository.IProjetoRepository;
import fatec.jvprojects.chromodoroapi.repository.IUsuarioRepository;
import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@Service
public class ProjetoServico implements IProjetoServico {

    Logger logger = LogManager.getLogger(this.getClass());

    private IProjetoRepository projetoRepository;

    private IUsuarioRepository usuarioRepository;

    public ProjetoServico(IProjetoRepository projetoRepository, IUsuarioRepository usuarioRepository) {
        this.projetoRepository = projetoRepository;
        this.usuarioRepository = usuarioRepository;
    }

    @Override
    public Optional<Projeto> salvarProjeto(Projeto projeto, String email) {
        logger.info("|--- Serviço - Salvar projeto ---|");

        return usuarioRepository.findUsuarioByEmail(email).map(
                usuarioFind -> {
                    projeto.setIdUsuario(usuarioFind);
                    return projetoRepository.save(projeto);
                }
        );
    }

    @Override
    public List<Projeto> listarProjetosUsuario(String email) {
        logger.info("|--- Serviço - Listar projetos do usuário ---|");

        return projetoRepository.findProjetoByIdUsuarioEmail(email);
    }

    @Override
    public Optional<Projeto> atualizarProjeto(Projeto newProjeto) {
        logger.info("|--- Serviço - Atualizar projeto ---|");

        return projetoRepository.findById(newProjeto.getId())
                .map( projeto -> {
                    projeto.setTitulo(newProjeto.getTitulo());
                    projeto.setDescricao(newProjeto.getDescricao());
                    projeto.setStatus(newProjeto.getStatus());
                    projeto.setTarefas(newProjeto.getTarefas());
                    return projetoRepository.save(projeto);
                });
    }

    @Override
    public void deletarProjeto(String idProjeto) {
        logger.info("|--- Serviço - Deletar projeto ---|");

        projetoRepository.deleteById(idProjeto);
    }
}
