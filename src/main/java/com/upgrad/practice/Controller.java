package com.upgrad.practice;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
public class Controller {


    @RequestMapping("/page1")
    public String welcomePage(){
        return "This is the first task of this exercise";
    }

    @RequestMapping("/page2")
    public String secondPage(){
        return "This is the second task of this exercise";
    }



}
