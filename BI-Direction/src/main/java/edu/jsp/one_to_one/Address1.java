package edu.jsp.one_to_one;

import java.time.LocalDate;

import jakarta.persistence.Entity;
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
@ToString
public class Address1 {
 @Id
 @GeneratedValue(strategy = GenerationType.IDENTITY)
	private int  addressId;
	private String area;
	private String city;
	private String state;
	private int pincode;
	@OneToOne
	private OrderInfo1 orderInfo1;
}
