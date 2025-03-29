package es.eviden.project.modelo.repository;

import org.springframework.data.jpa.repository.JpaRepository;

import es.eviden.project.entities.Article;

public interface AtrticleRepository extends JpaRepository<Article, Long> {
	
}
