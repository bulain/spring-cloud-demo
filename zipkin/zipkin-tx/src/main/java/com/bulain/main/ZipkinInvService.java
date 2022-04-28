package com.bulain.main;

import org.springframework.cloud.openfeign.FeignClient;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;

@FeignClient(value = "zipkin-inv")
public interface ZipkinInvService {

    @RequestMapping(value = "inv/lot", method = RequestMethod.GET)
    String lot();

}
