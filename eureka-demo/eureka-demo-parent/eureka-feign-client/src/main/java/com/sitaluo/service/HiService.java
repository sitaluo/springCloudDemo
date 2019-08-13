package com.sitaluo.service;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.sitaluo.feignClient.EurekaClientFeign;

@Service
public class HiService {
	
	@Autowired
	private EurekaClientFeign eurekaClientFeign;
	
	public String hi(String name) {
		return eurekaClientFeign.sayHiFromEurekaClient(name);
	}
}
