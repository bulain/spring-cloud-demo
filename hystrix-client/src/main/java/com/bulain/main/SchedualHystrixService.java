package com.bulain.main;

import org.springframework.stereotype.Component;

@Component
public class SchedualHystrixService implements HystrixService {
	
	@Override
	public String sayHiFromClientOne(String name) {
		return "sorry " + name;
	}

}
