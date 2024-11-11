package fatec.jvprojects.chromodoroapi.model;


import org.springframework.data.mongodb.core.mapping.Document;

import java.time.LocalTime;

@Document(collection = "Tarefas")
public class Tarefa extends Atividade {

    private Projeto idProjeto;

    private int estCiclos;

    private int totalCiclos;

    private LocalTime totalTempo;

    private LocalTime totalPausa;

    public Tarefa(String idUsuario, String titulo, String descricao, String status, Projeto idProjeto, int estCiclos, int totalCiclos, LocalTime totalTempo, LocalTime totalPausa) {
        super(idUsuario, titulo, descricao, status);
        this.idProjeto = idProjeto;
        this.estCiclos = estCiclos;
        this.totalCiclos = totalCiclos;
        this.totalTempo = totalTempo;
        this.totalPausa = totalPausa;
    }

    public Projeto getIdProjeto() {
        return idProjeto;
    }

    public void setIdProjeto(Projeto idProjeto) {
        this.idProjeto = idProjeto;
    }

    public int getEstCiclos() {
        return estCiclos;
    }

    public void setEstCiclos(int estCiclos) {
        this.estCiclos = estCiclos;
    }

    public int getTotalCiclos() {
        return totalCiclos;
    }

    public void setTotalCiclos(int totalCiclos) {
        this.totalCiclos = totalCiclos;
    }

    public LocalTime getTotalTempo() {
        return totalTempo;
    }

    public void setTotalTempo(LocalTime totalTempo) {
        this.totalTempo = totalTempo;
    }

    public LocalTime getTotalPausa() {
        return totalPausa;
    }

    public void setTotalPausa(LocalTime totalPausa) {
        this.totalPausa = totalPausa;
    }
}
