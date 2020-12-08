package com.bigjava.test.service;

import com.bigjava.test.dao.UserDao;
import com.bigjava.test.dao.UserDaoImpl;

/**
 * @author LXW
 * @creat2020-11-12-上午 7:53
 */
public class UserService {
    //创建UserDao类型属性，生成set方法
    private UserDao userDao;

    public void setUserDao(UserDao userDao) {
        this.userDao = userDao;
    }

    public void add() {
        System.out.println("service add.........");
        userDao.update();
    }
}
