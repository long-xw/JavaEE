package com.bigjava.data;

import com.bigjava.entity.User;
import com.opensymphony.xwork2.ActionSupport;
import com.opensymphony.xwork2.ModelDriven;

/**
 * 使用模型驱动的方式获取表单数据
 * @author LXW
 * @creat2020-12-03-下午 2:47
 */
public class DataDemo2Action extends ActionSupport implements ModelDriven<User> {
    //创建对象
    //前提要求：表单输入项name属性值 和 实体类属性名称一样
    private User user = new User();

    @Override
    public User getModel() {
        //返回创建user对象
        return user;
    }
    //属性封装
    private String username;
    private String password;
    private String address;

    public User getUser() {
        return user;
    }

    public void setUser(User user) {
        this.user = user;
    }

    public String getUsername() {
        return username;
    }

    public void setUsername(String username) {
        this.username = username;
    }

    public String getPassword() {
        return password;
    }

    public void setPassword(String password) {
        this.password = password;
    }

    public String getAddress() {
        return address;
    }

    public void setAddress(String address) {
        this.address = address;
    }

    @Override
    public String execute() throws Exception {
        System.out.println(user);
        return NONE;
    }


}
