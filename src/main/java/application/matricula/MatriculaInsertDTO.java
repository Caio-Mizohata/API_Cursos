package application.matricula;

import java.time.LocalDate;

public record MatriculaInsertDTO(String status, LocalDate dataMatricul, Long alunoId, Long cursoId) {
    
}
