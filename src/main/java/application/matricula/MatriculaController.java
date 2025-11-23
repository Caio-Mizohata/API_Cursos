package application.matricula;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;

import io.swagger.v3.oas.annotations.Operation;
import io.swagger.v3.oas.annotations.Parameter;
import io.swagger.v3.oas.annotations.responses.ApiResponse;
import io.swagger.v3.oas.annotations.responses.ApiResponses;
import io.swagger.v3.oas.annotations.tags.Tag;

@RestController
@RequestMapping("/matriculas")
@Tag(name = "Matrículas", description = "Operações de inserção, consulta, atualização e exclusão de matrículas no endpoint /matriculas")
public class MatriculaController {
    @Autowired
    private MatriculaService matriculaService;

    @GetMapping
    @Operation(summary = "Listar todas as matrículas", description = "Retorna uma lista com todas as matrículas cadastradas")
    @ApiResponse(responseCode = "200", description = "Lista de todas as matrículas retornada com sucesso")
    public Iterable<MatriculaDTO> findAll() {
        return matriculaService.findAll();
    }

    @GetMapping("/aluno/{alunoId}")
    @Operation(summary = "Listar matrículas por ID do aluno", description = "Retorna uma lista de matrículas associadas a um aluno específico pelo seu ID")
    @ApiResponse(responseCode = "200", description = "Lista de matrículas do aluno retornada com sucesso")
    public Iterable<MatriculaDTO> findByAlunoId(@Parameter(description = "ID do aluno", required = true) @PathVariable long alunoId) {
        return matriculaService.getAlunoById(alunoId);
    }

    @GetMapping("/curso/{cursoId}")
    @Operation(summary = "Listar matrículas por ID do curso", description = "Retorna uma lista de matrículas associadas a um curso específico pelo seu ID")
    @ApiResponse(responseCode = "200", description = "Lista de matrículas do curso retornada com sucesso")
    public Iterable<MatriculaDTO> findByCursoId(@Parameter(description = "ID do curso", required = true) @PathVariable long cursoId) {
        return matriculaService.getCursoById(cursoId);
    }

    @PostMapping
    @Operation(summary = "Inserir um novo registro de uma matrícula", description = "Adiciona uma nova matrícula ao sistema com os dados fornecidos")
    @ApiResponse(responseCode = "201", description = "Matrícula inserida com sucesso")
    public MatriculaDTO insert(@RequestBody MatriculaInsertDTO dados) {
        return matriculaService.insert(dados);
    }

    @PutMapping("/{id}")
    @Operation(summary = "Atualizar um registro de matrícula existente", description = "Atualiza os dados de uma matrícula existente pelo seu ID")
    @ApiResponses({
        @ApiResponse(responseCode = "200", description = "Matrícula atualizada com sucesso"),
        @ApiResponse(responseCode = "404", description = "Matrícula não encontrada")
    })
    public MatriculaDTO update(@Parameter(description = "ID da matrícula", required = true) @PathVariable Long id, @RequestBody MatriculaInsertDTO dados) {
        return matriculaService.update(id, dados);
    }

    @DeleteMapping("/{id}")
    @Operation(summary = "Excluir um registro de matrícula existente", description = "Remove uma matrícula do sistema pelo seu ID")
    @ApiResponses({
        @ApiResponse(responseCode = "204", description = "Matrícula excluída com sucesso"),
        @ApiResponse(responseCode = "404", description = "Matrícula não encontrada")
    })
    public void delete(@Parameter(description = "ID da matrícula", required = true) @PathVariable Long id) {
        matriculaService.delete(id);
    }
}
