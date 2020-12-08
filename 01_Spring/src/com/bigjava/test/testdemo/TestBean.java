package com.bigjava.test.testdemo;

import com.bigjava.test.bean.Emp;
import com.bigjava.test.service.UserService;
import org.junit.Test;
import org.springframework.context.ApplicationContext;
import org.springframework.context.support.ClassPathXmlApplicationContext;

/**
 * @author LXW
 * @creat2020-11-12-下午 3:45
 */
public class TestBean {
    @Test
    public void testBean1() {
        //1.加载spring配置文件
        ApplicationContext context = new ClassPathXmlApplicationContext("bean2.xml");

        //2.获取配置文件创建的对象
        UserService userService = context.getBean("userService",UserService.class);

        userService.add();
    }
    @Test
    public void testBean2() {
        //1.加载spring配置文件
        ApplicationContext context = new ClassPathXmlApplicationContext("bean3.xml");

        //2.获取配置文件创建的对象
        Emp emp = context.getBean("emp", Emp.class);

        emp.add();
    }
    @Test
    public void testBean3() {
        //1.加载spring配置文件
        ApplicationContext context = new ClassPathXmlApplicationContext("bean4.xml");

        //2.获取配置文件创建的对象
        Emp emp = context.getBean("emp", Emp.class);

        emp.add();
    }
}
