package edu.jsp.one_to_one;

import jakarta.persistence.CascadeType;
import jakarta.persistence.Entity;
import jakarta.persistence.FetchType;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.OneToOne;
import lombok.Getter;
import lombok.Setter;
import lombok.ToString;

@Entity
@Getter
@Setter

public class Person {
	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private int id;
	private String name;
	//@OneToOne   //it is Eager
	//to save passport along with person object
	//@OneToOne(cascade=CascadeType.PERSIST)
	
	//to  remove records with
	@OneToOne(cascade=CascadeType.REMOVE)
	private PassPort passport;

}
