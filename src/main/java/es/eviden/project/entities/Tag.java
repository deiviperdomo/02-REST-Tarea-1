package es.eviden.project.entities;

import java.util.Date;

import jakarta.validation.constraints.NotNull;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@AllArgsConstructor
@NoArgsConstructor
public class Tag {
	@NotNull
	 private Long id;
	@NotNull
	 private String label;
	@NotNull
	 private Date date;
	    
}
