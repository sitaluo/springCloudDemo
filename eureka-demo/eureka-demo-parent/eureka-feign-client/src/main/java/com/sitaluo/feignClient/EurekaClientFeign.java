package com.sitaluo.feignClient;

import org.springframework.cloud.netflix.feign.FeignClient;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestParam;

import com.sitaluo.config.FeignConfig;

@FeignClient(value="eureka-client",configuration=FeignConfig.class)
public interface EurekaClientFeign {
	
	@GetMapping("/hi")
	String sayHiFromEurekaClient(@RequestParam(value="name")String name);
}
