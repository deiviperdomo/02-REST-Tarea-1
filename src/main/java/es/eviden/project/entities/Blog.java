package es.eviden.project.entities;

import java.util.Date;
import java.util.List;

import jakarta.validation.constraints.NotNull;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@AllArgsConstructor
@NoArgsConstructor
public class Blog {
	@NotNull
	private Long id;
	@NotNull
    private String title;
	@NotNull
    private Date date;
    
	@NotNull
    private User user;
	@NotNull
    private List<Article> articles;
    
}
