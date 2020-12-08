package com.bigjava.form;

import com.opensymphony.xwork2.ActionContext;
import com.opensymphony.xwork2.ActionSupport;

import java.util.Arrays;
import java.util.Map;
import java.util.Set;

/**
 *
 * 使用ActionContext
 * @author LXW
 * @creat2020-12-03-上午 8:06
 */
public class Form1DemoAction extends ActionSupport {
    @Override
    public String execute() throws Exception {
        //第一种方式使用ActionContext类来获取
        //1.获取ActionContext对象
        ActionContext context = ActionContext.getContext();
        //调用方法得到表单数据
        //key是表单输入项的name属性值，value是输入的值
        Map<String,Object> map = context.getParameters();
        Set<String> keys = map.keySet();
        for(String key : keys) {
            //根据key得到value
            //数组形式：因为输入项里面可能有复选框的情况
            Object[] value = (Object[]) map.get(key);
            System.out.println(Arrays.toString(value));
        }
        return NONE;
    }
}
