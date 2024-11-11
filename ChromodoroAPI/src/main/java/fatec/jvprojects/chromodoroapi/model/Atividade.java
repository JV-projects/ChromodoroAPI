package fatec.jvprojects.chromodoroapi.model;

import fatec.jvprojects.chromodoroapi.model.enumeracoes.Status;
import org.springframework.data.annotation.Id;

public class Atividade {

    @Id
    private String id;

    private String idUsuario;

    private String titulo;

    private String descricao;

    private String status;

    

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

    public String getTitulo() {
        return titulo;
    }

    public void setTitulo(String titulo) {
        this.titulo = titulo;
    }

    public String getDescricao() {
        return descricao;
    }

    public void setDescricao(String descricao) {
        this.descricao = descricao;
    }

    public String getStatus() {
        return status;
    }

    public void setStatus(Status status) {
        if (status != null) {
            this.status = status.getStatusNome();
        }
    }
}
