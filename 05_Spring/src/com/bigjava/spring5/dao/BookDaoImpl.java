package com.bigjava.spring5.dao;

import com.bigjava.spring5.entity.Book;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.jdbc.core.BeanPropertyRowMapper;
import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.stereotype.Repository;

import java.util.Arrays;
import java.util.List;

/**
 * @author LXW
 * @creat2020-11-24-上午 7:50
 */

@Repository
public class BookDaoImpl  implements BookDao{

    //注入jdbcTemplate
    @Autowired
    private JdbcTemplate jdbcTemplate;

    //添加的方法
    @Override
    public void add(Book book) {
        //创建sql语句
        String sql = "insert into t_book values(?,?,?)";
        //调用方法实现
        Object[] args =  {book.getUserId(), book.getUsername(), book.getUstatus()};
        int update = jdbcTemplate.update(sql, args);
        System.out.println(update);

    }

    //修改
    @Override
    public void updateBook(Book book) {
        String sql = "update t_book set username = ?,ustatus = ? where user_id =?";
        Object[] args = {book.getUsername(),book.getUstatus(),book.getUserId()};
        int update = jdbcTemplate.update(sql, args);
        System.out.println(update);
    }

    //删除
    @Override
    public void deleteBook(int id) {

        String sql = "delete from t_book where user_id = ?";
        int update = jdbcTemplate.update(sql, id);
        System.out.println(update);
    }

    @Override
    public int selectCount() {
        String sql = "select count(*) from t_book";
        Integer count = jdbcTemplate.queryForObject(sql, Integer.class);
        return count;
    }

    //返回对象查询
    @Override
    public Book findBookInfo(int id) {
        String sql = "select * from t_book where user_id=?";
        //调用方法
        Book book = jdbcTemplate.queryForObject(sql, new BeanPropertyRowMapper<Book>(Book.class), id);
        return book;
    }

    //查询返回集合
    @Override
    public List<Book> findAllBook() {
        String sql = "select * from t_book";
        //调用方法
        List<Book> query = jdbcTemplate.query(sql, new BeanPropertyRowMapper<Book>(Book.class));

        return query;
    }

    //批量添加
    @Override
    public void batchAdd(List<Object[]> batchArgs) {
        String sql = "insert  into t_book values(?,?,?)";
        int [] ints = jdbcTemplate.batchUpdate(sql,batchArgs);
        System.out.println(Arrays.toString(ints));

    }

    @Override
    public void batchUpdate(List<Object[]> batchArgs) {
        String sql = "update t_book set username = ?,ustatus = ? where user_id =?";
        int[] ints = jdbcTemplate.batchUpdate(sql, batchArgs);
        System.out.println(Arrays.toString(ints));
    }

    @Override
    public void batchDelete(List<Object[]> batchArgs) {
        String sql = "delete from t_book where user_id=?";
        int[] ints = jdbcTemplate.batchUpdate(sql, batchArgs);
        System.out.println(Arrays.toString(ints));

    }
}
