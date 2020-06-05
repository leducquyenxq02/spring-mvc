package com.edu.model;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.Table;

import org.hibernate.validator.constraints.NotBlank;

@Entity
@Table(name = "user_table")
public class User {
	@Id
	@Column(name = "username")
	@NotBlank(message = "User name is not null")
	private String userName;
	@Column(name = "password")
	@NotBlank(message = "Password is not null")
	private String pass;

	public User() {
	}

	public User(String userName, String pass) {
		this.userName = userName;
		this.pass = pass;
	}

	public String getUserName() {
		return userName;
	}

	public void setUserName(String userName) {
		this.userName = userName;
	}

	public String getPass() {
		return pass;
	}

	public void setPass(String pass) {
		this.pass = pass;
	}

	@Override
	public String toString() {
		return "User [userName=" + userName + ", pass=" + pass + "]";
	}

}
