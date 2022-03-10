package com.bulain.main;

import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("/order")
public class ZipkinOrderController {
    
    @GetMapping("/sales")
    public String sales(){
        return "This is a zipkin order sales";
    }
    
}
