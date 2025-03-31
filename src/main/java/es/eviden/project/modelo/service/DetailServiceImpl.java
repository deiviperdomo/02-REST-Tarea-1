package es.eviden.project.modelo.service;

import java.util.ArrayList;
import java.util.List;
import java.util.Optional;

import org.springframework.stereotype.Service;

import es.eviden.project.entities.Detail;

@Service
public class DetailServiceImpl implements DetailService {
	
	private List<Detail> details = new ArrayList<>();
	private long id;

	@Override
	public Detail alta(Detail entidad) {
		entidad.setId(id++);
		details.add(entidad);
        return entidad;
	}

	@Override
	public Detail modificar(Detail entidad) {
		for (int i = 0; i < details.size(); i++) {
            if (details.get(i).getId().equals(entidad.getId())) {
            	details.set(i, entidad);
                return entidad;
            }
        }
        return null;
	}

	@Override
	public int eliminar(Detail entidad) {
		return eliminarPorId(entidad.getId());
	}

	@Override
	public int eliminarPorId(Long id) {
		return details.removeIf(detail -> detail.getId().equals(id)) ? 1 : 0;
	}

	@Override
	public Detail buscarPorId(Long id) {
		Optional<Detail> detail = details.stream()
                .filter(a -> a.getId().equals(id))
                .findFirst();
		return detail.orElse(null);
	}

	@Override
	public List<Detail> buscarTodos() {
		return new ArrayList<>(details);
	}

	
}
