package com.bulain.main;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.web.client.RestTemplate;

@Service
public class RibbonService {

	@Autowired
	RestTemplate restTemplate;

	public String hiService(String name) {
		return restTemplate.getForObject("http://EUREKA-SERVICE/hi?name=" + name,
				String.class);
	}

}