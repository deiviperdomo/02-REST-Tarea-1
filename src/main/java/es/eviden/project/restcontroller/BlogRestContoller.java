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

@RestController
@RequestMapping("/blog")
public class BlogRestContoller {
	
	@Autowired
	private BlogService bserv;
	
	@PostMapping("/alta")
    public Blog alta(@RequestBody Blog blog) {
        return bserv.alta(blog);
    }

    @PutMapping("/modificar")
    public Blog modificar(@RequestBody Blog blog) {
        return bserv.modificar(blog);
    }

    @DeleteMapping("/eliminar")
    public int eliminar(@RequestBody Blog blog) {
        return bserv.eliminar(blog);
    }

    @DeleteMapping("/eliminar/{id}")
    public int eliminarPorId(@PathVariable Long id) {
        return bserv.eliminarPorId(id);
    }

    @GetMapping("/buscar/{id}")
    public Blog buscarPorId(@PathVariable Long id) {
        return bserv.buscarPorId(id);
    }

    @GetMapping("/todos")
    public List<Blog> buscarTodos() {
        return bserv.buscarTodos();
    }

}
