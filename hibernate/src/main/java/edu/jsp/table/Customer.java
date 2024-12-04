package edu.jsp.table;

import java.time.LocalDate;

import org.hibernate.annotations.CreationTimestamp;

import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.Id;
import jakarta.persistence.Table;
import lombok.Getter;
import lombok.Setter;
import lombok.ToString;
@Getter
@Setter
@ToString
@Entity

@Table(name="customer_id")
public class Customer {
	 @Id
	 @Column(name="customer_id")
	private int id;
	 
	 @Column(nullable=false)
	private String firstName;
	 @Column(nullable=false)
	private String lastName;
	@Column(unique=false, length=10, nullable=false)
	private long contact;
	 @Column(unique=true,nullable=false)
	private String email;
	 @Column(nullable=false)
	private String password;
	 @Column(name="dateOfBirth")
	private LocalDate dob;
	 @CreationTimestamp
	private LocalDate registrationDate;
	
	 @Override
		public String toString() {
			return "Customer [id=" + id + ", firstName=" + firstName + ", lastName=" + lastName + ", contact=" + contact
					+ ", email=" + email + ", password=" + password + ", dob=" + dob + ", registrationDate="
					+ registrationDate + "]";
		}

}
