package com.astroreading.service;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.mongodb.core.MongoTemplate;
import org.springframework.data.mongodb.core.query.Criteria;
import org.springframework.data.mongodb.core.query.Query;
import org.springframework.stereotype.Service;

import com.astroreading.model.User;

@Service
public class UserService {

	@Autowired
	MongoTemplate mongoTemplate;

	public void register(User u) {
		try {
			mongoTemplate.insert(u);
		} catch (Exception e) {

		}
	}

	public User findUserByLogin(String email, String password) {
		User user = mongoTemplate.findOne(new Query().addCriteria(new Criteria("email").is(email).and("password").is(password)), User.class);
		if (user != null) {
			return user;
		}
		return null;
	}
}
