package com.sitaluo.service;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;
import org.springframework.web.client.RestTemplate;

@Component
public class HiRibbonService {

	@Autowired
	private RestTemplate restTemplate;
	
	public String hi(String name) {
		return restTemplate.getForObject("http://eureka-client/hi?name="+name, String.class);
	}
}
