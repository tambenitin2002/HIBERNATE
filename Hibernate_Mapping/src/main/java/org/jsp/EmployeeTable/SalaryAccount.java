package org.jsp.EmployeeTable;

import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.SequenceGenerator;
import lombok.Getter;
import lombok.Setter;
import lombok.ToString;
@Entity
@ToString
@Getter
@Setter
public class SalaryAccount {
   @Id
   @GeneratedValue(strategy = GenerationType.SEQUENCE , generator="salaryaccount_id")
   @SequenceGenerator(name="salaryaccount_id", initialValue = 11, allocationSize = 1, sequenceName = "salaryaccount_sequence" )
	private int sid;
	private String bankName;
	private double balance;
}
