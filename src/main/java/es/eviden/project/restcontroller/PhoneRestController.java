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

import es.eviden.project.entities.Phone;
import es.eviden.project.modelo.service.PhoneService;

import io.swagger.v3.oas.annotations.Operation;
import io.swagger.v3.oas.annotations.tags.Tag;
import jakarta.validation.Valid;
import io.swagger.v3.oas.annotations.responses.ApiResponse;
import io.swagger.v3.oas.annotations.responses.ApiResponses;


@RestController
@RequestMapping("/phone")
@Tag(name = "Phone", description = "Controlador para la gestión de teléfonos")
public class PhoneRestController {

    @Autowired 
    private PhoneService pserv;


    @PostMapping("/alta")
    @Operation(summary = "Crear un nuevo teléfono", description = "Crea un nuevo teléfono en la base de datos")
    @ApiResponses(value = {
        @ApiResponse(responseCode = "200", description = "Teléfono creado exitosamente"),
        @ApiResponse(responseCode = "400", description = "Solicitud inválida")
    })
    public Phone alta(@Valid @RequestBody Phone phone) {
        return pserv.alta(phone);
    }


    @PutMapping("/modificar")
    @Operation(summary = "Modificar un teléfono", description = "Modifica un teléfono existente en la base de datos")
    @ApiResponses(value = {
        @ApiResponse(responseCode = "200", description = "Teléfono modificado exitosamente"),
        @ApiResponse(responseCode = "400", description = "Solicitud inválida"),
        @ApiResponse(responseCode = "404", description = "Teléfono no encontrado")
    })
    public Phone modificar(@Valid @RequestBody Phone phone) {
        return pserv.modificar(phone);
    }


    @DeleteMapping("/eliminar")
    @Operation(summary = "Eliminar un teléfono", description = "Elimina un teléfono de la base de datos")
    @ApiResponses(value = {
        @ApiResponse(responseCode = "200", description = "Teléfono eliminado exitosamente"),
        @ApiResponse(responseCode = "400", description = "Solicitud inválida"),
        @ApiResponse(responseCode = "404", description = "Teléfono no encontrado")
    })
    public int eliminar(@Valid @RequestBody Phone phone) {
        return pserv.eliminar(phone);
    }


    @DeleteMapping("/eliminar/{value}")
    @Operation(summary = "Eliminar un teléfono por valor", description = "Elimina un teléfono de la base de datos utilizando su valor")
    @ApiResponses(value = {
        @ApiResponse(responseCode = "200", description = "Teléfono eliminado exitosamente"),
        @ApiResponse(responseCode = "400", description = "Solicitud inválida"),
        @ApiResponse(responseCode = "404", description = "Teléfono no encontrado")
    })
    public int eliminarPorId(@PathVariable String value) {
        return pserv.eliminarPorId(value);
    }


    @GetMapping("/buscar/{value}")
    @Operation(summary = "Buscar un teléfono por valor", description = "Busca un teléfono en la base de datos utilizando su valor")
    @ApiResponses(value = {
        @ApiResponse(responseCode = "200", description = "Teléfono encontrado exitosamente"),
        @ApiResponse(responseCode = "404", description = "Teléfono no encontrado")
    })
    public Phone buscarPorId(@PathVariable String value) {
        return pserv.buscarPorId(value);
    }


    @GetMapping("/todos")
    @Operation(summary = "Buscar todos los teléfonos", description = "Busca todos los teléfonos en la base de datos")
    @ApiResponses(value = {
        @ApiResponse(responseCode = "200", description = "Teléfonos encontrados exitosamente")
    })
    public List<Phone> buscarTodos() {
        return pserv.buscarTodos();
    }
    
}

