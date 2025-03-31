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

@RestController
@RequestMapping("/user")
public class UserRestController {

	@Autowired
	private UserService userv;
	

	@PostMapping("/alta")
    public User alta(@RequestBody User user) {
        return userv.alta(user);
    }

    @PutMapping("/modificar")
    public User modificar(@RequestBody User user) {
        return userv.modificar(user);
    }

    @DeleteMapping("/eliminar")
    public int eliminar(@RequestBody User user) {
        return userv.eliminar(user);
    }

    @DeleteMapping("/eliminar/{id}")
    public int eliminarPorId(@PathVariable Long id) {
        return userv.eliminarPorId(id);
    }

    @GetMapping("/buscar/{id}")
    public User buscarPorId(@PathVariable Long id) {
        return userv.buscarPorId(id);
    }

    @GetMapping("/todos")
    public List<User> buscarTodos() {
        return userv.buscarTodos();
    }
	
}
