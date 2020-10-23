package com.sky.rest.webservice.restfulwebservice.Dao;

import org.springframework.data.jpa.repository.JpaRepository;

import com.sky.rest.webservice.restfulwebservice.model.User;

/**
 * @author SUSHIL (q1010954)
 *
 */
public interface UserRepository extends JpaRepository<User, Integer> {

}
