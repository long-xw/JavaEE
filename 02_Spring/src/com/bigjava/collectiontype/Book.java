package com.bigjava.collectiontype;

import java.util.List;

/**
 * @author LXW
 * @creat2020-11-13-上午 11:06
 */
public class Book {
    private List<String> list;

    public void setList(List<String> list) {
        this.list = list;
    }
    public void test() {
        System.out.println(list);
    }
}
