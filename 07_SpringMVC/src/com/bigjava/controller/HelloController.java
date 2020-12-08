package com.bigjava.controller;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;

/**
 * @author LXW
 * @creat2020-11-26-下午 2:11
 * 告诉springMVC这是一个处理器
 */
@Controller
public class HelloController {
    /**
     *1. 运行流程，
     *      1)，客户端点点击连接会发送http://localhost:8080/springmvc/hello 请求
     *      2) 来到tomcat服务器
     *      3) SpringMVC的前端控制器收到所有请求，
     *      4) 来看请求地址@RequestMapping标注的哪个匹配，来找到到底使用哪个类的哪个方法来处理
     *      5) 前端控制器找到了目标处理类和目标方法，直接利用返回执行目标方法
     *      6) 方法执行完成以后会有一个返回值，SpringMVC认为这个返回值就是要去的页面地址
     *      7) 拿到方法的返回值以后，用视图解析器进行拼串得到完整的页面地址
     *      8) 拿到页面地址，前端控制器帮我们转发到页面
     *
     * 2.@ReaquestMapping
     *          就是告诉SpringMVC 这个方法用来处理什么请求
     *          这个/是可以省略的，即使省略了，也是从默认从当前项下开始
     *          习惯加上比较号 /hello /hello01
     *          RequestMapping的使用，？
     *
     * 3.如果不指定配置文件位置？
     *      /WEB-INF?springDispatcherServlet-servlet.xml
     *      如果不指定也会默认去找一个文件
     *          /WEB-INF/xxx-servlet.xml
     *
     *
     */

    @RequestMapping("/hello01")
    public String nihao() {
        return "success";
    }

    @RequestMapping("/hello")
    public String nihao01() {
        System.out.println("handle01.....");
        return "error";
    }
    @RequestMapping("/hello03")
    public String nihao02() {
        return "success";
    }
}
