package es.eviden.project.entities;


import java.util.List;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@AllArgsConstructor
@NoArgsConstructor
public class Project {

	private Long id;
    private String description;
    private String language;
    private boolean open;
	
    
    private List<Code> code;
    private Detail deiail;
    private List<Tag> tags;
    private List<User> users;
}
