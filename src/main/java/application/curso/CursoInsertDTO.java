package application.curso;

import java.time.LocalDateTime;
    
public record CursoInsertDTO(String nome, String descricao, Integer cargaHoraria, String status, LocalDateTime dataCriacao) {
    
}
