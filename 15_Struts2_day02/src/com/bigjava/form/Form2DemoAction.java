package com.bigjava.form;

import com.opensymphony.xwork2.ActionContext;
import com.opensymphony.xwork2.ActionSupport;
import org.apache.struts2.ServletActionContext;

import javax.servlet.ServletContext;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpSession;
import java.util.Arrays;
import java.util.Map;
import java.util.Set;

/**
 * 使用ServletActionContext方式
 * @author LXW
 * @creat2020-12-03-上午 8:06
 */
public class Form2DemoAction extends ActionSupport {
    @Override
    public String execute() throws Exception {
        /*//第一种方式使用ServletActionContext类来获取
        //1.使用ServletActionContext获取request对象
        HttpServletRequest request = ServletActionContext.getRequest();
        //2.调用request里面的方法得到结果
        String username = request.getParameter("username");
        String password = request.getParameter("password");
        String address = request.getParameter("address");
        System.out.println(username + ":" + password + ":" + address)  ;*/

        //操作三个域对象
        //1.request域
        HttpServletRequest request = ServletActionContext.getRequest();
        request.setAttribute("req","reqValue");

        //2.session域
        HttpSession session = request.getSession();
        session.setAttribute("sess","sessValue");

        //3.ServletContext域
        ServletContext context = ServletActionContext.getServletContext();
        context.setAttribute("contextName","contextValue");

        return NONE;
    }
}
