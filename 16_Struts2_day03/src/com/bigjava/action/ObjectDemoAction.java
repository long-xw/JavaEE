package com.bigjava.action;

import com.bigjava.entity.User;
import com.opensymphony.xwork2.ActionSupport;

/**
 * @author LXW
 * @creat2020-12-06-下午 1:23
 */
public class ObjectDemoAction extends ActionSupport {
    //1.定义对象变量
    private User user = new User();
    //生成get方法


    public User getUser() {
        return user;
    }

    @Override
    public String execute() throws Exception {
        //3.向值栈的user里面放数据
        user.setUsername("lucy");
        user.setPassword("123");
        user.setAddress("美国");
        return SUCCESS;
    }
}
