package edu.jsp.one_to_many;

import java.util.List;

import jakarta.persistence.CascadeType;
import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.FetchType;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.OneToMany;
import jakarta.persistence.SequenceGenerator;
import lombok.Getter;
import lombok.Setter;
import lombok.ToString;

@Entity
@Getter
@Setter

public class Author {
	@Id
	@GeneratedValue(strategy = GenerationType.SEQUENCE, generator = "Author_id")
	@SequenceGenerator(name="Author_id", initialValue = 101, allocationSize = 1, sequenceName = "auther_seq")
	private int id;
	private String name;
	@Column(unique = true)
	private String email;
	@Column(unique = true)
	private long mobile;
	
	@OneToMany (cascade=CascadeType.REMOVE)
	private List<Books> books;
	
	
}
