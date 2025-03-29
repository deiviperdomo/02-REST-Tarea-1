package es.eviden.project.modelo.repository;

import org.springframework.data.jpa.repository.JpaRepository;

import es.eviden.project.entities.Tag;

public interface TagRepository extends JpaRepository<Tag, Long>{

}
