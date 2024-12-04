package edu.jsp.primary_key;



import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.Table;
import lombok.Getter;
import lombok.Setter;
import lombok.ToString;
@Setter
@Getter
@ToString
@Entity

public class ClassRoom {

	@Id
	@GeneratedValue(strategy = GenerationType.SEQUENCE)
	private int id;
	

	private int capacity;
	private String subject;
	private int flower;
	
	
}
