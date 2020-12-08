package com.bigjava.test.testdemo;

import com.bigjava.test.Book;
import com.bigjava.test.Orders;
import com.bigjava.test.User;
import org.junit.Test;
import org.springframework.beans.factory.BeanFactory;
import org.springframework.context.ApplicationContext;
import org.springframework.context.support.ClassPathXmlApplicationContext;

/**
 * @author LXW
 * @creat2020-11-10-下午 3:08
 */
public class TestUser {
    @Test
    public void testAdd() {
        //1.加载spring配置文件
        ApplicationContext context = new ClassPathXmlApplicationContext("bean1.xml");

        //2.获取配置创建对象
        User user = context.getBean("user", User.class);

        System.out.println(user);

        user.add();
    }
    @Test
    public void testBook1() {
        //1.加载spring配置文件
        ApplicationContext context = new ClassPathXmlApplicationContext("bean1.xml");

        //2.获取配置创建对象
        Book book = context.getBean("book", Book.class);

        System.out.println(book);

        book.testDemo();
    }
    @Test
    public void testOrders() {
        //1.加载spring配置文件
        ApplicationContext context = new ClassPathXmlApplicationContext("bean1.xml");

        //2.获取配置创建对象
        Orders orders = context.getBean("orders", Orders.class);

        System.out.println(orders);

        orders.orderTest();
    }
}
