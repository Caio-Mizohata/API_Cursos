package application.curso;

import java.time.LocalDateTime;

public record CursoDTO(long id, String nome, String descricao, Integer cargaHoraria, String status, LocalDateTime dataCriacao) {
    public CursoDTO(Curso curso) {
        this(curso.getId(), curso.getNome(), curso.getDescricao(), curso.getCargaHoraria(), curso.getStatus(), curso.getDataCriacao());
    }
}
