package com.bulain.main;

import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
public class ZipkinServiceController {
    
    @GetMapping("/user")
    public String user(){
        return "This is a zipkin service user";
    }
    
}
