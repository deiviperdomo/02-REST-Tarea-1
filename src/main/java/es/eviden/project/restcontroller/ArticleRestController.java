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

import es.eviden.project.entities.Article;
import es.eviden.project.modelo.service.ArticleServiceImpl;

import io.swagger.v3.oas.annotations.Operation;
import io.swagger.v3.oas.annotations.tags.Tag;
import io.swagger.v3.oas.annotations.responses.ApiResponse;
import io.swagger.v3.oas.annotations.responses.ApiResponses;


@RestController
@RequestMapping("/article")
@Tag(name = "Article", description = "Controlador para la gestión de artículos")
public class ArticleRestController {

    @Autowired
    private ArticleServiceImpl articleService;

   
    @PostMapping("/alta")
    @Operation(summary = "Crear un nuevo artículo", description = "Crea un nuevo artículo en la base de datos")
    @ApiResponses(value = {
        @ApiResponse(responseCode = "200", description = "Artículo creado exitosamente"),
        @ApiResponse(responseCode = "400", description = "Solicitud inválida")
    })
    public Article alta(@RequestBody Article article) {
        return articleService.alta(article);
    }
  
    @PutMapping("/modificar")
    @Operation(summary = "Modificar un artículo", description = "Modifica un artículo existente en la base de datos")
    @ApiResponses(value = {
        @ApiResponse(responseCode = "200", description = "Artículo modificado exitosamente"),
        @ApiResponse(responseCode = "400", description = "Solicitud inválida"),
        @ApiResponse(responseCode = "404", description = "Artículo no encontrado")
    })
    public Article modificar(@RequestBody Article article) {
        return articleService.modificar(article);
    }

    @DeleteMapping("/eliminar")
    @Operation(summary = "Eliminar un artículo", description = "Elimina un artículo de la base de datos")
    @ApiResponses(value = {
        @ApiResponse(responseCode = "200", description = "Artículo eliminado exitosamente"),
        @ApiResponse(responseCode = "400", description = "Solicitud inválida"),
        @ApiResponse(responseCode = "404", description = "Artículo no encontrado")
    })
    public int eliminar(@RequestBody Article article) {
        return articleService.eliminar(article);
    }

    @DeleteMapping("/eliminar/{id}")
    @Operation(summary = "Eliminar un artículo por ID", description = "Elimina un artículo de la base de datos utilizando su ID")
    @ApiResponses(value = {
        @ApiResponse(responseCode = "200", description = "Artículo eliminado exitosamente"),
        @ApiResponse(responseCode = "400", description = "Solicitud inválida"),
        @ApiResponse(responseCode = "404", description = "Artículo no encontrado")
    })
    public int eliminarPorId(@PathVariable Long id) {
        return articleService.eliminarPorId(id);
    }

    @GetMapping("/buscar/{id}")
    @Operation(summary = "Buscar un artículo por ID", description = "Busca un artículo en la base de datos utilizando su ID")
    @ApiResponses(value = {
        @ApiResponse(responseCode = "200", description = "Artículo encontrado exitosamente"),
        @ApiResponse(responseCode = "404", description = "Artículo no encontrado")
    })
    public Article buscarPorId(@PathVariable Long id) {
        return articleService.buscarPorId(id);
    }

    @GetMapping("/todos")
    @Operation(summary = "Buscar todos los artículos", description = "Busca todos los artículos en la base de datos")
    @ApiResponses(value = {
        @ApiResponse(responseCode = "200", description = "Artículos encontrados exitosamente")
    })
    public List<Article> buscarTodos() {
        return articleService.buscarTodos();
    }
}