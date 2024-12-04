package edu.jsp.primary_key;

import jakarta.persistence.Entity;

import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.SequenceGenerator;
import lombok.Getter;
import lombok.Setter;
import lombok.ToString;
@ToString
@Getter
@Setter
@Entity
public class Institute {
   @Id
   @GeneratedValue(strategy = GenerationType.SEQUENCE, generator = "institute_id")
   
   /**
    * initial value is used to specify starting of sequence 
    * allocation size is used to specify incremental vallue 
    * sequence is used to specify sequence table name
    */
   
   @SequenceGenerator(name="institute_id", initialValue = 101, allocationSize=1, sequenceName = "institute_sequence")
	private int id;
   
	private String name;
    private String area;
    private int pincode;
    
    private String technology;
    private double fee;
    
	public int getId() {
		return id;
	}
	public void setId(int id) {
		this.id = id;
	}
	public String getName() {
		return name;
	}
	public void setName(String name) {
		this.name = name;
	}
	public String getArea() {
		return area;
	}
	public void setArea(String area) {
		this.area = area;
	}
	public int getPincode() {
		return pincode;
	}
	public void setPincode(int pincode) {
		this.pincode = pincode;
	}
	
	
	public double getFee() {
		return fee;
	}
	
	public void setFee(double fee) {
		this.fee = fee;
	}
	
	public String getTechnology() {
		return technology;
	}
	
	public void setTechnology(String technology) {
		this.technology = technology;
	}
	 @Override
	 public String toString() {
	 	return "Institute [id=" + id + ", name=" + name + ", area=" + area + ", pincode=" + pincode+ ", Fee=" + fee + ", technology="
	 			+ technology + "]";
	 }
	
}
