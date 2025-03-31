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

import es.eviden.project.entities.Code;
import es.eviden.project.modelo.service.CodeService;

import io.swagger.v3.oas.annotations.Operation;
import io.swagger.v3.oas.annotations.tags.Tag;
import io.swagger.v3.oas.annotations.responses.ApiResponse;
import io.swagger.v3.oas.annotations.responses.ApiResponses;


@RestController
@RequestMapping("/code")
@Tag(name = "Code", description = "Controlador para la gestión de códigos")
public class CodeRestController {
    
    @Autowired
    private CodeService cserv;

    
    @PostMapping("/alta")
    @Operation(summary = "Crear un nuevo código", description = "Crea un nuevo código en la base de datos")
    @ApiResponses(value = {
        @ApiResponse(responseCode = "200", description = "Código creado exitosamente"),
        @ApiResponse(responseCode = "400", description = "Solicitud inválida")
    })
    public Code alta(@RequestBody Code code) {
        return cserv.alta(code);
    }

    
    @PutMapping("/modificar")
    @Operation(summary = "Modificar un código", description = "Modifica un código existente en la base de datos")
    @ApiResponses(value = {
        @ApiResponse(responseCode = "200", description = "Código modificado exitosamente"),
        @ApiResponse(responseCode = "400", description = "Solicitud inválida"),
        @ApiResponse(responseCode = "404", description = "Código no encontrado")
    })
    public Code modificar(@RequestBody Code code) {
        return cserv.modificar(code);
    }

    
    @DeleteMapping("/eliminar")
    @Operation(summary = "Eliminar un código", description = "Elimina un código de la base de datos")
    @ApiResponses(value = {
        @ApiResponse(responseCode = "200", description = "Código eliminado exitosamente"),
        @ApiResponse(responseCode = "400", description = "Solicitud inválida"),
        @ApiResponse(responseCode = "404", description = "Código no encontrado")
    })
    public int eliminar(@RequestBody Code code) {
        return cserv.eliminar(code);
    }

    
    @DeleteMapping("/eliminar/{id}")
    @Operation(summary = "Eliminar un código por ID", description = "Elimina un código de la base de datos utilizando su ID")
    @ApiResponses(value = {
        @ApiResponse(responseCode = "200", description = "Código eliminado exitosamente"),
        @ApiResponse(responseCode = "400", description = "Solicitud inválida"),
        @ApiResponse(responseCode = "404", description = "Código no encontrado")
    })
    public int eliminarPorId(@PathVariable Long id) {
        return cserv.eliminarPorId(id);
    }
    

    @GetMapping("/buscar/{id}")
    @Operation(summary = "Buscar un código por ID", description = "Busca un código en la base de datos utilizando su ID")
    @ApiResponses(value = {
        @ApiResponse(responseCode = "200", description = "Código encontrado exitosamente"),
        @ApiResponse(responseCode = "404", description = "Código no encontrado")
    })
    public Code buscarPorId(@PathVariable Long id) {
        return cserv.buscarPorId(id);
    }
    

    @GetMapping("/todos")
    @Operation(summary = "Buscar todos los códigos", description = "Busca todos los códigos en la base de datos")
    @ApiResponses(value = {
        @ApiResponse(responseCode = "200", description = "Códigos encontrados exitosamente")
    })
    public List<Code> buscarTodos() {
        return cserv.buscarTodos();
    }
    
}
