package com.bigjava.test;

import com.bigjava.autowire.Emp;
import com.bigjava.bean.Orders;
import com.bigjava.collectiontype.Book;
import com.bigjava.collectiontype.Course;
import com.bigjava.collectiontype.Student;
import com.bigjava.factorybean.MyBean;
import org.junit.Test;
import org.springframework.context.ApplicationContext;
import org.springframework.context.support.ClassPathXmlApplicationContext;

/**
 * @author LXW
 * @creat2020-11-13-上午 10:46
 */
public class TestSpring5Demo {

    @Test
    public void testCollection() {
        ApplicationContext context = new ClassPathXmlApplicationContext("bean1.xml");

        Student student = context.getBean("student", Student.class);

        student.test();
    }
    @Test
    public void testBook() {
        ApplicationContext context = new ClassPathXmlApplicationContext("bean2.xml");

        Book book1 = context.getBean("book", Book.class);

        Book book2 = context.getBean("book", Book.class);

        System.out.println(book1);

        System.out.println(book2);
    }
    @Test
    public void test3() {
        ApplicationContext context = new ClassPathXmlApplicationContext("bean3.xml");

        Course course = context.getBean("myBean", Course.class);
        System.out.println(course);
    }
    @Test
    public void testBean3() {
//        ApplicationContext context = new ClassPathXmlApplicationContext("bean4.xml");
        ClassPathXmlApplicationContext context = new ClassPathXmlApplicationContext("bean4.xml");

        Orders orders = context.getBean("orders", Orders.class);
        System.out.println("第四步 获取创建bean实例对象");
        System.out.println(orders);

        //手动让bean实例销毁
        context.close();
    }
    @Test
    public void test4() {
        ApplicationContext context = new ClassPathXmlApplicationContext("bean5.xml");

        Emp emp = context.getBean("emp", Emp.class);
        System.out.println(emp);
    }

}
