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

@RestController
@RequestMapping("/project")
public class ProjectRestController {

	@Autowired
	private ProjectService pserv;
	
	@PostMapping("/alta")
    public Project alta(@RequestBody Project project) {
        return pserv.alta(project);
    }

    @PutMapping("/modificar")
    public Project modificar(@RequestBody Project project) {
        return pserv.modificar(project);
    }

    @DeleteMapping("/eliminar")
    public int eliminar(@RequestBody Project project) {
        return pserv.eliminar(project);
    }

    @DeleteMapping("/eliminar/{id}")
    public int eliminarPorId(@PathVariable Long id) {
        return pserv.eliminarPorId(id);
    }

    @GetMapping("/buscar/{id}")
    public Project buscarPorId(@PathVariable Long id) {
        return pserv.buscarPorId(id);
    }

    @GetMapping("/todos")
    public List<Project> buscarTodos() {
        return pserv.buscarTodos();
    }
    
}
