package com.bigjava.valuestack;


import com.opensymphony.xwork2.ActionSupport;
import org.apache.struts2.ServletActionContext;

import javax.servlet.http.HttpServletRequest;

/**
 * @author LXW
 * @creat2020-12-06-下午 2:43
 */
public class ContextAction extends ActionSupport {

    @Override
    public String execute() throws Exception {
        HttpServletRequest request = ServletActionContext.getRequest();
        request.setAttribute("req","request" +
                "");

        return SUCCESS;



    }
}
