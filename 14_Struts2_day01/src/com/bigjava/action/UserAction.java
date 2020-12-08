package com.bigjava.action;

import com.opensymphony.xwork2.Action;

/**
 * 实现接口
 * @author LXW
 * @creat2020-12-02-上午 7:51
 */
public class UserAction  implements Action {

    @Override
    public String execute() throws Exception {
//        return "success";
        return SUCCESS;
    }
}
