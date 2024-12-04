package edu.jsp.primary_key;

import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.SequenceGenerator;

@Entity

public class Address {
	@Id
	@GeneratedValue(strategy = GenerationType.AUTO, generator = "address_id")
	@SequenceGenerator(name="address_id", initialValue = 101, allocationSize = 1, sequenceName = "address_sequense")
	
	private int id;
	private String Area;
	private String city;
	private String State;
	private int  pincode;
	public int getId() {
		return id;
	}
	public void setId(int id) {
		this.id = id;
	}
	public String getArea() {
		return Area;
	}
	public void setArea(String area) {
		Area = area;
	}
	public String getCity() {
		return city;
	}
	public void setCity(String city) {
		this.city = city;
	}
	public String getState() {
		return State;
	}
	public void setState(String state) {
		State = state;
	}
	public int getPincode() {
		return pincode;
	}
	public void setPincode(int pincode) {
		this.pincode = pincode;
	}
	@Override
	public String toString() {
		return "Address [id=" + id + ", Area=" + Area + ", city=" + city + ", State=" + State + ", pincode=" + pincode
				+ "]";
	}
	
 
}
