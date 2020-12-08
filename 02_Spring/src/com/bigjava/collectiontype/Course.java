package com.bigjava.collectiontype;

/**
 * @author LXW
 * @creat2020-11-13-上午 10:57
 */
public class Course {
    private String cname;

    public void setCname(String cname) {
        this.cname = cname;
    }

    @Override
    public String toString() {
        return "Course{" +
                "cname='" + cname + '\'' +
                '}';
    }
}
