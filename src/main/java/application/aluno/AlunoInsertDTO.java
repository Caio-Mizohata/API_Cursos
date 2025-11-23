package application.aluno;

import java.time.LocalDate;
import io.swagger.v3.oas.annotations.media.Schema;

public record AlunoInsertDTO(
	@Schema(description = "Nome completo do aluno", example = "João Silva", requiredMode = Schema.RequiredMode.REQUIRED) String nome,
	@Schema(description = "Email do aluno", example = "joao@example.com", requiredMode = Schema.RequiredMode.REQUIRED) String email,
	@Schema(description = "Telefone de contato", example = "+5511999999999") String telefone,
	@Schema(description = "Data de matrícula", example = "2023-04-01") LocalDate dataMatricula
) {

}
