package com.bulain.main;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("/zipkin")
public class ZipkinClientController {

    @Autowired
    ZipkinClientService zipkinClientService;

    @RequestMapping(value = "/user", method = RequestMethod.GET)
    public String user() {
        return zipkinClientService.user();
    }

}
