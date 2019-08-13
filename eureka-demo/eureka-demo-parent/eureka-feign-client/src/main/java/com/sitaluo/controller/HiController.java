package com.sitaluo.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;

import com.sitaluo.service.HiService;

@RestController
public class HiController {

	@Autowired
	private HiService hiService;
	
	@GetMapping("/hi")
	public String sayHi(String name) {
		return hiService.hi(name);
	}
	
}
