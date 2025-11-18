package application.aluno;

import java.time.LocalDate;

public record AlunoInsertDTO(String nome, String email, String telefone, LocalDate dataMatricula) {
    
}
