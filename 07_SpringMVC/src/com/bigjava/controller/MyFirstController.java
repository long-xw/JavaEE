package com.bigjava.controller;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;

/**
 * @author LXW
 * @creat2020-11-26-上午 10:34
 * 告诉springMVC这是一个处理器，可以处理请求
 *  @Controller 标识哪个组件是控制器
 */
@Controller
public class MyFirstController {
    /**
     //     *  /代表从当前项目下开始，处理当前项下的hello的请求
     //     */
//    @RequestMapping("/hello")
//    public String  myforstRequest() {
//        System.out.println("请求收到了，......正在处理中");
//        //视图解析自动拼接
////        <property name="prefix" value="/pages"></property>
////        <property name="suffix" value=".jsp"></property>
//        //     (前缀) /pages/+返回值(success) + 后缀(.jsp)
//
//        return "success";
//    }
//

}
