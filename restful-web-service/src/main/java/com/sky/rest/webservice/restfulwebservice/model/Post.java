package com.sky.rest.webservice.restfulwebservice.model;

import javax.persistence.Entity;
import javax.persistence.FetchType;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;
import javax.persistence.ManyToOne;

import com.fasterxml.jackson.annotation.JsonIgnore;

/**
 * @author SUSHIL
 *
 */
@Entity
public class Post {
  @Id
  @GeneratedValue
  private Integer id;
  private String description;
  @ManyToOne(fetch=FetchType.LAZY)
  @JsonIgnore
  private User user;
  /**
   * @return the id
   */
  public Integer getId() {
    return id;
  }
  /**
   * @param id the id to set
   */
  public void setId(Integer id) {
    this.id = id;
  }
  /**
   * @return the description
   */
  public String getDescription() {
    return description;
  }
  /**
   * @param description the description to set
   */
  public void setDescription(String description) {
    this.description = description;
  }
  
}
