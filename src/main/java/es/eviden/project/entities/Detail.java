package es.eviden.project.entities;

import java.util.Date;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@AllArgsConstructor
@NoArgsConstructor
public class Detail {
	private Long id;
	private Date date;
    private String content;
    private String type;
    private Double budget;
    
}
