package com.bigjava.spring5.dao;

import com.bigjava.spring5.entity.Book;

import java.util.List;

/**
 * @author LXW
 * @creat2020-11-24-上午 7:50
 */
public interface BookDao {

    //添加的方法
    void add(Book book);

    //修改的方法
    void updateBook(Book book);

    //删除的方法
    void deleteBook(int id);

    //查询表中的记录数
    int selectCount();

    //查询返回对象
    Book findBookInfo(int id);

    //查询返回集合
    List<Book> findAllBook();

    //批量添加
    void batchAdd(List<Object[]> batchArgs);

    void batchUpdate(List<Object[]> batchArgs);

    void batchDelete(List<Object[]> batchArgs);
}
