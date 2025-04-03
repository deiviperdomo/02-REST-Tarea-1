package es.eviden.project.entities;

import java.util.List;

import jakarta.validation.constraints.NotNull;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@AllArgsConstructor
@NoArgsConstructor
public class Article {
	@NotNull
	private Long id;
	@NotNull
    private String title;
	@NotNull
    private String abstractText;
	@NotNull
    private String content;
    
	@NotNull
    private List<Tag> tags;
    
}
