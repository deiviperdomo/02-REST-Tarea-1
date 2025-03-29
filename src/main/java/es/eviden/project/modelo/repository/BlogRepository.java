package es.eviden.project.modelo.repository;

import org.springframework.data.jpa.repository.JpaRepository;

import es.eviden.project.entities.Blog;

public interface BlogRepository extends JpaRepository<Blog, Long> {
	
}
