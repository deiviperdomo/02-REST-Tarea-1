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

import es.eviden.project.entities.Article;
import es.eviden.project.modelo.service.ArticleServiceImpl;

@RestController
@RequestMapping("/article")
public class ArticleRestController {

    @Autowired
    private ArticleServiceImpl articleService;

    @PostMapping("/alta")
    public Article alta(@RequestBody Article article) {
        return articleService.alta(article);
    }

    @PutMapping("/modificar")
    public Article modificar(@RequestBody Article article) {
        return articleService.modificar(article);
    }

    @DeleteMapping("/eliminar")
    public int eliminar(@RequestBody Article article) {
        return articleService.eliminar(article);
    }

    @DeleteMapping("/eliminar/{id}")
    public int eliminarPorId(@PathVariable Long id) {
        return articleService.eliminarPorId(id);
    }

    @GetMapping("/buscar/{id}")
    public Article buscarPorId(@PathVariable Long id) {
        return articleService.buscarPorId(id);
    }

    @GetMapping("/todos")
    public List<Article> buscarTodos() {
        return articleService.buscarTodos();
    }
}
