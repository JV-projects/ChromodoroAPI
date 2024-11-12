package fatec.jvprojects.chromodoroapi.model;

import org.springframework.data.mongodb.core.mapping.Document;

import java.util.List;

@Document(collection = "Projetos")
public class Projeto extends Atividade {

    private List<Tarefa> tarefas;

    public Projeto(Usuario idUsuario, String titulo, String descricao, String status) {
        super(idUsuario, titulo, descricao, status);
    }

    public Projeto(Usuario idUsuario, String titulo, String descricao, String status, List<Tarefa> tarefas) {
        super(idUsuario, titulo, descricao, status);
        this.tarefas = tarefas;
    }

    public List<Tarefa> getTarefas() {
        return tarefas;
    }

    public void setTarefas(List<Tarefa> tarefas) {
        this.tarefas = tarefas;
    }
}

