package es.eviden.project.entities;

import java.util.List;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@AllArgsConstructor
@NoArgsConstructor
public class Article {
	private Long id;
    private String title;
    private String abstractText;
    private String content;
    
    private List<Tag> tags;
    
}
