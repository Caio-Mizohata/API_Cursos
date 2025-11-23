package application.curso;

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
@RequestMapping("/cursos")
@Tag(name = "Cursos", description = "Operações de inserção, consulta, atualização e exclusão de cursos no endpoint /cursos")
public class CursoController {
    @Autowired
    private CursoService cursoService;

    @GetMapping
    @Operation(summary = "Listar todos os cursos", description = "Retorna uma lista de todos os cursos disponíveis.")
    @ApiResponse(responseCode = "200", description = "Lista de cursos retornada com sucesso")
    public Iterable<CursoDTO> findAll() {
        return cursoService.findAll();
    }

    @GetMapping("/{id}")
    @Operation(summary = "Obter um curso pelo ID", description = "Retorna os detalhes de um curso específico pelo seu ID.")
    @ApiResponses({
        @ApiResponse(responseCode = "200", description = "Curso encontrado com sucesso"),
        @ApiResponse(responseCode = "404", description = "Curso não encontrado")
    })
    public CursoDTO getOne(@Parameter(description = "ID do curso", required = true) @PathVariable long id) {
        return cursoService.getOne(id);
    }

    @PostMapping
    @Operation(summary = "Inserir um novo registro de um curso", description = "Adiciona um novo curso ao sistema com os dados fornecidos.")
    @ApiResponse(responseCode = "201", description = "Curso inserido com sucesso")
    public CursoDTO insert(@RequestBody CursoInsertDTO dados) {
        return cursoService.insert(dados);  
    }

    @PutMapping("/{id}")
    @Operation(summary = "Atualizar um registro de curso existente", description = "Atualiza os dados de um curso existente pelo seu ID.")
    @ApiResponses({
        @ApiResponse(responseCode = "200", description = "Curso atualizado com sucesso"),
        @ApiResponse(responseCode = "404", description = "Curso não encontrado")
    })
    public CursoDTO update(@Parameter(description = "ID do curso", required = true) @PathVariable long id, @RequestBody CursoInsertDTO dados) {
        return cursoService.update(id, dados);
    }  

    @DeleteMapping("/{id}")
    @Operation(summary = "Excluir um registro de curso", description = "Remove um curso do sistema pelo seu ID.")
    @ApiResponses({
        @ApiResponse(responseCode = "204", description = "Curso excluído com sucesso"),
        @ApiResponse(responseCode = "404", description = "Curso não encontrado")
    })
    public void delete(@Parameter(description = "ID do curso", required = true) @PathVariable long id) {
        cursoService.delete(id);
    }
}
