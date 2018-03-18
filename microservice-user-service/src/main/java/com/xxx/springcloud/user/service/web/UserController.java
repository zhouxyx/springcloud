package com.xxx.springcloud.user.service.web;

import java.util.HashMap;
import java.util.Map;

import org.springframework.cloud.context.config.annotation.RefreshScope;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping(value="/user")
@RefreshScope
public class UserController {

	@GetMapping(value="/{id}")
	public Map<String,Object> user(@PathVariable("id")Long id){
		Map<String, Object> map = new HashMap<String, Object>();
		map.put("id", id);
		map.put("name", "test");
		return map;
	}
}
