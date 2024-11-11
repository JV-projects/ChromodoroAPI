package fatec.jvprojects.chromodoroapi.model;

import org.springframework.data.annotation.Id;
import org.springframework.data.mongodb.core.mapping.Document;

import java.time.LocalTime;

@Document(collection = "Pomodoros")
public class Pomodoro {

    @Id
    private String id;

    private String idUsuario;

    private LocalTime tempoPomodoro;

    private LocalTime tempoPausaCurta;

    private LocalTime tempoPausaLonga;

    public Pomodoro() {
    }

    public Pomodoro(String id, String idUsuario, LocalTime tempoPomodoro, LocalTime tempoPausaCurta, LocalTime tempoPausaLonga) {
        this.id = id;
        this.idUsuario = idUsuario;
        this.tempoPomodoro = tempoPomodoro;
        this.tempoPausaCurta = tempoPausaCurta;
        this.tempoPausaLonga = tempoPausaLonga;
    }

    public String getId() {
        return id;
    }

    public void setId(String id) {
        this.id = id;
    }

    public String getIdUsuario() {
        return idUsuario;
    }

    public void setIdUsuario(String idUsuario) {
        this.idUsuario = idUsuario;
    }

    public LocalTime getTempoPomodoro() {
        return tempoPomodoro;
    }

    public void setTempoPomodoro(LocalTime tempoPomodoro) {
        this.tempoPomodoro = tempoPomodoro;
    }

    public LocalTime getTempoPausaCurta() {
        return tempoPausaCurta;
    }

    public void setTempoPausaCurta(LocalTime tempoPausaCurta) {
        this.tempoPausaCurta = tempoPausaCurta;
    }

    public LocalTime getTempoPausaLonga() {
        return tempoPausaLonga;
    }

    public void setTempoPausaLonga(LocalTime tempoPausaLonga) {
        this.tempoPausaLonga = tempoPausaLonga;
    }
}
