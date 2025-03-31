package es.eviden.project.modelo.service;

import java.util.ArrayList;
import java.util.List;
import java.util.Optional;

import org.springframework.stereotype.Service;

import es.eviden.project.entities.Tag;

@Service
public class TagServiceImpl implements TagService {
	
	private List<Tag> tags = new ArrayList<>();
	private long id = 1;

	@Override
	public Tag alta(Tag entidad) {
		entidad.setId(id++);
		tags.add(entidad);
        return entidad;
	}

	@Override
	public Tag modificar(Tag entidad) {
		for (int i = 0; i < tags.size(); i++) {
            if (tags.get(i).getId().equals(entidad.getId())) {
            	tags.set(i, entidad);
                return entidad;
            }
        }
        return null;
	}

	@Override
	public int eliminar(Tag entidad) {
		return eliminarPorId(entidad.getId());
	}

	@Override
	public int eliminarPorId(Long id) {
		return tags.removeIf(tag -> tag.getId().equals(id)) ? 1 : 0;
	}

	@Override
	public Tag buscarPorId(Long id) {
		Optional<Tag> tag = tags.stream()
                .filter(a -> a.getId().equals(id))
                .findFirst();
		return tag.orElse(null);
	}

	@Override
	public List<Tag> buscarTodos() {
		return new ArrayList<>(tags);
	}


}
