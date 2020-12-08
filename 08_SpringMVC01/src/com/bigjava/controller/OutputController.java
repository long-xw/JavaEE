package com.bigjava.controller;

import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.ui.ModelMap;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.SessionAttributes;
import org.springframework.web.servlet.ModelAndView;

import java.util.Map;

/**
 * SpringMVC除过在方法上传原生的request和session外还能怎样把数据带给页面
 *
 * 1)可以在方法除传Map，或者Model或者ModelMap,
 *      给这些参数保存的数据都会放在域中，可以直接获取
 *    关系：
 *      Map,Model,ModelMap,最终都是BindingAwareModelMap在工作
 *      相当于给BindingAwareModelMap中保存的东西都会被放在请求域中，
 *
 *      Map(Interface(jdk))     Model(Interface(Spring))
 *            ||                        //
 *            ||                       //
 *            \/                      //
 *      ModelMap(class)              //
 *                     \\           //
 *                      \\         //
 *                       ExtendedModelMap
 *                               ||
 *                               \/
 *                      BindingAwareModelMap
 *
 * 2),方法的返回值可以变为ModelAndView类型
 *          既包含视图信息（页面地址） 也包含模型数据（给页面带的数据）
 *          而且数据是放在请求域中
 *          request，session，application
 *
 * 3).SpringNVC提供了一种可以临时给Session域中保存数据的方式
 *          使用一个注解       @SessionAttributes（只能标在类上）
 *          @SessionAttributes(value = "msg"):
 *              给BindingAwareModelMap中保存的数据，同时给session中放一份
 *              value保存数据时要给session中放一份数据的key
 *
 *          value={"msg"},只要保存的是这种key的数据，给session中也放一份
 *          types={String.class},只要保存的是这种类型的数据，给session中也放一份
 *      后来推荐SessionAttributes就别用了，可能会引发异常
 *              给session中放数据请使用原生的API
 *
 * @author LXW
 * @creat2020-12-07-下午 2:21
 */
@SessionAttributes(value = {"msg"},types = {String.class})
@Controller
public class OutputController {

    @RequestMapping("/handle01")
    public String handle01(Map<String, Object> map) {
        map.put("msg","你好");
        map.put("haha","哈哈哈");
        System.out.println("map的类型" + map.getClass());
        return "success";
    }

    /**
     * Model,一个接口
     * @param model
     * @return
     */
    @RequestMapping("/handle02")
    public String handle02(Model model) {
        model.addAttribute("msg","你好坏！");
        model.addAttribute("haha",18);
        System.out.println("Model的类型" + model.getClass());
        return "success";
    }

    @RequestMapping("/handle03")
    public String handle03(ModelMap modelMap) {
        modelMap.addAttribute("msg","你好棒！");
        System.out.println("ModelMap的类型" + modelMap.getClass());
        return "success";
    }


    /**
     * 返回值ModelAndView，可以为页面携带数据
     * @return
     */
    @RequestMapping("/handle04")
    public ModelAndView handle04() {
        //之前的返回值就叫视图名： 视图名视图解析器是会帮我们最终拼串得到页面的真实地址
//        ModelAndView mv = new ModelAndView("success");
        ModelAndView mv = new ModelAndView();
        mv.setViewName("success");
        mv.addObject("msg","你好哦！");
        return mv;
    }


}
