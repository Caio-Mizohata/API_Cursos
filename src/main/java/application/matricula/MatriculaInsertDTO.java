package application.matricula;

import java.time.LocalDate;
import io.swagger.v3.oas.annotations.media.Schema;

public record MatriculaInsertDTO(
	@Schema(description = "Status da matrícula", example = "ATIVA", requiredMode = Schema.RequiredMode.REQUIRED) String status,
	@Schema(description = "Data da matrícula", example = "2023-04-01") LocalDate dataMatricula,
	@Schema(description = "ID do aluno", example = "1", requiredMode = Schema.RequiredMode.REQUIRED) Long alunoId,
	@Schema(description = "ID do curso", example = "1", requiredMode = Schema.RequiredMode.REQUIRED) Long cursoId
) {
}
