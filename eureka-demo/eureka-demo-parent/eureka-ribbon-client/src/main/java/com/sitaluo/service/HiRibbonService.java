package com.sitaluo.service;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;
import org.springframework.web.client.RestTemplate;

import com.netflix.hystrix.contrib.javanica.annotation.HystrixCommand;

@Component
public class HiRibbonService {

	@Autowired
	private RestTemplate restTemplate;
	
	@HystrixCommand(fallbackMethod="hiError")
	public String hi(String name) {
		return restTemplate.getForObject("http://eureka-client/hi?name="+name, String.class);
	}
	
	public String hiError(String name) {
		return "hi,"+name+", error!";
	}
	
}
