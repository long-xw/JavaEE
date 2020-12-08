package com.bigjava.controller;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;

/**
 * @author LXW
 * @creat2020-12-07-下午 2:18
 */
@Controller
public class HelloController {
    @RequestMapping("/hello")
    public String hello(){
        System.out.println("hello.....");
        return "success";
    }

}
