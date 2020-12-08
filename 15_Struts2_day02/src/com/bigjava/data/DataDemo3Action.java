package com.bigjava.data;

import com.bigjava.entity.Book;
import com.bigjava.entity.User;
import com.opensymphony.xwork2.ActionSupport;
import com.opensymphony.xwork2.ModelDriven;

/**
 *使用表达式封装数据到实体类对象
 * @author LXW
 * @creat2020-12-03-下午 2:47
 */
public class DataDemo3Action extends ActionSupport {

    //1.声明实体类
    private User user;
    private Book book;


    //2.生成实体类get和set方法


    public Book getBook() {
        return book;
    }

    public void setBook(Book book) {
        this.book = book;
    }

    public User getUser() {
        return user;
    }

    public void setUser(User user) {
        this.user = user;
    }

    @Override
    public String execute() throws Exception {
        System.out.println(user);
        System.out.println(book.getB_name());
        return NONE;
    }


}
