package com.quiz2.quiz2.repo;

import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;

public class PasswordEncoder {
    
    public static void main(String[] args) {
        BCryptPasswordEncoder encoder = new BCryptPasswordEncoder();
        String rawPass = "dewik12345";
        String newPass =  encoder.encode(rawPass);

        System.out.println(newPass);
    }
}
