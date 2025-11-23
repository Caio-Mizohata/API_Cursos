package application.curso;

import java.time.LocalDateTime;
import io.swagger.v3.oas.annotations.media.Schema;

public record CursoDTO(
    @Schema(description = "ID do curso", example = "1") long id,
    @Schema(description = "Nome do curso", example = "Introdução a Java") String nome,
    @Schema(description = "Descrição do curso", example = "Curso introdutório de Java") String descricao,
    @Schema(description = "Carga horária em horas", example = "40") Integer cargaHoraria,
    @Schema(description = "Status do curso", example = "ATIVO") String status,
    @Schema(description = "Data de criação do curso", example = "2023-04-01T10:00:00") LocalDateTime dataCriacao
) {
    public CursoDTO(Curso curso) {
        this(curso.getId(), curso.getNome(), curso.getDescricao(), curso.getCargaHoraria(), curso.getStatus(), curso.getDataCriacao());
    }
}
