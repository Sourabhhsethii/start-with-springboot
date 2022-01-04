package com.upgrad.practice;

import com.upgrad.movieapp.MyService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.Profile;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
public class Controller {


    public MyService getMyService() {
        return myService;
    }

    @Autowired
    @Profile("dev")
    public void setMyService(MyService myService) {
        this.myService = myService;
    }

    @Autowired
    private MyService myService;

    @RequestMapping("/page1")
    public String welcomePage(){
        return "This is the first task of this exercise";
    }

    @RequestMapping("/page2")
    public String secondPage(){
        return "This is the second task of this exercise";
    }

    @RequestMapping("/page3")
    public String anotherPage(){
        return getMyService().anotherPage();
    }

}
