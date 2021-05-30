package com.bulain.main;

import com.alibaba.csp.sentinel.annotation.SentinelResource;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.boot.autoconfigure.EnableAutoConfiguration;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

@RestController
@EnableAutoConfiguration
public class NacosServiceCtrl {

	@Value("${server.port}")
	String port;
	
	@Value("${ns.conf}")
	String conf;

	@SentinelResource("home")
	@RequestMapping("/")
	public String home() {
		return "home";
	}

	@SentinelResource("hi")
	@RequestMapping("/hi")
	public String hi() {
		return "hi " + conf + ",i am from port:" + port;
	}

}
