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
        alunoService.getOne(dados.alunoId());
        cursoService.getOne(dados.cursoId());

        Matricula matricula = new Matricula();
        matricula.setStatus(dados.status());
        matricula.setDataMatricula(dados.dataMatricula());

        Aluno aluno = new Aluno();
        aluno.setId(dados.alunoId());
        matricula.setAluno(aluno);

        Curso curso = new Curso();
        curso.setId(dados.cursoId());
        matricula.setCurso(curso);

        return new MatriculaDTO(matriculaRepo.save(matricula));
    }

    public MatriculaDTO update(Long id, MatriculaInsertDTO dados) {
        Optional<Matricula> matricula = matriculaRepo.findById(id);

        if (matricula.isEmpty()) {
            throw new ResponseStatusException(HttpStatus.NOT_FOUND, "Matrícula não encontrada");
        }

        alunoService.getOne(dados.alunoId());
        cursoService.getOne(dados.cursoId());

        matricula.get().setStatus(dados.status());
        matricula.get().setDataMatricula(dados.dataMatricula());

        Aluno aluno = new Aluno();
        aluno.setId(dados.alunoId());
        matricula.get().setAluno(aluno);

        Curso curso = new Curso();
        curso.setId(dados.cursoId());
        matricula.get().setCurso(curso);

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
