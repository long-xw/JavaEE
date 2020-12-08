package com.bigjava.autowire;

/**
 * @author LXW
 * @creat2020-11-13-下午 2:33
 */
public class Emp {
    private Dept dept;

    public void setDept(Dept dept) {
        this.dept = dept;
    }

    @Override
    public String toString() {
        return "Emp{" +
                "dept=" + dept +
                '}';
    }
    public void test() {
        System.out.println(dept);
    }
}
