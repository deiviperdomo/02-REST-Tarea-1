package es.eviden.project.modelo.service;

import java.util.ArrayList;
import java.util.List;
import java.util.Optional;

import org.springframework.stereotype.Service;

import es.eviden.project.entities.Article;

@Service
public class ArticleServiceImpl implements ArticleService {
	
    private List<Article> articles = new ArrayList<>();
    private long id = 1;

    @Override
    public Article alta(Article entidad) {
        entidad.setId(id++);
        articles.add(entidad);
        return entidad;
    }

    @Override
    public Article modificar(Article entidad) {
        for (int i = 0; i < articles.size(); i++) {
            if (articles.get(i).getId().equals(entidad.getId())) {
                articles.set(i, entidad);
                return entidad;
            }
        }
        return null;
    }

    @Override
    public int eliminar(Article entidad) {
    	return eliminarPorId(entidad.getId());
    }

    @Override
    public int eliminarPorId(Long id) {
        return articles.removeIf(article -> article.getId().equals(id)) ? 1 : 0;
    }

    @Override
    public Article buscarPorId(Long id) {
        Optional<Article> article = articles.stream()
                                            .filter(a -> a.getId().equals(id))
                                            .findFirst();
        return article.orElse(null);
    }

    @Override
    public List<Article> buscarTodos() {
        return new ArrayList<>(articles);
    }
}
