package com.bigjava.form;

import com.bigjava.entity.User;
import com.opensymphony.xwork2.ActionSupport;
import org.apache.struts2.ServletActionContext;
import org.apache.struts2.interceptor.ServletRequestAware;

import javax.servlet.http.HttpServletRequest;

/**
 * 使用ServletActionContext获取表单数据封装到实体类对象里面
 * @author LXW
 * @creat2020-12-03-上午 8:06
 */
public class Form4DemoAction extends ActionSupport{

    @Override
    public String execute() throws Exception {
        //1.获取表单数据
        HttpServletRequest request = ServletActionContext.getRequest();
        String username = request.getParameter("username");
        String password = request.getParameter("password");
        String address = request.getParameter("address");

        //2.封装到实体类的对象里面
        User user = new User();
        user.setUsername(username);
        user.setPassword(password);
        user.setAddress(address);

        System.out.println(user);

        return NONE;
    }
}
