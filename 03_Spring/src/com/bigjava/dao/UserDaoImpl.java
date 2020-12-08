package com.bigjava.dao;

import org.springframework.stereotype.Repository;

/**
 * @author LXW
 * @creat2020-11-13-下午 7:49
 */
@Repository(value = "userDaoImpl1")
public class UserDaoImpl implements UserDao{
    @Override
    public void add() {
        System.out.println("Dao add......");
    }
}
