package com.upgrad.movieapp;

import org.springframework.context.annotation.Profile;
import org.springframework.stereotype.Component;
import org.springframework.web.bind.annotation.RequestMapping;

@Profile("dev")
@Component
public class MyService {

    public String anotherPage(){
        return "Hello World";
    }
}
