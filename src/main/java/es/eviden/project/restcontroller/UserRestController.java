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

import es.eviden.project.entities.User;
import es.eviden.project.modelo.service.UserService;

import io.swagger.v3.oas.annotations.Operation;
import io.swagger.v3.oas.annotations.tags.Tag;
import jakarta.validation.Valid;
import io.swagger.v3.oas.annotations.responses.ApiResponse;
import io.swagger.v3.oas.annotations.responses.ApiResponses;


@RestController
@RequestMapping("/user")
@Tag(name = "User", description = "Controlador para la gestión de usuarios")
public class UserRestController {

    @Autowired
    private UserService userv;


    @PostMapping("/alta")
    @Operation(summary = "Crear un nuevo usuario", description = "Crea un nuevo usuario en la base de datos")
    @ApiResponses(value = {
        @ApiResponse(responseCode = "200", description = "Usuario creado exitosamente"),
        @ApiResponse(responseCode = "400", description = "Solicitud inválida")
    })
    public User alta(@Valid @RequestBody User user) {
        return userv.alta(user);
    }


    @PutMapping("/modificar")
    @Operation(summary = "Modificar un usuario", description = "Modifica un usuario existente en la base de datos")
    @ApiResponses(value = {
        @ApiResponse(responseCode = "200", description = "Usuario modificado exitosamente"),
        @ApiResponse(responseCode = "400", description = "Solicitud inválida"),
        @ApiResponse(responseCode = "404", description = "Usuario no encontrado")
    })
    public User modificar(@Valid @RequestBody User user) {
        return userv.modificar(user);
    }


    @DeleteMapping("/eliminar")
    @Operation(summary = "Eliminar un usuario", description = "Elimina un usuario de la base de datos")
    @ApiResponses(value = {
        @ApiResponse(responseCode = "200", description = "Usuario eliminado exitosamente"),
        @ApiResponse(responseCode = "400", description = "Solicitud inválida"),
        @ApiResponse(responseCode = "404", description = "Usuario no encontrado")
    })
    public int eliminar(@Valid @RequestBody User user) {
        return userv.eliminar(user);
    }


    @DeleteMapping("/eliminar/{id}")
    @Operation(summary = "Eliminar un usuario por ID", description = "Elimina un usuario de la base de datos utilizando su ID")
    @ApiResponses(value = {
        @ApiResponse(responseCode = "200", description = "Usuario eliminado exitosamente"),
        @ApiResponse(responseCode = "400", description = "Solicitud inválida"),
        @ApiResponse(responseCode = "404", description = "Usuario no encontrado")
    })
    public int eliminarPorId(@PathVariable Long id) {
        return userv.eliminarPorId(id);
    }


    @GetMapping("/buscar/{id}")
    @Operation(summary = "Buscar un usuario por ID", description = "Busca un usuario en la base de datos utilizando su ID")
    @ApiResponses(value = {
        @ApiResponse(responseCode = "200", description = "Usuario encontrado exitosamente"),
        @ApiResponse(responseCode = "404", description = "Usuario no encontrado")
    })
    public User buscarPorId(@PathVariable Long id) {
        return userv.buscarPorId(id);
    }


    @GetMapping("/todos")
    @Operation(summary = "Buscar todos los usuarios", description = "Busca todos los usuarios en la base de datos")
    @ApiResponses(value = {
        @ApiResponse(responseCode = "200", description = "Usuarios encontrados exitosamente")
    })
    public List<User> buscarTodos() {
        return userv.buscarTodos();
    }
    
}
