package es.eviden.project.modelo.service;

import java.util.ArrayList;
import java.util.List;
import java.util.Optional;

import org.springframework.stereotype.Service;

import es.eviden.project.entities.Code;



@Service
public class CodeServiceImpl implements CodeService {
	
	private List<Code> codes = new ArrayList<>();
	private long id = 1;
	
	@Override
	public Code alta(Code entidad) {
		entidad.setId(id++);
		codes.add(entidad);
        return entidad;
	}

	@Override
	public Code modificar(Code entidad) {
		for (int i = 0; i < codes.size(); i++) {
            if (codes.get(i).getId().equals(entidad.getId())) {
            	codes.set(i, entidad);
                return entidad;
            }
        }
        return null;
	}

	@Override
	public int eliminar(Code entidad) {
		return eliminarPorId(entidad.getId());
	}

	@Override
	public int eliminarPorId(Long id) {
		return codes.removeIf(code -> code.getId().equals(id)) ? 1 : 0;
	}

	@Override
	public Code buscarPorId(Long id) {
		Optional<Code> code = codes.stream()
                .filter(a -> a.getId().equals(id))
                .findFirst();
		return code.orElse(null);
	}

	@Override
	public List<Code> buscarTodos() {
		return new ArrayList<>(codes);
	}

}
