package com.bigjava.action;

import com.bigjava.entity.User;
import com.opensymphony.xwork2.ActionSupport;

import java.util.ArrayList;
import java.util.List;

/**
 * @author LXW
 * @creat2020-12-06-下午 1:23
 */
public class ListDemoAction extends ActionSupport {
   //1.定义list变量
    private List<User> list = new ArrayList<>();
    //2.生成get方法

    public List<User> getList() {
        return list;
    }

    @Override
    public String execute() throws Exception {
       //3.向list中设置值
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
