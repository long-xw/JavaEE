package com.bigjava.demo.aopanno;

import org.springframework.stereotype.Component;

/**
 * 被增强的类
 * @author LXW
 * @creat2020-11-15-下午 2:48
 */
@Component
public class User {

    public void add() {

//        int i = 10 / 0;
        System.out.println("add .....");
    }
}
