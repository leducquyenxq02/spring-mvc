package com.edu.model;

import java.util.ArrayList;
import java.util.List;

import javax.persistence.CascadeType;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.OneToMany;
import javax.persistence.Table;
import javax.validation.constraints.Size;

import org.hibernate.validator.constraints.NotBlank;

@Entity
@Table(name = "department")
public class Department {
	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private int departmentId;
	
	@Column(name = "departmentName")
	@NotBlank(message = "Name is not null")
	@Size(min = 5, max = 200, message = "About Me must be between 5 and 20 characters")
	private String departmentName;
	
	@Column(name = "adress")
	@NotBlank(message = "Adress is not null")
	@Size(min = 5, max = 200, message = "Adress must be between 5 and 20 characters")
	private String adress;
	@OneToMany(mappedBy = "department",cascade = CascadeType.ALL)
	private List<Employee> listEmployee = new ArrayList<Employee>();
	
	public Department() {
	}

	public int getDepartmentId() {
		return departmentId;
	}

	public void setDepartmentId(int departmentId) {
		this.departmentId = departmentId;
	}

	public String getDepartmentName() {
		return departmentName;
	}

	public void setDepartmentName(String departmentName) {
		this.departmentName = departmentName;
	}

	public String getAdress() {
		return adress;
	}

	public void setAdress(String adress) {
		this.adress = adress;
	}

	public List<Employee> getListEmployee() {
		return listEmployee;
	}

	public void setListEmployee(List<Employee> listEmployee) {
		this.listEmployee = listEmployee;
	}
	
	
	
}
