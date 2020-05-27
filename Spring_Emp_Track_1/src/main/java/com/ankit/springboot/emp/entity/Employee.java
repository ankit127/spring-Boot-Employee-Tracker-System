package com.ankit.springboot.emp.entity;


import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.Table;
import javax.validation.constraints.Email;
import javax.validation.constraints.NotNull;
import javax.validation.constraints.Size;

import lombok.Getter;
import lombok.Setter;

@Entity
@Table(name="employee")
@Getter
@Setter
public class Employee {

	@Id
	@GeneratedValue(strategy=GenerationType.IDENTITY)
	@Column(name="id")
	public int Id;
	
	@Column(name="first_name")
	@NotNull(message="is required")
	@Size(min=1,message="is required")
	
	public String firstName;

	@Column(name="last_name")
	@NotNull(message="is required")
	@Size(min=1,message="is required")
	public String lastName;
	
	@Column(name="email")
	@NotNull(message="is required")
	@Size(min=1,message="is required")
    public String email;
	
	public Employee()
	{}

	
	public Employee(int id, String firstName, String lastName, String email) {
		this.Id = id;
		this.firstName = firstName;
		this.lastName = lastName;
		this.email = email;
	}

	
	
	public Employee(String firstName, String lastName, String email) {
		this.firstName = firstName;
		this.lastName = lastName;
		this.email = email;
	}



	
}
