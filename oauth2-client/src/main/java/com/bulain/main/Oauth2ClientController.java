package com.bulain.main;

import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
public class Oauth2ClientController {

    @GetMapping("/client")
    public String user() {
        return "OK";
    }
    
}
