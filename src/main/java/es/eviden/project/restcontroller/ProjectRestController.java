package es.eviden.project.restcontroller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import es.eviden.project.entities.Project;
import es.eviden.project.modelo.service.ProjectService;

import io.swagger.v3.oas.annotations.Operation;
import io.swagger.v3.oas.annotations.tags.Tag;
import jakarta.validation.Valid;
import io.swagger.v3.oas.annotations.responses.ApiResponse;
import io.swagger.v3.oas.annotations.responses.ApiResponses;


@RestController
@RequestMapping("/project")
@Tag(name = "Project", description = "Controlador para la gestión de proyectos")
public class ProjectRestController {

    @Autowired
    private ProjectService pserv;

 
    @PostMapping("/alta")
    @Operation(summary = "Crear un nuevo proyecto", description = "Crea un nuevo proyecto en la base de datos")
    @ApiResponses(value = {
        @ApiResponse(responseCode = "200", description = "Proyecto creado exitosamente"),
        @ApiResponse(responseCode = "400", description = "Solicitud inválida")
    })
    public Project alta(@Valid @RequestBody Project project) {
        return pserv.alta(project);
    }


    @PutMapping("/modificar")
    @Operation(summary = "Modificar un proyecto", description = "Modifica un proyecto existente en la base de datos")
    @ApiResponses(value = {
        @ApiResponse(responseCode = "200", description = "Proyecto modificado exitosamente"),
        @ApiResponse(responseCode = "400", description = "Solicitud inválida"),
        @ApiResponse(responseCode = "404", description = "Proyecto no encontrado")
    })
    public Project modificar(@Valid @RequestBody Project project) {
        return pserv.modificar(project);
    }


    @DeleteMapping("/eliminar")
    @Operation(summary = "Eliminar un proyecto", description = "Elimina un proyecto de la base de datos")
    @ApiResponses(value = {
        @ApiResponse(responseCode = "200", description = "Proyecto eliminado exitosamente"),
        @ApiResponse(responseCode = "400", description = "Solicitud inválida"),
        @ApiResponse(responseCode = "404", description = "Proyecto no encontrado")
    })
    public int eliminar(@Valid @RequestBody Project project) {
        return pserv.eliminar(project);
    }


    @DeleteMapping("/eliminar/{id}")
    @Operation(summary = "Eliminar un proyecto por ID", description = "Elimina un proyecto de la base de datos utilizando su ID")
    @ApiResponses(value = {
        @ApiResponse(responseCode = "200", description = "Proyecto eliminado exitosamente"),
        @ApiResponse(responseCode = "400", description = "Solicitud inválida"),
        @ApiResponse(responseCode = "404", description = "Proyecto no encontrado")
    })
    public int eliminarPorId(@PathVariable Long id) {
        return pserv.eliminarPorId(id);
    }


    @GetMapping("/buscar/{id}")
    @Operation(summary = "Buscar un proyecto por ID", description = "Busca un proyecto en la base de datos utilizando su ID")
    @ApiResponses(value = {
        @ApiResponse(responseCode = "200", description = "Proyecto encontrado exitosamente"),
        @ApiResponse(responseCode = "404", description = "Proyecto no encontrado")
    })
    public Project buscarPorId(@PathVariable Long id) {
        return pserv.buscarPorId(id);
    }


    @GetMapping("/todos")
    @Operation(summary = "Buscar todos los proyectos", description = "Busca todos los proyectos en la base de datos")
    @ApiResponses(value = {
        @ApiResponse(responseCode = "200", description = "Proyectos encontrados exitosamente")
    })
    public List<Project> buscarTodos() {
        return pserv.buscarTodos();
    }
    
}
