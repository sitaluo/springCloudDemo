package com.sitaluo.feignClient;

import org.springframework.stereotype.Component;

@Component
public class HiHystrix implements EurekaClientFeign{

	@Override
	public String sayHiFromEurekaClient(String name) {
		return "hi,"+name+",error!";
	}

}
