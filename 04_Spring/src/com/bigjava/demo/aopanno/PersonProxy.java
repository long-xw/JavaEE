package com.bigjava.demo.aopanno;

import org.aspectj.lang.annotation.Aspect;
import org.aspectj.lang.annotation.Before;
import org.springframework.core.annotation.Order;
import org.springframework.stereotype.Component;

/**
 * @author LXW
 * @creat2020-11-16-上午 9:13
 */
@Component
@Aspect
@Order(1)
public class PersonProxy {

    @Before(value = "execution(* com.bigjava.demo.aopanno.User.add(..))")
    public void before() {
        System.out.println("Person Before ....");
    }
}
