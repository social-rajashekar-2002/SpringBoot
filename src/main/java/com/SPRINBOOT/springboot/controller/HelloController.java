package com.SPRINBOOT.springboot.controller;

import org.springframework.web.bind.annotation.RestController;
import org.springframework.stereotype.Component;
import org.springframework.web.bind.annotation.GetMapping;

import org.springframework.beans.factory.annotation.Value;


@RestController
@Component
public class HelloController {

    @Value("${welcome.msg}")
    private String message;
    
    @GetMapping("/")
    public String Helloworld(){
        return message;
    }
    
}


// import org.springframework.beans.factory.annotation.Value;
// import org.springframework.stereotype.Component;

// @Component
// public class HelloController {

//     @Value("${welcome.msg}")
//     private String welcomeMessage;

//     public void displayWelcomeMessage() {
//         System.out.println(welcomeMessage);
//     }
// }