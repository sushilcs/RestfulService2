package com.sky.rest.webservice.restfulwebservice.model;

import java.util.Date;

import javax.validation.constraints.Past;
import javax.validation.constraints.Size;

public class User {
	private Integer id;
	@Size(min=2,message="message should have atleast 2 character")
	private String name;
	@Past
	private Date birhtDate;
	public Integer getId() {
		return id;
	}
	@Override
	public String toString() {
		return "User [id=" + id + ", name=" + name + ", birhtDate=" + birhtDate + "]";
	}
	public User() {
		
	}
	public User(Integer id, String name, Date birhtDate) {
		this.id = id;
		this.name = name;
		this.birhtDate = birhtDate;
	}
	public User (String name,Date birthDate) {
		this.name=name;
		this.birhtDate=birthDate;
	}
	public void setId(Integer id) {
		this.id = id;
	}
	public String getName() {
		return name;
	}
	public void setName(String name) {
		this.name = name;
	}
	public Date getBirhtDate() {
		return birhtDate;
	}
	public void setBirhtDate(Date birhtDate) {
		this.birhtDate = birhtDate;
	}

}
