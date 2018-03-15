package com.xxx.springcloud.web;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RestController;

import com.xxx.springcloud.dao.UserRepository;
import com.xxx.springcloud.entity.User;

@RestController
public class UserController {

	@Autowired
	private UserRepository userRepository;

	@GetMapping("/{id}")
	public User queryById(@PathVariable Long id) {
		User user = userRepository.findOne(id);
		return user;
	}
}
