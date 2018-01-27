package com.bulain.main;

import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("/inv")
public class ZipkinInvController {
    
    @GetMapping("/lot")
    public String lot(){
        return "This is a zipkin inv lot";
    }
    
}
