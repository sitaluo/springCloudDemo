package com.sitaluo.controller;

import org.springframework.beans.factory.annotation.Value;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

@RestController
public class HiController {

	@Value("${server.port}")
	private String port;
	
	@GetMapping("/hi")
	public String hello(@RequestParam String name) {
		
		return "hello,"+name+",i am from port "+ port;
		
	}
}
