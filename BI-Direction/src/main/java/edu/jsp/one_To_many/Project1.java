package edu.jsp.one_To_many;

import java.time.LocalDate;

import edu.jsp.one_to_one.OrderInfo1;
import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.ManyToOne;
import lombok.Getter;
import lombok.Setter;

@Entity
@Getter
@Setter
public class Project1 {
	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private int projectId;
	private String projectName;
	private LocalDate startDate;
	private LocalDate endDate;
	
	@ManyToOne
	private ProjectManager projectmanager;

}
