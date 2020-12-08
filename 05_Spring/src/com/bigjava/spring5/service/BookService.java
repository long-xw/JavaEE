package com.bigjava.spring5.service;

import com.bigjava.spring5.dao.BookDao;
import com.bigjava.spring5.entity.Book;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

/**
 * @author LXW
 * @creat2020-11-24-上午 7:50
 */
@Service
public class BookService {

    //注入Dao
    @Autowired
    private BookDao bookDao;

    //添加的方法
    public void  addBook(Book book){
        bookDao.add(book);
    }

    //修改的方法
    public void updateBook(Book book) {
        bookDao.updateBook(book);
    }

    //删除的方法
    public void deleteBook(int  id) {
        bookDao.deleteBook(id);
    }

    //查询表中的记录数
    public int  findCount() {
        return bookDao.selectCount();
    }

    //查询返回对象
    public Book  findOne(int id) {
        return bookDao.findBookInfo(id);
    }

    //查询返回集合
    public List<Book> findAll() {
        return bookDao.findAllBook();
    }

    //批量添加
    public void batchAdd(List<Object[]> batchArgs) {
        bookDao.batchAdd(batchArgs);
    }
    //批量修改
    public void batchUpdate(List<Object[]> batchArgs) {
        bookDao.batchUpdate(batchArgs);
    }
    //批量删除
    public void batchDelete(List<Object[]> batchArgs) {
        bookDao.batchDelete(batchArgs);
    }



}
