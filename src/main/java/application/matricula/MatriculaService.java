package application.matricula;

import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.stereotype.Service;
import org.springframework.web.server.ResponseStatusException;

import application.aluno.Aluno;
import application.aluno.AlunoService;
import application.curso.Curso;
import application.curso.CursoService;


@Service
public class MatriculaService {
    @Autowired
    private MatriculaRepository matriculaRepo;

    @Autowired
    private AlunoService alunoService;

    @Autowired
    private CursoService cursoService;

    public Iterable<MatriculaDTO> findAll() {
        return matriculaRepo.findAll().stream().map(MatriculaDTO::new).toList();
    }

    public Iterable<MatriculaDTO> getAlunoById(long alunoId) {
        return matriculaRepo.findByAlunoId(alunoId).stream().map(MatriculaDTO::new).toList();
    }

    public Iterable<MatriculaDTO> getCursoById(long cursoId) {
        return matriculaRepo.findByCursoId(cursoId).stream().map(MatriculaDTO::new).toList();
    }

    public MatriculaDTO getOne(Long id) {
        Optional<Matricula> matricula = matriculaRepo.findById(id);

        if (matricula.isEmpty()) {
            throw new ResponseStatusException(HttpStatus.NOT_FOUND, "Matrícula não encontrada");
        }
        return new MatriculaDTO(matricula.get());
    }

    public MatriculaDTO insert(MatriculaInsertDTO dados) {
        Aluno aluno = alunoService.getAluno(dados.alunoId());
        Curso curso = cursoService.getCurso(dados.cursoId());

        Matricula matricula = new Matricula();
        matricula.setStatus(dados.status());
        matricula.setDataMatricula(dados.dataMatricula());
        matricula.setAluno(aluno);
        matricula.setCurso(curso);

        return new MatriculaDTO(matriculaRepo.save(matricula));
    }

    public MatriculaDTO update(Long id, MatriculaInsertDTO dados) {
        Optional<Matricula> matricula = matriculaRepo.findById(id);

        if (matricula.isEmpty()) {
            throw new ResponseStatusException(HttpStatus.NOT_FOUND, "Matrícula não encontrada");
        }

        Aluno aluno = alunoService.getAluno(dados.alunoId());
        Curso curso = cursoService.getCurso(dados.cursoId());
        // Permite atualizar dados parciais pelo metodo PUT
        if (dados.status() != null) {
            matricula.get().setStatus(dados.status());
        }

        if (dados.dataMatricula() != null) {
            matricula.get().setDataMatricula(dados.dataMatricula());
        }

        if (dados.alunoId() != null) {
            matricula.get().setAluno(aluno);
        }

        if (dados.cursoId() != null) {
            matricula.get().setCurso(curso);
        }

        return new MatriculaDTO(matriculaRepo.save(matricula.get()));
    }

    public void delete(Long id) {
        Optional<Matricula> matricula = matriculaRepo.findById(id);

        if (matricula.isEmpty()) {
            throw new ResponseStatusException(HttpStatus.NOT_FOUND, "Matrícula não encontrada");
        }

        matriculaRepo.delete(matricula.get());
    }
}
