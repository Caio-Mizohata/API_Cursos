package application.matricula;

import java.time.LocalDate;
import application.aluno.AlunoDTO;
import application.curso.CursoDTO;
import io.swagger.v3.oas.annotations.media.Schema;

public record MatriculaDTO(
    @Schema(description = "ID da matrícula", example = "1") Long id,
    @Schema(description = "Status da matrícula", example = "ATIVA") String status,
    @Schema(description = "Data da matrícula", example = "2023-04-01") LocalDate dataMatricula,
    @Schema(description = "Dados do aluno associado") AlunoDTO aluno,
    @Schema(description = "Dados do curso associado") CursoDTO curso
) {
    public MatriculaDTO(Matricula matricula) {
        this(matricula.getId(), matricula.getStatus(), matricula.getDataMatricula(), new AlunoDTO(matricula.getAluno()), new CursoDTO(matricula.getCurso()));
    }
}
