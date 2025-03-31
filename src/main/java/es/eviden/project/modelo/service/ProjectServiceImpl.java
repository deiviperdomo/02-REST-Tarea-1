package es.eviden.project.modelo.service;

import java.util.ArrayList;
import java.util.List;
import java.util.Optional;

import org.springframework.stereotype.Service;

import es.eviden.project.entities.Project;


@Service
public class ProjectServiceImpl implements ProjectService {
	
	private List<Project> projects = new ArrayList<>();
	private long id = 1;

	@Override
	public Project alta(Project entidad) {
		entidad.setId(id++);
		projects.add(entidad);
        return entidad;
	}

	@Override
	public Project modificar(Project entidad) {
		for (int i = 0; i < projects.size(); i++) {
            if (projects.get(i).getId().equals(entidad.getId())) {
            	projects.set(i, entidad);
                return entidad;
            }
        }
        return null;
	}

	@Override
	public int eliminar(Project entidad) {
		return eliminarPorId(entidad.getId());
	}

	@Override
	public int eliminarPorId(Long id) {
		return projects.removeIf(project -> project.getId().equals(id)) ? 1 : 0;
	}

	@Override
	public Project buscarPorId(Long id) {
		Optional<Project> project = projects.stream()
                .filter(a -> a.getId().equals(id))
                .findFirst();
		return project.orElse(null);
	}

	@Override
	public List<Project> buscarTodos() {
		return new ArrayList<>(projects);
	}

}
