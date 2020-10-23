package com.sky.rest.webservice.restfulwebservice.model;

import java.util.Date;
import java.util.List;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;
import javax.persistence.OneToMany;
import javax.validation.constraints.Past;
import javax.validation.constraints.Size;

import io.swagger.annotations.ApiModelProperty;
@Entity
public class User {
    @Id
    @GeneratedValue
	private Integer id;
	@Size(min=2,message="name should have atleast 2 character")
	@ApiModelProperty(notes="name should have atleast 2 character")
	private String name;
	@Past
	@ApiModelProperty(notes="brithdate shoudl not be in future")
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
	@OneToMany(mappedBy="user")
	private List<Post> post;
	/**
   * @return the post
   */
  public List<Post> getPost() {
    return post;
  }
  /**
   * @param post the post to set
   */
  public void setPost(List<Post> post) {
    this.post = post;
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
