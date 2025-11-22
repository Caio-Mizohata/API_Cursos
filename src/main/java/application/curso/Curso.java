package application.curso;

import java.time.LocalDateTime;

import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.Table;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

@Entity
@Table(name = "cursos")
@Getter
@Setter
@NoArgsConstructor
public class Curso {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    @Column(nullable = false)
    private String nome;

    @Column(nullable = false)
    private String descricao;

    @Column(nullable = false)
    private Integer cargaHoraria;

    @Column(nullable = false)
    private String status;

    @Column(nullable = false)
    private LocalDateTime dataCriacao;

    public Curso(CursoInsertDTO dados) {
        this.nome = dados.nome();
        this.descricao = dados.descricao();
        this.cargaHoraria = dados.cargaHoraria();
        this.status = dados.status();
        this.dataCriacao = dados.dataCriacao();
    }
}
