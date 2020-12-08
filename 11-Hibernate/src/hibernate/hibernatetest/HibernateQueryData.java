package hibernate.hibernatetest;


import hibernate.entity.User;
import hibernate.utils.HibernateUtils;
import org.hibernate.*;
import org.junit.Test;

import java.util.List;


/**
 * @author LXW
 * @creat2020-11-16-下午 3:31
 */
public class HibernateQueryData {

    //使用SQLQuery对象
    @Test
    public void testSQLQuery() {
        SessionFactory sessionFactory = null;
        Transaction tx = null;
        Session session = null;
        try {

            sessionFactory = HibernateUtils.getSessionFactory();
            session = sessionFactory.openSession();
            //开启事务
             tx = session.beginTransaction();

            //1.创建对象
            //普通sql语句
            SQLQuery sqlQuery = session.createSQLQuery("select * from t_user");

            //返回list中每部分都是一个对象形式
            sqlQuery.addEntity(User.class);
            //调用sqlQuery里面的方法
            List<User> list = sqlQuery.list();

            for (User user : list) {
                System.out.println(user);
            }


            //调用sqlQuery里面方法
            //返回list集合，默认里面部分数组结构
//            List<Object[]> list = sqlQuery.list();
//            for (Object[] objects : list) {
//                System.out.println(Arrays.toString(objects));
//            }

            //提交事务
            tx.commit();
        } catch (Exception e) {
            e.printStackTrace();
            tx.rollback();
        } finally {
            //关闭操作
            session.close();
            sessionFactory.close();

        }
    }
    //使用criteria对象
    @Test
    public void testCriteria() {
        SessionFactory sessionFactory = null;
        Transaction tx = null;
        Session session = null;
        try {

            sessionFactory = HibernateUtils.getSessionFactory();
            session = sessionFactory.openSession();
            //开启事务
             tx = session.beginTransaction();

             //1.创建一个Criteria对象;
            Criteria criteria = session.createCriteria(User.class);
            //调用里面的方法得到结果
            List<User> list = criteria.list();
            for (User user : list) {
                System.out.println(user);
            }

            //提交事务
            tx.commit();
        } catch (Exception e) {
            e.printStackTrace();
            tx.rollback();
        } finally {
            //关闭操作
            session.close();
            sessionFactory.close();

        }
    }
    //使用Query对象
    @Test
    public void testQuery() {
        SessionFactory sessionFactory = null;
        Transaction tx = null;
        Session session = null;
        try {

            sessionFactory = HibernateUtils.getSessionFactory();
            session = HibernateUtils.getSessionobject();
            //开启事务
             tx = session.beginTransaction();

             //1.创建一个Query对象;
            //方法里的hql语句
            Query query = session.createQuery("from User");

            //2.调用query对象里面的方法得到结果
            List<User> list = query.list();

            for (User user : list) {
                System.out.println(user);
            }

            //提交事务
            tx.commit();
        } catch (Exception e) {
            e.printStackTrace();
            tx.rollback();
        } finally {
            //关闭操作
//            session.close();
            sessionFactory.close();

        }
    }


}
