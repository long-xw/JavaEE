package com.bigjava.form;

import com.opensymphony.xwork2.ActionSupport;
import org.apache.struts2.ServletActionContext;
import org.apache.struts2.interceptor.ServletRequestAware;

import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;

/**
 * 使用接口方式注入
 * @author LXW
 * @creat2020-12-03-上午 8:06
 */
public class Form3DemoAction extends ActionSupport implements ServletRequestAware {
    private HttpServletRequest request;
    @Override
    public String execute() throws Exception {

        request.getParameter("");



        return NONE;
    }

    @Override
    public void setServletRequest(HttpServletRequest httpServletRequest) {
        this.request = request;
    }
}
