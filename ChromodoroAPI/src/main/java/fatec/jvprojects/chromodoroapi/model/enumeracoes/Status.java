package fatec.jvprojects.chromodoroapi.model.enumeracoes;

public enum Status {
    ANDAMENTO("Em andamento", "0"),
    CONCLUIDO("Concluído", "1");

    private final String statusNome;

    private final String codigo;

    Status(String status, String codigo) {
        this.statusNome = status;
        this.codigo = codigo;
    }

    public String getStatusNome() {
        return statusNome;
    }

    public String getCodigo() {
        return codigo;
    }
}
