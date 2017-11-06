package com.thymeleaf.example.demo.web;

import com.thymeleaf.example.demo.entity.User;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;

import javax.servlet.http.HttpSession;
import java.util.Calendar;

@Controller
public class HomeController {

    @RequestMapping("/")
    public String home(HttpSession session){
        session.setAttribute("user",new User("Jean","Araon","China",20));
        session.setAttribute("today", Calendar.getInstance().getTime());
        return "home";
    }


    @RequestMapping("/subscribe")
    public String suscribe(){
        return "subscribe";
    }

    @RequestMapping("/userprofile")
    public String userprofile(HttpSession session){
        session.setAttribute("user",new User("Jean","Araon","China",20));
        return "userprofile";
    }

}
