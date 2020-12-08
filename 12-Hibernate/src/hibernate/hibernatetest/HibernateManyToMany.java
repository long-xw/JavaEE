package hibernate.hibernatetest;

import hibernate.entity.Customer;
import hibernate.entity.LinkMan;
import hibernate.manytomany.Role;
import hibernate.manytomany.User;
import hibernate.utils.HibernateUtils;
import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.Transaction;
import org.junit.Test;

/**
 * @author LXW
 * @creat2020-11-19-下午 2:40
 */
public class HibernateManyToMany {

    //演示多对多级联保存
    @Test
    public void testSave() {
        SessionFactory sessionFactory = null;
        Transaction tx = null;
        Session session = null;
        try {

            sessionFactory = HibernateUtils.getSessionFactory();
            session = sessionFactory.openSession();
            //开启事务
            tx = session.beginTransaction();

            //添加两个用户，为每个用户添加两个角色
            //1 创建对象
            User user1 = new User();
            user1.setUser_name("lucy");
            user1.setUser_password("123");

            User user2 = new User();
            user2.setUser_name("mary");
            user2.setUser_password("456");

            Role r1 = new Role();
            r1.setRole_name("总经理");
            r1.setRole_memo("总经理");

            Role r2 = new Role();
            r2.setRole_name("秘书");
            r2.setRole_memo("秘书");

            Role r3 = new Role();
            r3.setRole_name("保安");
            r3.setRole_memo("保安");

            //2 建立关系，把角色放到用户里面
            // user1 -- r1/r2
            user1.getSetRole().add(r1);
            user1.getSetRole().add(r2);

            // user2 -- r2/r3
            user2.getSetRole().add(r2);
            user2.getSetRole().add(r3);

            //3 保存用户
            session.save(user1);
            session.save(user2);


            //提交事务
            tx.commit();
        } catch (Exception e) {
            tx.rollback();
        } finally {
            //关闭操作
            session.close();
//            sessionFactory.close();

        }
    }
    //演示多对多级联删除
    @Test
    public void testDelete() {
        SessionFactory sessionFactory = null;
        Session session = null;
        Transaction tx = null;
        try {
            //得到sessionFactory
            sessionFactory = HibernateUtils.getSessionFactory();
            //得到session
            session = sessionFactory.openSession();
            //开启事务
            tx = session.beginTransaction();

            User user = session.get(User.class, 4);
            session.delete(user);
            //提交事务
            tx.commit();

        }catch(Exception e) {
            tx.rollback();
        }finally {
            session.close();
            //sessionFactory不需要关闭
            sessionFactory.close();
        }
    }
    //维护第三章张的操作
    @Test
    public void testTable1() {
        SessionFactory sessionFactory = null;
        Session session = null;
        Transaction tx = null;
        try {
            //得到sessionFactory
            sessionFactory = HibernateUtils.getSessionFactory();
            //得到session
            session = sessionFactory.openSession();
            //开启事务
            tx = session.beginTransaction();

            //让某个用户一有某个角色
            //让lucy有经纪人的角色
            //1.查找lucy和经纪人
            User lucy = session.get(User.class, 3);
            Role role = session.get(Role.class, 7);
            //2.把角色放到用户的set集合里面
            lucy.getSetRole().add(role);


            //提交事务
            tx.commit();

        }catch(Exception e) {
            tx.rollback();
        }finally {
            session.close();
            //sessionFactory不需要关闭
            sessionFactory.close();
        }
    }
    //维护第三章张的操作
    @Test
    public void testTable2() {
        SessionFactory sessionFactory = null;
        Session session = null;
        Transaction tx = null;
        try {
            //得到sessionFactory
            sessionFactory = HibernateUtils.getSessionFactory();
            //得到session
            session = sessionFactory.openSession();
            //开启事务
            tx = session.beginTransaction();

            //让某个用户没有某个角色
            //让lucy有经纪人的角色
            //1.查找lucy和经纪人
            User lucy = session.get(User.class, 3);
            Role role = session.get(Role.class, 7);
            //2.从用户里面把角色给去掉
            lucy.getSetRole().remove(role);



            //提交事务
            tx.commit();

        }catch(Exception e) {
            tx.rollback();
        }finally {
            session.close();
            //sessionFactory不需要关闭
            sessionFactory.close();
        }
    }

}
