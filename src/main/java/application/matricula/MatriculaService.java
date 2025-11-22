package application.matricula;

import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.stereotype.Service;
import org.springframework.web.server.ResponseStatusException;

import application.aluno.Aluno;
import application.aluno.AlunoService;
import application.aluno.AlunoDTO;
import application.curso.Curso;
import application.curso.CursoDTO;
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
      


    }

}
