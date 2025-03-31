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

@RestController
@RequestMapping("/tag")
public class TagRestController {
	
	@Autowired
	private TagService tserv;
	
	@PostMapping("/alta")
    public Tag alta(@RequestBody Tag tag) {
        return tserv.alta(tag);
    }

    @PutMapping("/modificar")
    public Tag modificar(@RequestBody Tag tag) {
        return tserv.modificar(tag);
    }

    @DeleteMapping("/eliminar")
    public int eliminar(@RequestBody Tag tag) {
        return tserv.eliminar(tag);
    }

    @DeleteMapping("/eliminar/{id}")
    public int eliminarPorId(@PathVariable Long id) {
        return tserv.eliminarPorId(id);
    }

    @GetMapping("/buscar/{id}")
    public Tag buscarPorId(@PathVariable Long id) {
        return tserv.buscarPorId(id);
    }

    @GetMapping("/todos")
    public List<Tag> buscarTodos() {
        return tserv.buscarTodos();
    }

}
