package com.xxx.springcloud.consumer.movie.web;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RestController;

import com.xxx.springcloud.consumer.movie.api.UserFeignClient;
import com.xxx.springcloud.consumer.movie.model.User;

@RestController
public class MovieController {

	private static final Logger logger = LoggerFactory.getLogger(MovieController.class);
	
	@Autowired
	private UserFeignClient userFeignClient;
	
	@GetMapping(value = "/user/{id}")
	public User queryById(@PathVariable Long id)
	{
		/*
		 * 多个参数使用@RequestBody 
		 */
		logger.info("---feign client------");
		return userFeignClient.queryById(id);
	}
	
	
}
