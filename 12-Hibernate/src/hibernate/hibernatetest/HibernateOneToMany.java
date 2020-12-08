package hibernate.hibernatetest;

import hibernate.entity.Customer;
import hibernate.entity.Dept;
import hibernate.entity.Emp;
import hibernate.entity.LinkMan;
import hibernate.utils.HibernateUtils;
import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.Transaction;
import org.junit.Test;

/**
 * @author LXW
 * @creat2020-11-19-下午 2:40
 */
public class HibernateOneToMany {

    //演示一对多的级联保存
    @Test
    public void testAddDemo5() {
        SessionFactory sessionFactory = null;
        Transaction tx = null;
        Session session = null;
        try {

            sessionFactory = HibernateUtils.getSessionFactory();
            session = sessionFactory.openSession();
            //开启事务
            tx = session.beginTransaction();

            Dept dept = new Dept();
            dept.setDeptName("333");
//            Dept dept = session.get(Dept.class, 2);
            Emp emp1 = new Emp();
            emp1.setEmpName("lisi");

//            emp1.setDept(dept);
            dept.getSetEmp().add(emp1);

//            session.save(emp1);
            session.save(dept);

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

    //演示一对多的级联修改
    @Test
    public void testUpdateDemo() {
        SessionFactory sessionFactory = null;
        Transaction tx = null;
        Session session = null;
        try {

            sessionFactory = HibernateUtils.getSessionFactory();
            session = sessionFactory.openSession();
            //开启事务
            tx = session.beginTransaction();

            //1.根据id查询lucy联系人，根据id查询百度的客户
            Customer baidu = session.get(Customer.class, 2);
            LinkMan luck = session.get(LinkMan.class, 1);
            //2.设置持久态对象的值
            //把联系人放到客户里面
            baidu.getSetLinkMan().add(luck);
            //把客户放到联系人里面
            luck.setCustomer(baidu);



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
    //演示一对多的级联删除
    @Test
    public void testDeleteDemo() {
        SessionFactory sessionFactory = null;
        Transaction tx = null;
        Session session = null;
        try {

            sessionFactory = HibernateUtils.getSessionFactory();
            session = sessionFactory.openSession();
            //开启事务
            tx = session.beginTransaction();

            //1.根据id查询客户对象
            Customer customer = session.get(Customer.class,2);

            session.delete(customer);


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
    //演示一对多的级联保存
    @Test
    public void testAddDemo2() {
        SessionFactory sessionFactory = null;
        Transaction tx = null;
        Session session = null;
        try {

            sessionFactory = HibernateUtils.getSessionFactory();
            session = sessionFactory.openSession();
            //开启事务
            tx = session.beginTransaction();

            //添加一个客户，为这个客户添加一个联系人
            //1.创建客户和联系人对象
            Customer customer = new Customer();
            customer.setCustName("腾讯");
            customer.setCustLevel("普通客户");
            customer.setCustSource("网络");
            customer.setCustPhone("110");
            customer.setCustMobile("999");

            LinkMan linkMan = new LinkMan();
            linkMan.setLkm_name("小彭");
            linkMan.setLkm_gender("男");
            linkMan.setLkm_phone("911");

            //把联系人放到客户里面
            customer.getSetLinkMan().add(linkMan);

            //保存客户
            session.save(customer);
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
    //演示一对多的级联保存
    @Test
    public void testAddDemo1() {
        SessionFactory sessionFactory = null;
        Transaction tx = null;
        Session session = null;
        try {

            sessionFactory = HibernateUtils.getSessionFactory();
            session = sessionFactory.openSession();
            //开启事务
            tx = session.beginTransaction();

            Customer customer = session.get(Customer.class, 1);

            LinkMan linkMan = new LinkMan();
            linkMan.setLkm_name("李四");
            linkMan.setLkm_gender("男");
            linkMan.setLkm_phone("119");

            //2.在客户表示联系人，再联系人表示客户
            //建立客户对象和联系人对象的关系
            //2.1把联系人对象 放到客户对象的set集合里面
            customer.getSetLinkMan().add(linkMan);
            //2.2吧客户对象放到联系人对象里面
            linkMan.setCustomer(customer);

            //3.保存到数据库
            session.save(customer);
            session.save(linkMan);

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


}
