package es.eviden.project.modelo.service;

import java.util.ArrayList;
import java.util.List;
import java.util.Optional;

import org.springframework.stereotype.Service;

import es.eviden.project.entities.User;

@Service
public class UserServiceImpl implements UserService {
	
	private List<User> users = new ArrayList<>();
	private long id = 1;

	@Override
	public User alta(User entidad) {
		entidad.setId(id++);
		users.add(entidad);
        return entidad;
	}

	@Override
	public User modificar(User entidad) {
		for (int i = 0; i < users.size(); i++) {
            if (users.get(i).getId().equals(entidad.getId())) {
            	users.set(i, entidad);
                return entidad;
            }
        }
        return null;
	}

	@Override
	public int eliminar(User entidad) {
		return eliminarPorId(entidad.getId());
	}

	@Override
	public int eliminarPorId(Long id) {
		return users.removeIf(user -> user.getId().equals(id)) ? 1 : 0;
	}

	@Override
	public User buscarPorId(Long id) {
		Optional<User> user = users.stream()
                .filter(a -> a.getId().equals(id))
                .findFirst();
		return user.orElse(null);
	}

	@Override
	public List<User> buscarTodos() {
		return new ArrayList<>(users);
	}
	
	

}
