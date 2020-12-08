package com.bigjava.data;


import com.bigjava.entity.User;
import com.opensymphony.xwork2.ActionSupport;

import java.util.List;
import java.util.Map;

/**
 * 封装数据到Map集合
 * @author LXW
 * @creat2020-12-03-下午 2:47
 */
public class MapAction extends ActionSupport {

    //1.声明map集合
    private Map<String,User> map;

    //生成get和set方法

    public Map<String, User> getMap() {
        return map;
    }

    public void setMap(Map<String, User> map) {
        this.map = map;
    }

    @Override
    public String execute() throws Exception {
        System.out.println(map);
        return NONE;
    }


}
