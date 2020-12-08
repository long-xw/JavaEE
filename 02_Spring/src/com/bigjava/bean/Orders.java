package com.bigjava.bean;

/**
 * @author LXW
 * @creat2020-11-13-下午 2:06
 */
public class Orders {
    //无参数的构造
    public Orders() {
        System.out.println("第一步 执行无参数的构造创建bean实例");

    }
    private String oname;

    public void setOname(String oname) {
        this.oname = oname;
        System.out.println("第二部 调用set()方法设置属性的值");
    }

    //创建执行的初始化的方法
    public void initMethod() {
        System.out.println("第三步 执行初始化的方法");
    }

    //创建执行销毁的方法
    public void destroyMethod() {
        System.out.println("第五步 执行销毁的方法");
    }
}
