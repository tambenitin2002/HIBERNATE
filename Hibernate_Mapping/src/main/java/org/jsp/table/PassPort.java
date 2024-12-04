package org.jsp.table;

import java.time.LocalDate;

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
@ToString
public class PassPort {
	@Id
	@GeneratedValue(strategy = GenerationType.SEQUENCE, generator = "passport_id")
	@SequenceGenerator(name = "passport_id", initialValue = 11, allocationSize = 1, sequenceName = "passport_sequence")
	private int id;
	private LocalDate issueDate;
}
