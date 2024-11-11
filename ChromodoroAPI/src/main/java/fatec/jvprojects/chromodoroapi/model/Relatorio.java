package fatec.jvprojects.chromodoroapi.model;

import java.time.LocalTime;

public class Relatorio {
    private String id;

    private LocalTime totalHorasPomodoro = LocalTime.of(0,0,0);

    private LocalTime totalHorasPausadas = LocalTime.of(0, 0, 0);

    private int totalTarefasConcluidas = 0;

    public Relatorio() {

    }

    public Relatorio(String id, LocalTime totalHorasPomodoro, LocalTime totalHorasPausadas, int totalTarefasConcluidas) {
        this.id = id;
        this.totalHorasPomodoro = totalHorasPomodoro;
        this.totalHorasPausadas = totalHorasPausadas;
        this.totalTarefasConcluidas = totalTarefasConcluidas;
    }

    public String getId() {
        return id;
    }

    public void setId(String id) {
        this.id = id;
    }

    public LocalTime getTotalHorasPomodoro() {
        return totalHorasPomodoro;
    }

    public void setTotalHorasPomodoro(LocalTime totalHorasPomodoro) {
        this.totalHorasPomodoro = totalHorasPomodoro;
    }

    public LocalTime getTotalHorasPausadas() {
        return totalHorasPausadas;
    }

    public void setTotalHorasPausadas(LocalTime totalHorasPausadas) {
        this.totalHorasPausadas = totalHorasPausadas;
    }

    public int getTotalTarefasConcluidas() {
        return totalTarefasConcluidas;
    }

    public void setTotalTarefasConcluidas(int totalTarefasConcluidas) {
        this.totalTarefasConcluidas = totalTarefasConcluidas;
    }
}
