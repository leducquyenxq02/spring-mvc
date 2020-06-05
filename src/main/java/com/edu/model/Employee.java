package com.edu.model;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.FetchType;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.Table;
import javax.validation.constraints.Max;
import javax.validation.constraints.Min;
import javax.validation.constraints.Pattern;
import javax.validation.constraints.Size;

import org.hibernate.validator.constraints.Email;
import org.hibernate.validator.constraints.NotBlank;

@Entity
@Table(name = "employees")
public class Employee {
	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private int id;
	
	@Column(name = "name")
	@NotBlank(message = "Name is not null")
	@Size(min = 5, max = 200, message = "About Me must be between 5 and 20 characters")
	private String name;
	
	@Column(name = "age")
	@Min(value = 18, message = "Age should not be less than 18")
	@Max(value = 150, message = "Age should not be greater than 150")
	private int age;
	
	
	@Column(name = "phone")
	@Pattern(regexp = "(\\+84|0)[0-9]{9}", message = "The phone formart is invalid!, should have +84 or 0 and 9 numbers left")
	private String phone;
	

	@Column(name = "email")
	@NotBlank(message = "Email is not null")
	@Email(message = "Email is invalid!", regexp = "^[a-z][a-z0-9_\\.]{5,32}@[a-z0-9]{2,}(\\.[a-z0-9]{2,4}){1,2}$")
	private String email;
	
	@Column(name = "image")
	private String image;
	@ManyToOne(fetch = FetchType.EAGER)
	@JoinColumn(name = "departmentId")
	private Department department;
	private transient int departmentIdPK;

	public Employee() {
		super();
	}

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

	public int getAge() {
		return age;
	}

	public void setAge(int age) {
		this.age = age;
	}

	public String getPhone() {
		return phone;
	}

	public void setPhone(String phone) {
		this.phone = phone;
	}

	public String getEmail() {
		return email;
	}

	public void setEmail(String email) {
		this.email = email;
	}

	public String getImage() {
		return image;
	}

	public void setImage(String image) {
		this.image = image;
	}

	public Department getDepartment() {
		return department;
	}

	public void setDepartment(Department department) {
		this.department = department;
	}

	public int getDepartmentIdPK() {
		return departmentIdPK;
	}

	public void setDepartmentIdPK(int departmentIdPK) {
		this.departmentIdPK = departmentIdPK;
	}

	
	

}
