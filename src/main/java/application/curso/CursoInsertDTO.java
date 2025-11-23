package application.curso;

import java.time.LocalDateTime;
import io.swagger.v3.oas.annotations.media.Schema;

public record CursoInsertDTO(
	@Schema(description = "Nome do curso", example = "Introdução a Java", requiredMode = Schema.RequiredMode.REQUIRED) String nome,
	@Schema(description = "Descrição do curso", example = "Curso introdutório de Java") String descricao,
	@Schema(description = "Carga horária em horas", example = "40") Integer cargaHoraria,
	@Schema(description = "Status do curso", example = "ATIVO") String status,
	@Schema(description = "Data de criação do curso", example = "2023-04-01T10:00:00") LocalDateTime dataCriacao
) {

}
