package es.eviden.project.modelo.service;

import java.util.ArrayList;
import java.util.List;
import java.util.Optional;

import org.springframework.stereotype.Service;

import es.eviden.project.entities.Blog;


@Service
public class BlogServiceImpl implements BlogService {

	private List<Blog> blogs = new ArrayList<>();
	private long id = 1;
	
	@Override
	public Blog alta(Blog entidad) {
		entidad.setId(id++);
		blogs.add(entidad);
        return entidad;
	}

	@Override
	public Blog modificar(Blog entidad) {
		for (int i = 0; i < blogs.size(); i++) {
            if (blogs.get(i).getId().equals(entidad.getId())) {
            	blogs.set(i, entidad);
                return entidad;
            }
        }
        return null;
	}

	@Override
	public int eliminar(Blog entidad) {
		return eliminarPorId(entidad.getId());
	}

	@Override
	public int eliminarPorId(Long id) {
		return blogs.removeIf(blog -> blog.getId().equals(id)) ? 1 : 0;
	}

	@Override
	public Blog buscarPorId(Long id) {
		 Optional<Blog> blog = blogs.stream()
                 						.filter(a -> a.getId().equals(id))
                 						.findFirst();
		 return blog.orElse(null);
	}

	@Override
	public List<Blog> buscarTodos() {
		return new ArrayList<>(blogs);
	}

	
}
