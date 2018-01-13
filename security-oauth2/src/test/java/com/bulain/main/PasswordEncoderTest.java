package com.bulain.main;

import org.junit.Test;
import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;
import org.springframework.security.crypto.password.PasswordEncoder;

public class PasswordEncoderTest {

    private PasswordEncoder passwordEncoder = new BCryptPasswordEncoder();
    
    @Test
    public void testEncoder(){
        System.out.println(passwordEncoder.encode("admin"));
        System.out.println(passwordEncoder.encode("user"));
        System.out.println(passwordEncoder.encode("guest"));
    }
    
}
