package application.curso;

import java.time.LocalDateTime;
    
public record CursoInsertDTO(String nome, String descricao, Integer duracaoHoras, String status, LocalDateTime dataCriacao) {
    
}
