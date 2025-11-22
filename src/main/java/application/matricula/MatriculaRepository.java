package application.matricula;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;

public interface MatriculaRepository extends JpaRepository<Matricula, Long> {
	List<Matricula> findByAlunoId(Long alunoId);
    List<Matricula> findByCursoId(Long cursoId);
}
