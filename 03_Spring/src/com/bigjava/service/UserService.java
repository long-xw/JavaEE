package com.bigjava.service;

import com.bigjava.dao.UserDao;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.stereotype.Service;

import javax.annotation.Resource;

/**
 * 在注解里面value属性值可以省略不写
 * 默认值是类的名称，首字母小写
 * UserService -- userService
 * @author LXW
 * @creat2020-11-13-下午 3:45
 */
//@Component(value = "userService")   //<bean id="userService" class=""/>
@Service
public class UserService {
    @Value(value = "abc")
    private String name;

    //定义dao类型的属性
    //不需要添加set方法
    //添加注入属性注解
//    @Autowired      //根据类型进行注入
//    @Qualifier(value = "userDaoImpl1")      //根据名称进行注入
//    private UserDao userDao;

//    @Resource //根据类型进行注入
    @Resource(name = "userDaoImpl1")
    private UserDao userDao;

    public void add() {
        System.out.println("service add....." + name);
        userDao.add();
    }
}
