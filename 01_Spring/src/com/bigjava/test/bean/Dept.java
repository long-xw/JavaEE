package com.bigjava.test.bean;

/**
 * 部门类
 * @author LXW
 * @creat2020-11-12-下午 4:02
 */
public class Dept {

    private String dname;

    public void setDname(String dname) {
        this.dname = dname;
    }

    @Override
    public String toString() {
        return "Dept{" +
                "dname='" + dname + '\'' +
                '}';
    }
}
