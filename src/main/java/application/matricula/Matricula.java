package application.matricula;

import java.time.LocalDate;
import application.aluno.Aluno;
import application.curso.Curso;

import jakarta.persistence.Entity;
import jakarta.persistence.Table;
import jakarta.persistence.Id;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Column;
import jakarta.persistence.ManyToOne;
import jakarta.persistence.JoinColumn;

import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

@Entity
@Table(name = "matriculas")
@Getter
@Setter
@NoArgsConstructor
public class Matricula {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    @Column(nullable = false)
    private String status;

    @Column(nullable = false)
    private LocalDate dataMatricula;

    @ManyToOne
    @JoinColumn(name = "aluno_id", nullable = false) 
    private Aluno aluno;

    @ManyToOne
    @JoinColumn(name = "curso_id", nullable = false) 
    private Curso curso;

}
