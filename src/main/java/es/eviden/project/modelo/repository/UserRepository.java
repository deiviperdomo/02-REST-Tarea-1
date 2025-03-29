package es.eviden.project.modelo.repository;

import org.springframework.data.jpa.repository.JpaRepository;

import es.eviden.project.entities.User;

public interface UserRepository extends JpaRepository<User, Long>{

}
