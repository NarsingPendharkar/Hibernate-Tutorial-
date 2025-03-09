package tutorial.HibernateExample_Utilclass;

import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.JoinColumn;
import jakarta.persistence.ManyToOne;
import jakarta.persistence.Table;
import lombok.Data;

@Entity
@Table(name="answers")
@Data
public class Answers {
	
	public Answers(String string, String string2) {
		this.answername=string;
		this.postedBy=string2;
	}
	@Id  
    @GeneratedValue(strategy=GenerationType.AUTO)  
private int id;    
private String answername;    
private String postedBy;    

}
