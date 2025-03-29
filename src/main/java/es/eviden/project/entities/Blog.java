package es.eviden.project.entities;

import java.util.Date;
import java.util.List;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@AllArgsConstructor
@NoArgsConstructor
public class Blog {
	private Long id;
    private String title;
    private Date date;
    
    private User user;
    private List<Article> articles;
    
}
