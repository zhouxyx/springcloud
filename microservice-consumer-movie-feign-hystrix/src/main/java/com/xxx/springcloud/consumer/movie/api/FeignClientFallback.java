package com.xxx.springcloud.consumer.movie.api;

import org.springframework.stereotype.Component;

import com.xxx.springcloud.consumer.movie.model.User;

@Component
public class FeignClientFallback implements UserFeignClient{

	
	public User queryById(Long id) {
		User user = new User();
		user.setId(-1L);
		user.setUsername("默认用户");
		return user;
	}

}
