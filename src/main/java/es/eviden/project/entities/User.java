package es.eviden.project.entities;

import jakarta.validation.constraints.NotNull;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@AllArgsConstructor
@NoArgsConstructor
public class User {
	@NotNull
	private Long id;
	@NotNull
    private String nick;
	@NotNull
    private String name;
    
	@NotNull
    private Phone phone;
    
}
