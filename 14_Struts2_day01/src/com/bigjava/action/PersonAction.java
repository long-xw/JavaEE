package com.bigjava.action;

import com.bigjava.entity.User;
import com.opensymphony.xwork2.ActionSupport;

/**
 * 继承类
 *
 * @author LXW
 * @creat2020-12-02-上午 7:53
 */
public class PersonAction extends ActionSupport {
    private User user ;

    public User getUser() {
        return user;
    }

    public void setUser(User user) {
        this.user = user;
    }

    @Override
    public String execute() throws Exception {
        return SUCCESS;
    }
}
