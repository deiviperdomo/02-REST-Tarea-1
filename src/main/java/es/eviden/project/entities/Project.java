package es.eviden.project.entities;


import java.util.List;

import jakarta.validation.constraints.NotNull;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@AllArgsConstructor
@NoArgsConstructor
public class Project {

	@NotNull
	private Long id;
	@NotNull
    private String description;
	@NotNull
    private String language;
	@NotNull
    private boolean open;
	
	@NotNull
    private List<Code> code;
	@NotNull
    private Detail deiail;
	@NotNull
    private List<Tag> tags;
	@NotNull
    private List<User> users;
}
