package com.bigjava.demo;

/**
 * @author LXW
 * @creat2020-11-13-下午 8:44
 */
public class UserDaoImpl implements UserDao{
    @Override
    public int add(int a, int b) {
        System.out.println("add 方法执行了.......");
        return a+b;
    }

    @Override
    public String  update(String id) {
        System.out.println("update 方法执行了......");
        return id;
    }
}
