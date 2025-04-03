package es.eviden.project.entities;

import jakarta.validation.constraints.NotNull;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@AllArgsConstructor
@NoArgsConstructor
public class Code {
	@NotNull
	private Long id;
	@NotNull
    private String packageName;
	@NotNull
    private String file;
    
    
}
