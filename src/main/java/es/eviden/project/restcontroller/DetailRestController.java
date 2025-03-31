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

import es.eviden.project.entities.Detail;
import es.eviden.project.modelo.service.DetailService;

import io.swagger.v3.oas.annotations.Operation;
import io.swagger.v3.oas.annotations.tags.Tag;
import io.swagger.v3.oas.annotations.responses.ApiResponse;
import io.swagger.v3.oas.annotations.responses.ApiResponses;


@RestController
@RequestMapping("/detail")
@Tag(name = "Detail", description = "Controlador para la gestión de detalles")
public class DetailRestController {
    
    @Autowired
    private DetailService dserv;

    
    @PostMapping("/alta")
    @Operation(summary = "Crear un nuevo detalle", description = "Crea un nuevo detalle en la base de datos")
    @ApiResponses(value = {
        @ApiResponse(responseCode = "200", description = "Detalle creado exitosamente"),
        @ApiResponse(responseCode = "400", description = "Solicitud inválida")
    })
    public Detail alta(@RequestBody Detail detail) {
        return dserv.alta(detail);
    }

    
    @PutMapping("/modificar")
    @Operation(summary = "Modificar un detalle", description = "Modifica un detalle existente en la base de datos")
    @ApiResponses(value = {
        @ApiResponse(responseCode = "200", description = "Detalle modificado exitosamente"),
        @ApiResponse(responseCode = "400", description = "Solicitud inválida"),
        @ApiResponse(responseCode = "404", description = "Detalle no encontrado")
    })
    public Detail modificar(@RequestBody Detail detail) {
        return dserv.modificar(detail);
    }

    
    @DeleteMapping("/eliminar")
    @Operation(summary = "Eliminar un detalle", description = "Elimina un detalle de la base de datos")
    @ApiResponses(value = {
        @ApiResponse(responseCode = "200", description = "Detalle eliminado exitosamente"),
        @ApiResponse(responseCode = "400", description = "Solicitud inválida"),
        @ApiResponse(responseCode = "404", description = "Detalle no encontrado")
    })
    public int eliminar(@RequestBody Detail detail) {
        return dserv.eliminar(detail);
    }
    
    
    @DeleteMapping("/eliminar/{id}")
    @Operation(summary = "Eliminar un detalle por ID", description = "Elimina un detalle de la base de datos utilizando su ID")
    @ApiResponses(value = {
        @ApiResponse(responseCode = "200", description = "Detalle eliminado exitosamente"),
        @ApiResponse(responseCode = "400", description = "Solicitud inválida"),
        @ApiResponse(responseCode = "404", description = "Detalle no encontrado")
    })
    public int eliminarPorId(@PathVariable Long id) {
        return dserv.eliminarPorId(id);
    }

    
    @GetMapping("/buscar/{id}")
    @Operation(summary = "Buscar un detalle por ID", description = "Busca un detalle en la base de datos utilizando su ID")
    @ApiResponses(value = {
        @ApiResponse(responseCode = "200", description = "Detalle encontrado exitosamente"),
        @ApiResponse(responseCode = "404", description = "Detalle no encontrado")
    })
    public Detail buscarPorId(@PathVariable Long id) {
        return dserv.buscarPorId(id);
    }


    @GetMapping("/todos")
    @Operation(summary = "Buscar todos los detalles", description = "Busca todos los detalles en la base de datos")
    @ApiResponses(value = {
        @ApiResponse(responseCode = "200", description = "Detalles encontrados exitosamente")
    })
    public List<Detail> buscarTodos() {
        return dserv.buscarTodos();
    }
}