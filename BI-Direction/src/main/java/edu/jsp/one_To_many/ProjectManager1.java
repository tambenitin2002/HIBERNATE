package edu.jsp.one_To_many;

import java.util.List;

import edu.jsp.one_to_one.OrderInfo1;
import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.OneToMany;
import lombok.Getter;
import lombok.Setter;

@Entity
@Getter
@Setter
public class ProjectManager1 {
	
	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private int id;
	private String FullName;
	
	
	@OneToMany
	private List<Project> projects;

}
