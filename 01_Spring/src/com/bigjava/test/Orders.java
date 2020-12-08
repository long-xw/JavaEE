package com.bigjava.test;

/**
 * 使用有参数的构造注入
 * @author LXW
 * @creat2020-11-11-上午 9:29
 */
public class Orders {
    //属性
    private String oname;
    private String address;

    public Orders(String oname, String address) {
        this.oname = oname;
        this.address = address;
    }
    public void orderTest(){
        System.out.println(oname + " :: " + address);
    }
}
