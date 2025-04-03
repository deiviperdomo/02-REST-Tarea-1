package es.eviden.project.entities;

import java.util.Date;

import jakarta.validation.constraints.NotNull;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@AllArgsConstructor
@NoArgsConstructor
public class Detail {
	@NotNull
	private Long id;
	@NotNull
	private Date date;
	@NotNull
    private String content;
	@NotNull
    private String type;
	@NotNull
    private Double budget;
    
}
