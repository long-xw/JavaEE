package com.bigjava.spring5.test;

import com.bigjava.spring5.service.BookService;
import org.junit.Test;
import org.springframework.context.ApplicationContext;
import org.springframework.context.support.ClassPathXmlApplicationContext;

import java.util.ArrayList;
import java.util.List;

/**
 * @author LXW
 * @creat2020-11-24-上午 9:11
 */
public class TestBook {
    @Test
    public void testJdbcTemplate() {
        ApplicationContext applicationContext = new ClassPathXmlApplicationContext("bean1.xml");
        BookService bookService = applicationContext.getBean("bookService", BookService.class);
        //添加
//        Book book = new Book();
//        book.setUserId(1);
//        book.setUsername("java");
//        book.setUstatus("a");
//        bookService.addBook(book);

        //修改
//        Book book = new Book();
//        book.setUserId(1);
//        book.setUsername("javaupup");
//        book.setUstatus("bjigjava");
//        bookService.updateBook(book);

        //删除
//        bookService.deleteBook(1);

        //查询返回某个值
//        System.out.println(bookService.findCount());


        //查询返回对象
//        Book one = bookService.findOne(2);
//        System.out.println(one);

        //查询返回集合
//        List<Book> all = bookService.findAll();
//        System.out.println(all);

        //批量添加
//        List<Object[]> batchArgs = new ArrayList<>();
//        Object[] o1 = {5,"java","b"};
//        Object[] o2 = {6,"php","c"};
//        Object[] o3 = {7,"jQuery","d"};
//        batchArgs.add(o1);
//        batchArgs.add(o2);
//        batchArgs.add(o3);
//        //调用批量添加
//        bookService.batchAdd(batchArgs);

        //批量修改

//        List<Object[]> batchArgs  = new ArrayList<>();
//        Object[] o1 = {"CSS","b",3};
//        Object[] o2 = {"HTML","c",4};
//        Object[] o3 = {"Mysql","d",5};
//        batchArgs.add(o1);
//        batchArgs.add(o2);
//        batchArgs.add(o3);
//        bookService.batchUpdate(batchArgs);

        //批量删除
        List<Object[]> batchArgs  = new ArrayList<>();
        Object[] o1 = {3};
        Object[] o2 = {4};
        Object[] o3 = {5};
        batchArgs.add(o1);
        batchArgs.add(o2);
        batchArgs.add(o3);
        bookService.batchDelete(batchArgs);


    }

}
