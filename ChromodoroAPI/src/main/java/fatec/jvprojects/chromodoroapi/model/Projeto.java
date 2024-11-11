package fatec.jvprojects.chromodoroapi.model;

import org.springframework.data.mongodb.core.mapping.Document;

import java.util.List;

@Document(collection = "Projetos")
public class Projeto extends Atividade {

    private List<Tarefa> tarefas;

    public Projeto() {

    }

    public Projeto(List<Tarefa> tarefas) {
        super();
        this.tarefas = tarefas;
    }

    public List<Tarefa> getTarefas() {
        return tarefas;
    }

    public void setTarefas(List<Tarefa> tarefas) {
        this.tarefas = tarefas;
    }
}

