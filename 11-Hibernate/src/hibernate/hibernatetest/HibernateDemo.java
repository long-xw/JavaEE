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
public class HibernateDemo {

    @Test

    public void testAdd() {
        //第一步 加载hibernate核心配置文件
        //到src下面找到名称是hibernate.cfg.xml
        //在hibernate里面封装对象

//        Configuration cfg = new Configuration();
//        cfg.configure();

        //第二步 创建SessionFactory对象
        //读取hibernate核心配置文件内容，创建sessionFactory
        //过程中，根据映射关系，在配置数据库里面来创建

//        SessionFactory sessionFactory = cfg.buildSessionFactory();
        SessionFactory sessionFactory = HibernateUtils.getSessionFactory();

        //第三步 使用SessionFactory创建session对象
        //类似于连接
        Session session = sessionFactory.openSession();

        //第四步 开启事务
        Transaction tx = session.beginTransaction();

        //第五步 写具体逻辑crud操作
        User user = new User();
        user.setUsername("xiaoli");
        user.setPassword("123456");
        user.setAddress("中国");
        //调用session方法实现添加
        session.save(user);


        //第六步 提交事务
        tx.commit();

        //第七步 关闭资源
        session.close();
        sessionFactory.close();
    }

    @Test
    public void testUpdate(){
        //调用工具类得到sessionFactory
        SessionFactory sessionFactory = HibernateUtils.getSessionFactory();
        //获取session
        Session session =  sessionFactory.openSession();
        //开启事务
        Transaction transaction = session.beginTransaction();
        //修改操作
        //修改uid=2记录username的值
        User user = session.get(User.class,3);
        //向返回的user对象里面设置修改之后的值
        user.setUsername("wang");
        //调用session的方法update
        session.update(user);
        //提交事务
        transaction.commit();
        //资源关闭
        session.close();
        sessionFactory.close();
    }

    @Test
    public void testDelete() {
        //调用工具类得到sessionFactory
        SessionFactory sessionFactory = HibernateUtils.getSessionFactory();
        //获取session
        Session session =  sessionFactory.openSession();
        //开启事务
        Transaction transaction = session.beginTransaction();
        //删除操作
        //第一种 根据id查询对象
//        User user = session.get(User.class,3);
//        session.delete(user);
        //第二种
        User user = new User();
        user.setUid(3);
        session.delete(user);

        //提交事务
        transaction.commit();
        //资源的关闭
        session.close();
        sessionFactory.close();
    }
    @Test
    public void testSaveOrUpdate() {
        //调用工具类得到sessionFactory
        SessionFactory sessionFactory = HibernateUtils.getSessionFactory();
        //获取session
        Session session =  sessionFactory.openSession();
        //开启事务
        Transaction transaction = session.beginTransaction();

//        User user= new User();
//        user.setUid((1));
//        user.setUsername("mary");
//        user.setAddress("USA");
//        user.setPassword("13456");
//        session.save(user);

        //把uid=1记录username修改
//        User user = new User();
//        user.setUid(1);
//        user.setUsername("Tom");
//        session.update(user);


        //1.添加操作
//        User user = new User();
//        user.setUsername("Jack");
//        user.setPassword("520");
//        user.setAddress("朝鲜");
//
//        session.saveOrUpdate(user);


//        User user = new User();
//        user.setUid(5);
//        user.setUsername("Rose");
//        user.setPassword("321");
//        user.setAddress("USA");

//        session.saveOrUpdate(user);

        User user = session .get(User.class,5);
        user.setUsername("lilei");

        //实体类对象状态是托管态，做修改
        session.saveOrUpdate(user);



        //提交事务
        transaction.commit();
        //资源的关闭
        session.close();
        sessionFactory.close();
    }
    @Test
    public void testGet() {
        //掉用工具类得到sessionFactory

        SessionFactory sessionFactory = HibernateUtils.getSessionFactory();
        //获取session
        Session session =  sessionFactory.openSession();
        //开启事务
        Transaction transaction = session.beginTransaction();


//        User u = new User();
//        u.setUsername("jack");
//        u.setPassword("124");
//        u.setAddress("china");
//
//        session.save(u);


        //根据id查询
        //调用session里面的get方法
        //第一个参数：实体类的class
        //第二个参数：id值
        User user = session.get(User.class,3);
        System.out.println(user);



        //提交事务
        transaction.commit();
        //关闭资源
        session.close();
        sessionFactory.close();
    }


}
