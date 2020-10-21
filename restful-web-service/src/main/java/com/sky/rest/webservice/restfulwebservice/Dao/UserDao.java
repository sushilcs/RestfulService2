package com.sky.rest.webservice.restfulwebservice.Dao;

import java.util.ArrayList;
import java.util.Date;
import java.util.List;

import org.springframework.stereotype.Component;

import com.sky.rest.webservice.restfulwebservice.model.User;

@Component
public class UserDao {

	private static List<User> users = new ArrayList<>();
	private static int userCount = 3;
	static {
		users.add(new User(1, "adam", new Date()));
		users.add(new User(2, "eve", new Date()));
		users.add(new User(3, "jack", new Date()));
		users.add(new User(4, "mack", new Date()));
	}

	public List<User> getAllUsers() {
		return users;
	}

	public User save(User user) {
		if (user.getId() == null) {
			user.setId(++userCount);
		}
		users.add(user);
		return user;
	}

	public User getOne(int id) {
		for (User u : users) {
			if (u.getId() == id) {
				return users.get(id);
			}
		}
		return null;
	}

	public User deleteUserById(int id) {
		User user = getOne(id);
		if (user != null) {
			--userCount;
			users.remove(user);
			return user;
		}
        return null;
	}

}
