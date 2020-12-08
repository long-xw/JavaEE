package hibernate.hibernatetest;

import hibernate.entity.Customer;
import hibernate.utils.HibernateUtils;
import org.hibernate.*;
import org.hibernate.criterion.DetachedCriteria;
import org.hibernate.criterion.Order;
import org.hibernate.criterion.Projections;
import org.hibernate.criterion.Restrictions;
import org.junit.Test;

import java.util.List;
import java.util.Properties;

/**
 * @author LXW
 * @creat2020-11-21-下午 9:03
 */
public class HibernateQBC {

    //演示离线查询
    @Test
    public void testSelect6() {
        SessionFactory sessionFactory = null;
        Session session = null;
        Transaction tx = null;
        try {
            sessionFactory = HibernateUtils.getSessionFactory();
            session = sessionFactory.openSession();
            tx = session.beginTransaction();

            //1.创建对象
//            Criteria criteria = session.createCriteria(Customer.class);
            DetachedCriteria detachedCriteria = DetachedCriteria.forClass(Customer.class);

            //2.最终执行的时候才需要到session
            Criteria criteria = detachedCriteria.getExecutableCriteria(session);

            List<Customer> list = criteria.list();

            for (Customer customer : list){
                System.out.println(customer.getCid() + " :  : " + customer.getCustName());
            }


            tx.commit();

        } catch (Exception e) {
            tx.rollback();
        } finally {
            session.close();
            sessionFactory.close();
        }
    }
    //演示统计查询
    @Test
    public void testSelect5() {
        SessionFactory sessionFactory = null;
        Session session = null;
        Transaction tx = null;
        try {
            sessionFactory = HibernateUtils.getSessionFactory();
            session = sessionFactory.openSession();
            tx = session.beginTransaction();

            //1.创建对象
            Criteria criteria = session.createCriteria(Customer.class);

           //2.设置操作
            criteria.setProjection(Projections.rowCount());

            //3.调用方法得到结果
            Object o = criteria.uniqueResult();

            Long lobj = (Long) o;
            int count = lobj.intValue();
            System.out.println(count);


            tx.commit();

        } catch (Exception e) {
            tx.rollback();
        } finally {
            session.close();
            sessionFactory.close();
        }
    }
    //演示分页查询
    @Test
    public void testSelect4() {
        SessionFactory sessionFactory = null;
        Session session = null;
        Transaction tx = null;
        try {
            sessionFactory = HibernateUtils.getSessionFactory();
            session = sessionFactory.openSession();
            tx = session.beginTransaction();

            //1.创建对象
            Criteria criteria = session.createCriteria(Customer.class);

           //2.设置分页的数据
            //2.1色设置开始位置
            criteria.setFirstResult(1);
            //2.2每页显示记录数
            criteria.setMaxResults(3);


            //3.调用方法得到集合
            List<Customer> list = criteria.list();

            for (Customer customer : list) {
                System.out.println(customer.getCid() + " :  : " + customer.getCustName());
            }


            tx.commit();

        } catch (Exception e) {
            tx.rollback();
        } finally {
            session.close();
            sessionFactory.close();
        }
    }
    //演示排序查询
    @Test
    public void testSelect3() {
        SessionFactory sessionFactory = null;
        Session session = null;
        Transaction tx = null;
        try {
            sessionFactory = HibernateUtils.getSessionFactory();
            session = sessionFactory.openSession();
            tx = session.beginTransaction();

            //1.创建对象
            Criteria criteria = session.createCriteria(Customer.class);

            //2.设置对哪个属性进行排序，设置排序规则
            criteria.addOrder(Order.desc("cid"));


            //3.调用方法得到集合
            List<Customer> list = criteria.list();

            for (Customer customer : list) {
                System.out.println(customer.getCid() + " :  : " + customer.getCustName());
            }


            tx.commit();

        } catch (Exception e) {
            tx.rollback();
        } finally {
            session.close();
            sessionFactory.close();
        }
    }
    //演示条件查询
    @Test
    public void testSelect2() {
        SessionFactory sessionFactory = null;
        Session session = null;
        Transaction tx = null;
        try {
            sessionFactory = HibernateUtils.getSessionFactory();
            session = sessionFactory.openSession();
            tx = session.beginTransaction();

            //1.创建对象
            Criteria criteria = session.createCriteria(Customer.class);
            //2.使用Criteria对象里面的方法设置条件值
            //首先使用add方法，表示设置条件值
            //在add方法里卖弄使用类的方法实现条件设置
            //类似于cid=？
//            criteria.add(Restrictions.eq("cid",1));
//            criteria.add(Restrictions.eq("custName","传智播客"));
            criteria.add(Restrictions.like("custName","%百%"));

            //3.调用方法得到集合
            List<Customer> list = criteria.list();

            for (Customer customer : list) {
                System.out.println(customer.getCid() + " :  : " + customer.getCustName());
            }


            tx.commit();

        } catch (Exception e) {
            tx.rollback();
        } finally {
            session.close();
            sessionFactory.close();
        }
    }
    //演示查询所有
    @Test
    public void testSelect1() {
        SessionFactory sessionFactory = null;
        Session session = null;
        Transaction tx = null;
        try {
            sessionFactory = HibernateUtils.getSessionFactory();
            session = sessionFactory.openSession();
            tx = session.beginTransaction();

            //1.创建对象
            Criteria criteria = session.createCriteria(Customer.class);
            //2.调用方法得到结果
            List<Customer> list = criteria.list();
            for (Customer customer : list) {
                System.out.println(customer.getCid() + " :  : " + customer.getCustName());
            }


            tx.commit();

        } catch (Exception e) {
            tx.rollback();
        } finally {
            session.close();
            sessionFactory.close();
        }
    }


}
