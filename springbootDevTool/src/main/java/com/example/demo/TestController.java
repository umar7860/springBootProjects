package com.example.demo;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;

@Controller
public class TestController {
    @RequestMapping("/test")
    @ResponseBody
    public String test() {
        int a = 30;
        int b = 30;
        int c = 100;
        return "THis is just testing sum of a, b and c is " + (a+b+c);
    }

}
