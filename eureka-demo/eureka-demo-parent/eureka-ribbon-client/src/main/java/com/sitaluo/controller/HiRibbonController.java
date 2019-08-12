package com.sitaluo.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import com.sitaluo.service.HiRibbonService;

@RestController
public class HiRibbonController {

	@Autowired
	private HiRibbonService hiRibbonService;
	
	@GetMapping("/hi")
	public String hello(@RequestParam String name) {
		
		return hiRibbonService.hi(name);
		
	}
}
