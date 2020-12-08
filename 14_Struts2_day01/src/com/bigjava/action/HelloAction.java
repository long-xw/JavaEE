package com.bigjava.action;

import com.opensymphony.xwork2.ActionSupport;

/**
 * @author LXW
 * @creat2020-12-01-下午 7:26
 */
public class HelloAction extends ActionSupport {
    /**
     *  （1）每次访问servlet时候，都会执行service方法
     *  -写类继承HttpServlet,重写类里面的方法
     *  -在web.xml中配置servlet访问路径
     *
     *  （2）访问action，每次访问action时候，默认执行名称execute方法
     *  -配置action访问路径
     *
     */
    public String  execute() {
        System.out.println("action......");
//        return none;
        return NONE;
    }
}
