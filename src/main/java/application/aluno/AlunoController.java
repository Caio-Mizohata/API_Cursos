package application.aluno;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import io.swagger.v3.oas.annotations.Operation;
import io.swagger.v3.oas.annotations.Parameter;
import io.swagger.v3.oas.annotations.responses.ApiResponse;
import io.swagger.v3.oas.annotations.responses.ApiResponses;
import io.swagger.v3.oas.annotations.tags.Tag;

@RestController
@RequestMapping("/alunos")
@Tag(name = "Alunos", description = "Operações de inserção, consulta, atualização e exclusão de alunos no endpoint /alunos")
public class AlunoController {
    @Autowired
    private AlunoService alunoService;

    @GetMapping
    @Operation(summary = "Listar todos os alunos", description = "Retorna uma lista com todos os alunos cadastrados")
    @ApiResponse(responseCode = "200", description = "Lista de todos os alunos retornada com sucesso")
    public Iterable<AlunoDTO> getAll() {
        return alunoService.getAll();
    }

    @GetMapping("/{id}")
    @Operation(summary = "Obter um aluno pelo ID", description = "Retorna os detalhes de um aluno específico pelo seu ID atribuído")
    @ApiResponses({
        @ApiResponse(responseCode = "200", description = "Aluno encontrado com sucesso"), 
        @ApiResponse(responseCode = "404", description = "Aluno não encontrado")
    })
    public AlunoDTO getOne(@Parameter(description = "ID do aluno", required = true) @PathVariable Long id) {
        return alunoService.getOne(id);
    }

    @PostMapping
    @Operation(summary = "Inserir um novo registro de um aluno", description = "Adiciona um novo aluno ao sistema com os dados fornecidos")
    @ApiResponse(responseCode = "201", description = "Aluno inserido com sucesso")
    public AlunoDTO insert(@RequestBody AlunoInsertDTO dados) {
        return alunoService.insert(dados);
    }

    @PutMapping("/{id}")
    @Operation(summary = "Atualizar um registro de aluno existente", description = "Atualiza os dados de um aluno existente pelo seu ID")
    @ApiResponses({
        @ApiResponse(responseCode = "200", description = "Aluno atualizado com sucesso"), 
        @ApiResponse(responseCode = "404", description = "Aluno não encontrado")
    })
    public AlunoDTO update(@Parameter(description = "ID do aluno", required = true) @PathVariable long id, @RequestBody AlunoInsertDTO dados) {
        return alunoService.update(id, dados);
    }

    @DeleteMapping("/{id}")
    @Operation(summary = "Excluir um registro de aluno", description = "Remove um aluno do sistema pelo seu ID")
    @ApiResponses({
        @ApiResponse(responseCode = "204", description = "Aluno excluído com sucesso"), 
        @ApiResponse(responseCode = "404", description = "Aluno não encontrado")
    })
    public void delete(@Parameter(description = "ID do aluno", required = true) @PathVariable long id) {
        alunoService.delete(id);
    }
}
