package com.xxx.springcloud.consumer.movie.api;

import org.springframework.cloud.netflix.feign.FeignClient;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;

import com.xxx.springcloud.consumer.movie.model.User;

@FeignClient(name="microservice-provider-user",fallback=FeignClientFallback.class)
public interface UserFeignClient {
	
	@RequestMapping(value="/{id}",method=RequestMethod.GET)
	public User queryById(@PathVariable("id")Long id);

}
