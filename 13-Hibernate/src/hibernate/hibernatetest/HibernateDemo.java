package hibernate.hibernatetest;

import hibernate.entity.Customer;
import hibernate.entity.LinkMan;
import hibernate.utils.HibernateUtils;
import org.hibernate.Criteria;
import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.Transaction;
import org.junit.Test;

import java.util.List;
import java.util.Set;

/**
 * @author LXW
 * @creat2020-11-21-下午 9:03
 */
public class HibernateDemo {

    //演示批量抓取
    @Test
    public void testSelect4() {
        SessionFactory sessionFactory = null;
        Session session = null;
        Transaction tx = null;
        try {
            sessionFactory = HibernateUtils.getSessionFactory();
            session = sessionFactory.openSession();
            tx = session.beginTransaction();

            //查询所有客户
            Criteria criteria = session.createCriteria(Customer.class);

            List<Customer> list = criteria.list();
            //得到每个客户里面所有的联系人
            for(Customer customer : list) {
                System.out.println(customer.getCid() + " : :" + customer.getCustName());
                //每个客户里面所有的联系人
                Set<LinkMan> linkMEN = customer.getSetLinkMan();
                for (LinkMan linkMan : linkMEN) {
                    System.out.println(linkMan.getLkm_id() + ": :" + linkMan.getLkm_name());
                }
            }


            tx.commit();

        } catch (Exception e) {
            tx.rollback();
        } finally {
            session.close();
            sessionFactory.close();
        }
    }
    //演示检索策略
    @Test
    public void testSelect3() {
        SessionFactory sessionFactory = null;
        Session session = null;
        Transaction tx = null;
        try {
            sessionFactory = HibernateUtils.getSessionFactory();
            session = sessionFactory.openSession();
            tx = session.beginTransaction();

            //查询cid=1的客户，在查询这个客户里面所有的联系人
            Customer customer = session.get(Customer.class, 1);
            //在查询这个客户里面所有的联系人
            //直接得到客户里面的set集合
            //得到set集合，是否会发送语句
            Set<LinkMan> linkman = customer.getSetLinkMan();
            System.out.println(linkman.size());


            tx.commit();

        } catch (Exception e) {
            tx.rollback();
        } finally {
            session.close();
            sessionFactory.close();
        }
    }
    //演示检索策略
    @Test
    public void testSelect2() {
        SessionFactory sessionFactory = null;
        Session session = null;
        Transaction tx = null;
        try {
            sessionFactory = HibernateUtils.getSessionFactory();
            session = sessionFactory.openSession();
            tx = session.beginTransaction();

            //查询cid=1的客户，
            //执行get方法之后，是否发送SQL语句
//            Customer customer = session.get(Customer.class, 1);
//            System.out.println(customer.getCid());

            /**
             * 1.调用load方法之后，不会马上发送sql语句
             * （1） 返回对象里面只有id值
             *
             * 2.得到对象里面不是id的其他值时就会发送语句
             */
            Customer customer = session.load(Customer.class, 2);

            System.out.println(customer.getCid());
            System.out.println(customer.getCustName());

            tx.commit();

        } catch (Exception e) {
            tx.rollback();
        } finally {
            session.close();
            sessionFactory.close();
        }
    }
    //演示对象导航操作
    @Test
    public void testSelect() {
        SessionFactory sessionFactory = null;
        Session session = null;
        Transaction tx = null;
        try {
            sessionFactory = HibernateUtils.getSessionFactory();
            session = sessionFactory.openSession();
            tx = session.beginTransaction();

            //查询cid=1的客户，在查询这个客户里面所有联系人
            Customer customer = session.get(Customer.class, 1);
            //在查询这个客户里面所有人
            //直接得到客户里面set集合
            Set<LinkMan> setLinkMan = customer.getSetLinkMan();

            System.out.println(setLinkMan.size());

            tx.commit();

        } catch (Exception e) {
            tx.rollback();
        } finally {
            session.close();
            sessionFactory.close();
        }
    }


}
