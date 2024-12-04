package edu.jsp.many_to_many;



import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.SequenceGenerator;
import lombok.Getter;
import lombok.Setter;
import lombok.ToString;

@Entity

@Getter
@Setter


public class Subject {
	@Id
	@GeneratedValue(strategy = GenerationType.SEQUENCE , generator = "sub_id")
	@SequenceGenerator(name="emp_id",initialValue = 10,allocationSize = 10, sequenceName = "subSequence")
	private int id;
	
	private String name;
}
