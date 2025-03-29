package es.eviden.project.entities;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@AllArgsConstructor
@NoArgsConstructor
public class Code {
	private Long id;
    private String packageName;
    private String file;
    
    
}
