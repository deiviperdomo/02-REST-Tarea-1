package es.eviden.project.modelo.service;

import java.util.ArrayList;
import java.util.List;
import java.util.Optional;

import org.springframework.stereotype.Service;

import es.eviden.project.entities.Phone;

@Service
public class PhoneServiceImpl implements PhoneService {
	
	private List<Phone> phones = new ArrayList<>();

	@Override
	public Phone alta(Phone entidad) {
		phones.add(entidad);
        return entidad;
	}

	@Override
	public Phone modificar(Phone entidad) {
		for (int i = 0; i < phones.size(); i++) {
            if (phones.get(i).getValue().equals(entidad.getValue())) {
            	phones.set(i, entidad);
                return entidad;
            }
        }
        return null;
	}

	@Override
	public int eliminar(Phone entidad) {
		return eliminarPorId(entidad.getValue());
	}

	@Override
	public int eliminarPorId(String value) {
		return phones.removeIf(phone -> phone.getValue().equals(value)) ? 1 : 0;
	}

	@Override
	public Phone buscarPorId(String value) {
		Optional<Phone> phone = phones.stream()
                .filter(a -> a.getValue().equals(value))
                .findFirst();
		return phone.orElse(null);
	}

	@Override
	public List<Phone> buscarTodos() {
		return new ArrayList<>(phones);
	}


}
