package com.bigjava.testdemo;

import com.bigjava.config.SpringConfig;
import com.bigjava.service.UserService;
import org.junit.Test;
import org.springframework.context.ApplicationContext;
import org.springframework.context.annotation.AnnotationConfigApplicationContext;
import org.springframework.context.support.ClassPathXmlApplicationContext;

/**
 * @author LXW
 * @creat2020-11-13-下午 3:36
 */
public class TestSpring5Demo {

    @Test
    public void testService1(){
        ApplicationContext context = new ClassPathXmlApplicationContext("bean1.xml");
        UserService userService = context.getBean("userService",UserService.class);
        System.out.println(userService);
        userService.add();
    }

    @Test
    public void testService2(){
        ApplicationContext context = new AnnotationConfigApplicationContext(SpringConfig.class);
        UserService userService = context.getBean("userService",UserService.class);
        System.out.println(userService);
        userService.add();
    }

}
