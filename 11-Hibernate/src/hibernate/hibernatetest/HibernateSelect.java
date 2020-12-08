package hibernate.hibernatetest;

import hibernate.entity.User;
import hibernate.utils.HibernateUtils;
import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.Transaction;
import org.junit.Test;


/**
 * @author LXW
 * @creat2020-11-16-下午 3:31
 */
public class HibernateSelect {

    //事务的规范代码
    @Test
    public void testTx() {
        SessionFactory sessionFactory = null;
        Transaction tx = null;
        Session session = null;
        try {
            session = HibernateUtils.getSessionobject();
            sessionFactory = HibernateUtils.getSessionFactory();
            //开启事务
             tx = session.beginTransaction();
             //添加
            User user = new User();
            user.setUsername("小二");
            user.setPassword("250");
            user.setAddress("USA");
            session.save(user);

//             int i = 10/0;
            //提交事务
            tx.commit();
        } catch (Exception e) {
            e.printStackTrace();
            tx.rollback();
        } finally {
            //关闭操作
//            session.close();
//            sessionFactory.close();

        }
    }


    //一级缓存的特性
    @Test
    public void testDemo() {
        //调用工具类得到sessionFactory
        SessionFactory sessionFactory = HibernateUtils.getSessionFactory();
        //获取session
        Session session =  sessionFactory.openSession();
        //开启事务
        Transaction transaction = session.beginTransaction();

        //1根据id查询
        User user = session.get(User.class, 5);

        //2.设置返回对象值
        user.setUsername("hanmeimei");

        //3.调用方法来实现
//        session.update(user);


        //提交事务
        transaction.commit();
        //资源的关闭
        session.close();
        sessionFactory.close();
    }
    @Test
    public void testCasch() {
        //调用工具类得到sessionFactory
        SessionFactory sessionFactory = HibernateUtils.getSessionFactory();
        //获取session
        Session session =  sessionFactory.openSession();
        //开启事务
        Transaction transaction = session.beginTransaction();

        //1.根据uid = 5 查询
        //执行第一个get方法是否查询数据库，是否发送sql语句
        User user1 = session.get(User.class,5);
        System.out.println(user1);

        //1.根据uid = 5 查询
        //执行第二个get方法是否查询数据库，是否发送sql语句
        User user2 = session.get(User.class,5);
        System.out.println(user2);


        //提交事务
        transaction.commit();
        //资源的关闭
        session.close();
        sessionFactory.close();
    }


}
