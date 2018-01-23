package com.bulain.main;

import java.security.Principal;

import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
public class Oauth2ClientController {

    @GetMapping("/")
    public String index() {
        return "index";
    }
    
    @GetMapping("/user")
    public Principal user(Principal user) {
        return user;
    }

    @GetMapping("/client")
    public String client() {
        return "OK";
    }

    @GetMapping("/anon")
    public String anon() {
        return "anon";
    }

}
