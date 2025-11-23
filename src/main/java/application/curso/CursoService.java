package application.curso;

import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.stereotype.Service;
import org.springframework.web.server.ResponseStatusException;

@Service
public class CursoService {
    @Autowired
    private CursoRepository cursoRepo;

    public Iterable<CursoDTO> findAll() {
        return cursoRepo.findAll().stream().map(CursoDTO::new).toList();
    }

    public Curso getCurso(Long id) {
       Optional<Curso> curso = cursoRepo.findById(id);

       if (curso.isEmpty()) {
            throw new ResponseStatusException(HttpStatus.NOT_FOUND,"Curso não encontrado");
       }
       return curso.get();
    }

    public CursoDTO getOne(long id) {
        Optional<Curso> curso = cursoRepo.findById(id);

        if (curso.isEmpty()) {
            throw new ResponseStatusException(HttpStatus.NOT_FOUND, "Curso não encontrado");
        }
        return new CursoDTO(curso.get());
    }

    public CursoDTO insert(CursoInsertDTO dados) {
        return new CursoDTO(cursoRepo.save(new Curso(dados)));
    }

    public CursoDTO update(long id, CursoInsertDTO dados) {
        Optional<Curso> curso = cursoRepo.findById(id);

        if (curso.isEmpty()) {
            throw new ResponseStatusException(HttpStatus.NOT_FOUND, "Curso não encontrado");
        }
        // Permite atualizar dados parciais pelo metodo PUT
        if (dados.nome() != null) {
            curso.get().setNome(dados.nome());
        }

        if (dados.descricao() != null) {
            curso.get().setDescricao(dados.descricao());
        }

        if (dados.cargaHoraria() != null) {
            curso.get().setCargaHoraria(dados.cargaHoraria());
        }

        if (dados.status() != null) {
            curso.get().setStatus(dados.status());
        }

        if (dados.dataCriacao() != null) {
            curso.get().setDataCriacao(dados.dataCriacao());
        }

        return new CursoDTO(cursoRepo.save(curso.get()));
    }

    public void delete(long id) {
        Optional<Curso> curso = cursoRepo.findById(id);

        if (curso.isEmpty()) {
            throw new ResponseStatusException(HttpStatus.NOT_FOUND, "Curso não encontrado");
        }

        cursoRepo.deleteById(id);
    }   
}
