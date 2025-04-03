package es.eviden.project.entities;

import jakarta.validation.constraints.NotNull;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@AllArgsConstructor
@NoArgsConstructor
public class Phone {
	
	@NotNull
	private String value;
	@NotNull
    private String type;

}
