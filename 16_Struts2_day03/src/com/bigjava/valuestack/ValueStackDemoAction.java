package com.bigjava.valuestack;

import com.bigjava.entity.User;
import com.opensymphony.xwork2.ActionSupport;

import java.util.ArrayList;
import java.util.List;

/**
 * @author LXW
 * @creat2020-12-06-下午 2:43
 */
public class ValueStackDemoAction extends ActionSupport {
//    private String username;
//
//    public String getUsername() {
//        return username;
//    }
//    private User user = new User();
//
//    public User getUser() {
//        return user;
//
    private List<User> list = new ArrayList<>();

    public List<User> getList() {
        return list;
    }

    @Override
    public String execute() throws Exception {
//        username = "bigjava";

//        user.setUsername("mary");
//        user.setPassword("250");
//        user.setAddress("china");

        //向list中设置数据
        User user1 = new User();
        user1.setUsername("小明");
        user1.setPassword("456");
        user1.setAddress("china");

        User user2 = new User();
        user2.setUsername("小胡");
        user2.setPassword("123");
        user2.setAddress("CHINA");

        list.add(user1);
        list.add(user2);


        return SUCCESS;



    }
}
