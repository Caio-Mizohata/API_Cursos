package application.matricula;

import java.time.LocalDate;
import application.aluno.Aluno; 
import application.curso.Curso; 

import jakarta.persistence.*;
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