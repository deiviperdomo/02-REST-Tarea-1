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

@RestController
@RequestMapping("/detail")
public class DetailRestController {
	
	@Autowired
	private DetailService dserv;
	
	@PostMapping("/alta")
    public Detail alta(@RequestBody Detail detail) {
        return dserv.alta(detail);
    }

    @PutMapping("/modificar")
    public Detail modificar(@RequestBody Detail detail) {
        return dserv.modificar(detail);
    }

    @DeleteMapping("/eliminar")
    public int eliminar(@RequestBody Detail detail) {
        return dserv.eliminar(detail);
    }

    @DeleteMapping("/eliminar/{id}")
    public int eliminarPorId(@PathVariable Long id) {
        return dserv.eliminarPorId(id);
    }

    @GetMapping("/buscar/{id}")
    public Detail buscarPorId(@PathVariable Long id) {
        return dserv.buscarPorId(id);
    }

    @GetMapping("/todos")
    public List<Detail> buscarTodos() {
        return dserv.buscarTodos();
    }

}
