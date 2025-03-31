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

@RestController
@RequestMapping("/code")
public class CodeRestController {
	
	@Autowired
	private CodeService cserv;
	
	@PostMapping("/alta")
    public Code alta(@RequestBody Code code) {
        return cserv.alta(code);
    }

    @PutMapping("/modificar")
    public Code modificar(@RequestBody Code code) {
        return cserv.modificar(code);
    }

    @DeleteMapping("/eliminar")
    public int eliminar(@RequestBody Code code) {
        return cserv.eliminar(code);
    }

    @DeleteMapping("/eliminar/{id}")
    public int eliminarPorId(@PathVariable Long id) {
        return cserv.eliminarPorId(id);
    }

    @GetMapping("/buscar/{id}")
    public Code buscarPorId(@PathVariable Long id) {
        return cserv.buscarPorId(id);
    }

    @GetMapping("/todos")
    public List<Code> buscarTodos() {
        return cserv.buscarTodos();
    }

}
