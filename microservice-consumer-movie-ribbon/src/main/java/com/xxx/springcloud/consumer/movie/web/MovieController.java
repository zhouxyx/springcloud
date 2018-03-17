package com.xxx.springcloud.consumer.movie.web;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.cloud.client.ServiceInstance;
import org.springframework.cloud.client.loadbalancer.LoadBalancerClient;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.client.RestTemplate;

import com.xxx.springcloud.consumer.movie.model.User;

@RestController
public class MovieController {

	private static final Logger logger = LoggerFactory.getLogger(MovieController.class);
	
	//负载
	@Autowired
//	@LoadBalanced
	private RestTemplate restTemplate;
	
	@Value("${user.user-service-url}")
	private String userServiceUrl;

	@Autowired
	private LoadBalancerClient boadBalancerClient;
	
	@GetMapping(value = "/user/{id}")
	public User queryById(@PathVariable Long id) {
		return restTemplate.getForObject(userServiceUrl + id, User.class);
	}
	
	@GetMapping(value="/log-user")
	public void logUserInstance() {
		ServiceInstance serviceInstance = boadBalancerClient.choose("microservice-provider-user");
		
		logger.info("{}:{}:{}", serviceInstance.getServiceId(),
				serviceInstance.getHost() , serviceInstance.getPort()
				);
			
	}
}
