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

import es.eviden.project.entities.Tag;
import es.eviden.project.modelo.service.TagService;

import io.swagger.v3.oas.annotations.Operation;
import io.swagger.v3.oas.annotations.responses.ApiResponse;
import io.swagger.v3.oas.annotations.responses.ApiResponses;
import jakarta.validation.Valid;


@RestController
@RequestMapping("/tag")
@io.swagger.v3.oas.annotations.tags.Tag(name = "Tag", description = "Controlador para la gestión de etiquetas")
public class TagRestController {
    
    @Autowired
    private TagService tserv;


    @PostMapping("/alta")
    @Operation(summary = "Crear una nueva etiqueta", description = "Crea una nueva etiqueta en la base de datos")
    @ApiResponses(value = {
        @ApiResponse(responseCode = "200", description = "Etiqueta creada exitosamente"),
        @ApiResponse(responseCode = "400", description = "Solicitud inválida")
    })
    public Tag alta(@Valid @RequestBody Tag tag) {
        return tserv.alta(tag);
    }

 
    @PutMapping("/modificar")
    @Operation(summary = "Modificar una etiqueta", description = "Modifica una etiqueta existente en la base de datos")
    @ApiResponses(value = {
        @ApiResponse(responseCode = "200", description = "Etiqueta modificada exitosamente"),
        @ApiResponse(responseCode = "400", description = "Solicitud inválida"),
        @ApiResponse(responseCode = "404", description = "Etiqueta no encontrada")
    })
    public Tag modificar(@Valid @RequestBody Tag tag) {
        return tserv.modificar(tag);
    }


    @DeleteMapping("/eliminar")
    @Operation(summary = "Eliminar una etiqueta", description = "Elimina una etiqueta de la base de datos")
    @ApiResponses(value = {
        @ApiResponse(responseCode = "200", description = "Etiqueta eliminada exitosamente"),
        @ApiResponse(responseCode = "400", description = "Solicitud inválida"),
        @ApiResponse(responseCode = "404", description = "Etiqueta no encontrada")
    })
    public int eliminar(@Valid @RequestBody Tag tag) {
        return tserv.eliminar(tag);
    }


    @DeleteMapping("/eliminar/{id}")
    @Operation(summary = "Eliminar una etiqueta por ID", description = "Elimina una etiqueta de la base de datos utilizando su ID")
    @ApiResponses(value = {
        @ApiResponse(responseCode = "200", description = "Etiqueta eliminada exitosamente"),
        @ApiResponse(responseCode = "400", description = "Solicitud inválida"),
        @ApiResponse(responseCode = "404", description = "Etiqueta no encontrada")
    })
    public int eliminarPorId(@PathVariable Long id) {
        return tserv.eliminarPorId(id);
    }


    @GetMapping("/buscar/{id}")
    @Operation(summary = "Buscar una etiqueta por ID", description = "Busca una etiqueta en la base de datos utilizando su ID")
    @ApiResponses(value = {
        @ApiResponse(responseCode = "200", description = "Etiqueta encontrada exitosamente"),
        @ApiResponse(responseCode = "404", description = "Etiqueta no encontrada")
    })
    public Tag buscarPorId(@PathVariable Long id) {
        return tserv.buscarPorId(id);
    }


    @GetMapping("/todos")
    @Operation(summary = "Buscar todas las etiquetas", description = "Busca todas las etiquetas en la base de datos")
    @ApiResponses(value = {
        @ApiResponse(responseCode = "200", description = "Etiquetas encontradas exitosamente")
    })
    public List<Tag> buscarTodos() {
        return tserv.buscarTodos();
    }
    
}
