package application.matricula;

import java.time.LocalDate;
import application.aluno.AlunoDTO;
import application.curso.CursoDTO;

public record MatriculaDTO(Long id, String status, LocalDate dataMatricula, AlunoDTO aluno, CursoDTO curso) {
    public MatriculaDTO(Matricula matricula) {
        this(matricula.getId(), matricula.getStatus(), matricula.getDataMatricula(), new AlunoDTO(matricula.getAluno()), new CursoDTO(matricula.getCurso()));
    }
}
