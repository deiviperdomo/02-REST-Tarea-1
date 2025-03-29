package es.eviden.project.modelo.repository;

import org.springframework.data.jpa.repository.JpaRepository;

import es.eviden.project.entities.Project;

public interface ProjectRepository extends JpaRepository<Project, Long>{

}
