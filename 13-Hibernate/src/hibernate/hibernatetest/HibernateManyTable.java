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

/**
 * @author LXW
 * @creat2020-11-21-下午 9:03
 */
public class HibernateManyTable {

    //演示hql左外连接查询
    @Test
    public void testSelect2() {
        SessionFactory sessionFactory = null;
        Session session = null;
        Transaction tx = null;
        try {
            sessionFactory = HibernateUtils.getSessionFactory();
            session = sessionFactory.openSession();
            tx = session.beginTransaction();

            Query query = session.createQuery("from Customer c left outer join fetch c.setLinkMan");

            List<Customer> list = query.list();

            System.out.println(list.size());

            tx.commit();

        } catch (Exception e) {
            tx.rollback();
        } finally {
            session.close();
            sessionFactory.close();
        }
    }
    //演示hql内连接查询
    @Test
    public void testSelect1() {
        SessionFactory sessionFactory = null;
        Session session = null;
        Transaction tx = null;
        try {
            sessionFactory = HibernateUtils.getSessionFactory();
            session = sessionFactory.openSession();
            tx = session.beginTransaction();

            Query query = session.createQuery("from Customer c inner join fetch c.setLinkMan");

            List<Customer> list = query.list();



            tx.commit();

        } catch (Exception e) {
            tx.rollback();
        } finally {
            session.close();
            sessionFactory.close();
        }
    }


}
