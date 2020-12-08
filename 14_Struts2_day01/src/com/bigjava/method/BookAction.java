package com.bigjava.method;

import com.opensymphony.xwork2.ActionSupport;

/**
 * @author LXW
 * @creat2020-12-02-下午 3:04
 */
public class BookAction extends ActionSupport {
    //添加
    public String add() {
        System.out.println("add......");
        return NONE;
    }

    //修改
    public String update() {
        System.out.println("update.....");
        return NONE;
    }

}
