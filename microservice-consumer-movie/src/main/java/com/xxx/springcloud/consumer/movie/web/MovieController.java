package com.xxx.springcloud.consumer.movie.web;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.client.RestTemplate;

import com.xxx.springcloud.consumer.movie.model.User;

@RestController
public class MovieController {

	@Autowired
	private RestTemplate restTemplate;
	
	@Value("${user.user-service-url}")
	private String userServiceUrl;

	@GetMapping(value = "/user/{id}")
	public User queryById(@PathVariable Long id) {
		return restTemplate.getForObject(userServiceUrl + id, User.class);
	}
}
