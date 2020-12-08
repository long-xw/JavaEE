package com.bigjava.action;

import com.opensymphony.xwork2.ActionContext;
import com.opensymphony.xwork2.ActionSupport;
import com.opensymphony.xwork2.util.ValueStack;

/**
 * @author LXW
 * @creat2020-12-06-下午 1:23
 */
public class ValueStackDemoAction extends ActionSupport {

    //1.定义变量
    private String name;
//
    public String getName() {
        return name;
    }

    @Override
    public String execute() throws Exception {
        //在执行的方法里面向变量设置值
//        name = "abcdefg";


        //第一种方式，使用值栈对象里面的set方法
        //1.获取值栈对象
        ActionContext context = ActionContext.getContext();
        ValueStack stack1 = context.getValueStack();
        //调用方法set方法
        stack1.set("bigjava","bigjava");

        //调用方法push方法
        stack1.push("abcd");


        return SUCCESS;
    }
}
