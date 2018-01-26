package com.bulain.main;

import org.springframework.cloud.netflix.feign.FeignClient;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;

@FeignClient(value = "zipkin-gateway")
public interface ZipkinClientService {

    @RequestMapping(value = "zipkin/user", method = RequestMethod.GET)
    String user();

}
