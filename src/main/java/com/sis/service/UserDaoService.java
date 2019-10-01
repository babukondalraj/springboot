package com.sis.service;

import java.util.ArrayList;
import java.util.Date;
import java.util.List;

import org.springframework.stereotype.Component;

import com.sis.model.User;

@Component
public class UserDaoService {
	private final static List<User> users = new ArrayList<>();
	private static int  userCount = 3;
	static {
		users.add(new User(1,"Adam", new Date()));
		users.add(new User(2,"Mike", new Date()));
		users.add(new User(3,"Tom", new Date()));
	}
	
	public List<User> getUsers() {
		return users;
	}
	
	public User saveUser(User user) {
		if(user.getId() == null) {
			user.setId(++userCount);
		}
		users.add(user);
		return user;
	}
	
	public User getUser(int id) {
		for(User user: users) {
			if(user.getId() == id) {
				return user;
			}
		}
		return null;
	}
	
	public User removeUser(int id) {
		User user = getUser(id);
		
		if(users.contains(user)) {
			users.remove(user);
			return user;
		}
		return null;
	}
}
