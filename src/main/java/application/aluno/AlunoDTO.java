package application.aluno;

import java.time.LocalDate;
import io.swagger.v3.oas.annotations.media.Schema;

public record AlunoDTO(
    @Schema(description = "ID do aluno", example = "1") long id,
    @Schema(description = "Nome completo do aluno", example = "João Silva") String nome,
    @Schema(description = "Email do aluno", example = "joao@example.com") String email,
    @Schema(description = "Telefone de contato", example = "+5511999999999") String telefone,
    @Schema(description = "Data de matrícula do aluno", example = "2023-04-01") LocalDate dataMatricula
) {
    public AlunoDTO(Aluno aluno) {
        this(aluno.getId(), aluno.getNome(), aluno.getEmail(), aluno.getTelefone(), aluno.getDataMatricula());
    }
}
