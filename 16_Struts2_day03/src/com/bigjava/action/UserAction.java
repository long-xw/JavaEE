package com.bigjava.action;

import com.opensymphony.xwork2.ActionContext;
import com.opensymphony.xwork2.ActionSupport;
import com.opensymphony.xwork2.util.ValueStack;

/**
 * @author LXW
 * @creat2020-12-06-下午 1:23
 */
public class UserAction extends ActionSupport {
    public UserAction() {
        System.out.println("action创建了............");
    }

    @Override
    public String execute() throws Exception {
        //1.获取ActionContext类的对象
        ActionContext context = ActionContext.getContext();
        //2.调用方法得到值栈对象
        ValueStack stack1 = context.getValueStack();


        ValueStack stack2 = context.getValueStack();

        System.out.println(stack1 == stack2);
        return NONE;
    }
}
