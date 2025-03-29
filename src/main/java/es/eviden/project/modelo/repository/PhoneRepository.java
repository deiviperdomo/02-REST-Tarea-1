package es.eviden.project.modelo.repository;

import org.springframework.data.jpa.repository.JpaRepository;

import es.eviden.project.entities.Phone;

public interface PhoneRepository extends JpaRepository<Phone, String>{

}
