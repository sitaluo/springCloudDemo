package com.sitaluo.config;

import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

import feign.Retryer;

@Configuration
public class FeignConfig {

	@Bean
	public Retryer feignRetryer() {
		return new Retryer.Default(100, 1000, 5);
	}
}
