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

import es.eviden.project.entities.Blog;
import es.eviden.project.modelo.service.BlogService;

import io.swagger.v3.oas.annotations.Operation;
import io.swagger.v3.oas.annotations.tags.Tag;
import jakarta.validation.Valid;
import io.swagger.v3.oas.annotations.responses.ApiResponse;
import io.swagger.v3.oas.annotations.responses.ApiResponses;

/**
 * BlogRestController es una clase que expone servicios REST para la gestión de blogs.
 * Utiliza el servicio BlogService para realizar operaciones CRUD.
 */
@RestController
@RequestMapping("/blog")
@Tag(name = "Blog", description = "Controlador para la gestión de blogs")
public class BlogRestContoller {
    
    @Autowired
    private BlogService bserv;

    
    @PostMapping("/alta")
    @Operation(summary = "Crear un nuevo blog", description = "Crea un nuevo blog en la base de datos")
    @ApiResponses(value = {
        @ApiResponse(responseCode = "200", description = "Blog creado exitosamente"),
        @ApiResponse(responseCode = "400", description = "Solicitud inválida")
    })
    public Blog alta(@Valid @RequestBody Blog blog) {
        return bserv.alta(blog);
    }

    
    @PutMapping("/modificar")
    @Operation(summary = "Modificar un blog", description = "Modifica un blog existente en la base de datos")
    @ApiResponses(value = {
        @ApiResponse(responseCode = "200", description = "Blog modificado exitosamente"),
        @ApiResponse(responseCode = "400", description = "Solicitud inválida"),
        @ApiResponse(responseCode = "404", description = "Blog no encontrado")
    })
    public Blog modificar(@Valid @RequestBody Blog blog) {
        return bserv.modificar(blog);
    }

    
    @DeleteMapping("/eliminar")
    @Operation(summary = "Eliminar un blog", description = "Elimina un blog de la base de datos")
    @ApiResponses(value = {
        @ApiResponse(responseCode = "200", description = "Blog eliminado exitosamente"),
        @ApiResponse(responseCode = "400", description = "Solicitud inválida"),
        @ApiResponse(responseCode = "404", description = "Blog no encontrado")
    })
    public int eliminar(@Valid @RequestBody Blog blog) {
        return bserv.eliminar(blog);
    }

    
    @DeleteMapping("/eliminar/{id}")
    @Operation(summary = "Eliminar un blog por ID", description = "Elimina un blog de la base de datos utilizando su ID")
    @ApiResponses(value = {
        @ApiResponse(responseCode = "200", description = "Blog eliminado exitosamente"),
        @ApiResponse(responseCode = "400", description = "Solicitud inválida"),
        @ApiResponse(responseCode = "404", description = "Blog no encontrado")
    })
    public int eliminarPorId(@PathVariable Long id) {
        return bserv.eliminarPorId(id);
    }

    
    @GetMapping("/buscar/{id}")
    @Operation(summary = "Buscar un blog por ID", description = "Busca un blog en la base de datos utilizando su ID")
    @ApiResponses(value = {
        @ApiResponse(responseCode = "200", description = "Blog encontrado exitosamente"),
        @ApiResponse(responseCode = "404", description = "Blog no encontrado")
    })
    public Blog buscarPorId(@PathVariable Long id) {
        return bserv.buscarPorId(id);
    }

    
    @GetMapping("/todos")
    @Operation(summary = "Buscar todos los blogs", description = "Busca todos los blogs en la base de datos")
    @ApiResponses(value = {
        @ApiResponse(responseCode = "200", description = "Blogs encontrados exitosamente")
    })
    public List<Blog> buscarTodos() {
        return bserv.buscarTodos();
    }
    
}
