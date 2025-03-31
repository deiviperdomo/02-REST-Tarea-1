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

@RestController
@RequestMapping("/phone")
public class PhoneRestController {

	@Autowired 
	private PhoneService pserv;
	
	@PostMapping("/alta")
    public Phone alta(@RequestBody Phone phone) {
        return pserv.alta(phone);
    }

    @PutMapping("/modificar")
    public Phone modificar(@RequestBody Phone phone) {
        return pserv.modificar(phone);
    }

    @DeleteMapping("/eliminar")
    public int eliminar(@RequestBody Phone phone) {
        return pserv.eliminar(phone);
    }

    @DeleteMapping("/eliminar/{value}")
    public int eliminarPorId(@PathVariable String value) {
        return pserv.eliminarPorId(value);
    }

    @GetMapping("/buscar/{value}")
    public Phone buscarPorId(@PathVariable String value) {
        return pserv.buscarPorId(value);
    }

    @GetMapping("/todos")
    public List<Phone> buscarTodos() {
        return pserv.buscarTodos();
    }
    
}
